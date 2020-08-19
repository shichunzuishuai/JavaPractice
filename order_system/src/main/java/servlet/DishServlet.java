package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Dish;
import model.DishDao;
import model.User;
import util.OrderSystemException;
import util.OrderSystemUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/dish")
public class DishServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    static class Request{
        private String name;
        private int price;
    }
    static class Response{
        private int ok;
        private String reason;
    }

    //新增菜品
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            //1.检查用户的登录状态
            HttpSession session = req.getSession(false);
            if(session == null){
                throw new OrderSystemException("当前未登录");
            }
            User user = (User) session.getAttribute("user");
            if(user == null){
                throw new OrderSystemException("当前未登录");
            }
            //2.检查用户是不是管理员
            if(user.getIsAdmin() == 0){
                throw new OrderSystemException("你不是管理员");
            }
            //3.读取请求body
            String body = OrderSystemUtil.readBody(req);
            //4.把body转成request对象
            Request request = gson.fromJson(body,Request.class);
            //构造Dish对象,插入到数据库
            Dish dish = new Dish();
            dish.setName(request.name);
            dish.setPrice(request.price);
            DishDao dishDao = new DishDao();
            dishDao.add(dish);
            //6.返回结果给客户端
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }



    }


    //删除菜品

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            //1.检查用户是否登录
            HttpSession session = req.getSession(false);
            if(session == null){
                throw new OrderSystemException("你当前未登录");
            }
            User user = (User) session.getAttribute("user");
            if(user == null){
                throw new OrderSystemException("你当前未登录");
            }
            //2.判断用户是不是管理员
            if(user.getIsAdmin() == 0){
                throw new OrderSystemException("你不是管理员");
            }
            //3.读取到dishId
            String dishIdStr = req.getParameter("dishId");
            if(dishIdStr == null){
                throw new OrderSystemException("dish的参数不正确");
            }
            int dishId = Integer.parseInt(dishIdStr);
            //4.删除数据库中对应的记录
            DishDao dishDao = new DishDao();
            dishDao.delete(dishId);
            //5.返回响应结果
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }

    //查看所有菜品

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Response response = new Response();
        List<Dish> dishes = new ArrayList<>();
        try {
            //1.先检查用户是否登录
            HttpSession session = req.getSession(false);
            if(session == null){
                throw new OrderSystemException("你当前未登录");
            }
            User user = (User)session.getAttribute("user");
            if(user == null){
                throw new OrderSystemException("你当前未登录");
            }
            //2.读取数据库数据
            DishDao dishDao = new DishDao();
             dishes = dishDao.selectAll();
            //3.返回相应结果
            String jsonString = gson.toJson(dishes);
            resp.getWriter().write(jsonString);

        } catch (OrderSystemException e) {
            //失败的时候返回一个空的数组
           String jsonString = gson.toJson(dishes);
           resp.getWriter().write(jsonString);
        }
    }
}

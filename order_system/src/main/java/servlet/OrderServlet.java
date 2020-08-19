package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Dish;
import model.Order;
import model.OrderDao;
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
//订单相关操作的
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    //这个类是订单相关操作的
    //整个类所有需要的api,只有新智订单需要body,
    //新增body也是一个数组,所以不用创建专门的类来表示请求的body了
    static class Response {
        private int ok;
        private String reason;
    }

    //新增订单,只有普通用户可以新增订单,管理员不行
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.检查用户是否登录
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Response response = new Response();
        try {
            //1.先检查用户是否登录
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("你当前未登录");
            }
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("你当前未登录");
            }
            //判断用户是不是管理员
            if (user.getIsAdmin() == 1) {
                throw new OrderSystemException("您是管理员");
            }
            //读取body中的内容,进行解析
            String body = OrderSystemUtil.readBody(req);
            //按照JSON格式解析body
            //List<Integer> dishIds = gson.fromJson(body,new TypeToken<Integer>() {}.getType());
            Integer[] dishIds = gson.fromJson(body,Integer[].class);
            //构造订单对象
            Order order = new Order();
            order.setUserId(user.getUserId());
            List<Dish> dishes = new ArrayList<>();
            for (Integer dishId: dishIds) {
                Dish dish = new Dish();
                dish.setDishId(dishId);
                dishes.add(dish);
            }
            order.setDishes(dishes);

            //把order队象插入到数据库
            OrderDao orderDao = new OrderDao();
            orderDao.add(order);
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        }finally {
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
         }
    }

    //查看所有订单
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response response = new Response();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        List<Order> orderList = new ArrayList<>();
        try {
            //1.判断用户是否登录
            HttpSession session = req.getSession(false);
            if(session == null){
                throw new OrderSystemException("你当前未登录");
            }
            User user = (User) session.getAttribute("user");
            if(user == null){
                throw new OrderSystemException("你当前未登录");
            }

            //2..读取orderId字段,看该字段是否存在
            String orderIdStr = req.getParameter("orderId");
            OrderDao orderDao = new OrderDao();
            if(orderIdStr == null){
                //3..查找数据库数据

                if(user.getIsAdmin() == 0){
                    //普通用户,只能查看自己的id
                    orderList = orderDao.selectByUserId(user.getUserId());
                }else {
                    //管理员,查看所有id
                    orderList = orderDao.selectAll();
                }
                //4..构造相应结果
                String jsonString = gson.toJson(orderList);
                resp.getWriter().write(jsonString);
            }else {
                //3.查找数据库,查找指定订单
                int orderId = Integer.parseInt(orderIdStr);
                Order order = orderDao.selectById(orderId);
                //4.构造相应结果
                String jsonString = gson.toJson(order);
                resp.getWriter().write(jsonString);
            }
        } catch (OrderSystemException e) {
            //5.处理异常

            String jsonString = gson.toJson(orderList);
            resp.getWriter().write(jsonString);
        }
    }
    //修改订单状态

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.价差用户是否登录
        Response response = new Response();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        try {
            //1.判断用户是否登录
            HttpSession session = req.getSession(false);
            if(session == null){
                throw new OrderSystemException("你当前未登录");
            }
            User user = (User) session.getAttribute("user");
            if(user == null){
                throw new OrderSystemException("你当前未登录");
            }
            //2.判断用户是不是管理员
            if (user.getIsAdmin() == 0) {
                throw new OrderSystemException("您不是是管理员");
            }
        //3.读取请求中的字段orderId和isDone
            String orderIdStr = req.getParameter("orderId");
            String isDoneStr = req.getParameter("isDone");
            if(orderIdStr == null || isDoneStr == null){
                throw new OrderSystemException("参数有误");
            }
            //4.修改数据库
            OrderDao orderDao = new OrderDao();
            int orderId = Integer.parseInt(orderIdStr);
            int isDone = Integer.parseInt(isDoneStr);
            orderDao.changeState(orderId,isDone);
            //5.返回相应结果
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason  = e.getMessage();
        }finally {
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
}

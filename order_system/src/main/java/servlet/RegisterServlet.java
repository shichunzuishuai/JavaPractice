package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.User;
import model.UserDao;
import util.OrderSystemException;
import util.OrderSystemUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();
    //读取的GSON请求对象
    static class Request{
        public String name;
        public String password;
    }

    //构造的GSON响应对象
    static class Response{
        public int ok;
        public String reason;
    }
    //注册
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response response = new Response();
        try {
            //1.读取body中的数据
            String body = OrderSystemUtil.readBody(req);
            //2.把body中的数据解析成Requset对象(GSON)
            Request request = gson.fromJson(body,Request.class);
            //3.查询数据库,看看当前用户名是否存在(如存在,提示已经被注册)
            UserDao userDao = new UserDao();
            User exitUser = userDao.selectByName(request.name);
            if(exitUser != null){
                //说明当前用户名重复了返回一个注册失败的信息
                throw new OrderSystemException("当前用户名已经存在");
            }
            //4.用户名不存在,把提交的用户名,密码构造成User对象,插入数据库
            User user = new User();
            user.setName(request.name);
            user.setPassword(request.password);
            user.setIsAdmin(0);
            userDao.add(user);
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        }finally {
            //5.构造相应数据
            String jsonString = gson.toJson(response);
            resp.setContentType("application/json; charset = UTF-8");
            resp.getWriter().write(jsonString);
        }
    }
}

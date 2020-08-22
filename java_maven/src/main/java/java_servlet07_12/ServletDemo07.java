package java_servlet07_12;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

//服务器给浏览器写回cookie
public class ServletDemo07 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.先创建Cookie对象,每个Cookie就是一个键值对
        Cookie useName = new Cookie("useName","lsc");
        Cookie age = new Cookie("age",20 + "");
        //2.把Cookie放到响应中
        resp.addCookie(useName);
        resp.addCookie(age);
        //3.创建一个响应报文段
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("返回Cookie成功");
    }
}

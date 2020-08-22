package java_servlet07_12;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//通过读取请求,获取浏览器发来的Cookie内容
public class ServletDemo08 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("<html>");
        for (Cookie cookie : cookies) {
            resp.getWriter().write(cookie.getName() + ": " + cookie.getValue());
            resp.getWriter().write("</br>");
        }
        resp.getWriter().write("</html>");

    }
}

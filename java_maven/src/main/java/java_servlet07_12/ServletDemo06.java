package java_servlet07_12;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo06 extends HttpServlet {
    //返回一个重定向的页面

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方法一.
         //resp.sendRedirect("http://www.sogou.com") ;
        //上面的或者下面额两种方法都行
        //方法二.
        resp.setStatus(302);
        resp.setHeader("Location","http://www.sogou.com");
    }
}

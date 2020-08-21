package java_servlet07_12;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ServletDemo02 extends HttpServlet {
    @Override
    //如何处理表单提交的数据
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        //构造响应页面
        resp.setContentType("text/html; charset=utf-8");
        //注意,一旦调用了getWriter方法,header的内容具不能修改了
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("firstName: " + firstName);
        writer.write("<br/>");
        writer.write("secondName: " + secondName);
        writer.write("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

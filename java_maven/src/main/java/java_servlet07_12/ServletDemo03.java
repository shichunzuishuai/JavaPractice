package java_servlet07_12;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

public class ServletDemo03 extends HttpServlet {
    //遍历获取head中所有的所有内容

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        Writer writer = resp.getWriter();
        writer.write("<html>");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            writer.write(header + ": " + req.getHeader(header));
            writer.write("<br/>");
        }
        writer.write("</html>");
    }
}

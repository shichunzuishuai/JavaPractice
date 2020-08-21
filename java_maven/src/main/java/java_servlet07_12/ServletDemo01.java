package java_servlet07_12;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ServletDemo01 extends HttpServlet {
    //简单演示HTTPServletRequest类中的一些基本API的用法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //返回请求主题中使用的字符编码的名称
        String encoding = req.getCharacterEncoding();
        //返回请求主题MIME的类型,不知道返回NULL
        String contentType = req.getContentType();
        //返回指示请求上下文的请求 URI 部分。
        String contextPath = req.getContextPath();
        //以字符串形返回指定的请求的值的头
        String ua = req.getHeader("User-Agent");
        String host = req.getHeader("Host");
        //返回请求HTTP方法的名称,如GET,POST,PUT
        String method = req.getMethod();
        //返回请求协议的名称和版本
        String protocol = req.getProtocol();
        //返回包含在路径后的请求URL中的查询字符串
        String queryString = req.getQueryString();
        //从协议名称直到 HTTP 请求的第一行的查询字符串中，返回该请求的 URL 的
        //一部分。
        String url = req.getRequestURI();
        //返回请求主题的长度
        int contentLength = req.getContentLength();
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("encoding: " + encoding);
        writer.write("<br/>");
        writer.write("contentType: " + contentType);
        writer.write("<br/>");
        writer.write("contextPath: " + contextPath);
        writer.write("<br/>");
        writer.write("ua: " + ua);
        writer.write("<br/>");
        writer.write("host: " + host);
        writer.write("<br/>");
        writer.write("method: " + method);
        writer.write("<br/>");
        writer.write("protocol: " + protocol);
        writer.write("<br/>");
        writer.write("queryString: " + queryString);
        writer.write("<br/>");
        writer.write("url: " + url);
        writer.write("<br/>");
        writer.write("contentLength: " + contentLength);
        writer.write("<br/>");
        writer.write("</html>");
    }
}

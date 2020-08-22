package java_servlet07_12;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

public class ServletDemo09 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.先获取到Session对象,如果用户没有登陆过,就创建新的Session
        //  如果用户登陆过了,就获取到曾经的Session
        //新用户访问:
        //这个操作会自动生成一个SessionId,并创建一个HttpSession 对象
        //把这个键值对放进内置的Hash表中,同事吧SessionId写回浏览器的Cookie中
        //老用户访问:
        //根据请求中Cookie里的SessionId,在hash表中查,找到对应的session对象
        HttpSession httpSession = req.getSession();
        //2.判断是不是新用户
        Integer count = 1;
        if(httpSession.isNew()){
            //新用户
            //吧count的值写入到Session中
            //httpSession也可以当成一个Hash表
            httpSession.setAttribute("count",1);
        }else {
            //老用户
            count = (Integer) httpSession.getAttribute("count"); ;
            count = count + 1;
            httpSession.setAttribute("count",count);
        }
        //3.返回相应页面
        resp.setContentType("text/html; charset=utf-8");
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("count: " + count  );
        writer.write("</html>");

    }
}

package java_servlet07_13;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

//上传文件时一定要写上下面的东西,要不会识别不出来是上传文件
@MultipartConfig
public class ServletDemo10 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收到图片直接保存在指定的目录中
        String basePath = "d:/test/images/";
        Part image = req.getPart("image");
        //下面这个方法就能得到上传文件的名称
        String path = basePath + image.getSubmittedFileName();
        image.write(path);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("上传图片成功");
    }
}

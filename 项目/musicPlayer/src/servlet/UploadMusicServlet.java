package servlet;

import entity.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 将音乐上传到服务器
 */
public class UploadMusicServlet extends HttpServlet {

    //private final String SAVEPATH = "D:\\JavaPractice\\项目\\musicPlayer\\web\\music\\";
    private final String SAVEPATH = "/root/java16/apache-tomcat-8.5.57/webapps/onLineMusic/music/";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        User usr = (User)req.getSession().getAttribute("user");
        if(usr == null){
            System.out.println("请登录后在上传音乐");
            resp.getWriter().write("<h2>请登录后在上传音乐</h2>");
            return;
        }else {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> fileItems = null;
            try {
                fileItems = upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
                return;
            }
            System.out.println("fileItems" +fileItems);

            FileItem fileItem = fileItems.get(0);
            System.out.println(fileItem);


            String fileName = fileItem.getName();
            req.getSession().setAttribute("fileName",fileName);

            try {
                fileItem.write(new File(SAVEPATH,fileName));
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }finally {
            }
            //2.上传到数据库
            resp.sendRedirect("uploadsucess.html");
        }

    }
}

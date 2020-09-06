package servlet;

import entity.User;
import service.MusicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将音乐信息写入到数据库中
 */
public class UploadInsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String singer = req.getParameter("singer");

        //这样拿到的歌后缀有.mp3,所以要去掉
        String fileName = (String)req.getSession().getAttribute("fileName");
        String[] strings = fileName.split("\\.");
        //拿到title
        String title = strings[0];

        //拿到时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        String time = sdf.format(new Date());


        User usr = (User)req.getSession().getAttribute("user");
        int user_id = usr.getId();
        String url = "music/" + title;

        MusicService musicService = new MusicService();
        int ret = musicService.insert(title,singer,time,url,user_id);
        if(ret == 1){
            resp.sendRedirect("list.html");
        }
    }
}

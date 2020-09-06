package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Music;
import entity.User;
import service.MusicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 从喜欢音乐列表中查找音乐
 */
public class FindLoveMusicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String loveMusicName = req.getParameter("loveMusicName");

        MusicService musicService = new MusicService();
        User usr = (User)req.getSession().getAttribute("user");
        int user_id = usr.getId();
        List<Music> musicList = new ArrayList<>();
        if(loveMusicName != null){
            musicList = musicService.ifMusicLove(loveMusicName,user_id);
        }else {
            musicList = musicService.findLoveMusic(user_id);
        }

        //返回给前端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),musicList);


    }
}

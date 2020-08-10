package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import service.MusicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 将音乐添加到喜欢列表
 */
public class LoveMusicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String idStr = req.getParameter("id");
        int music_id = Integer.parseInt(idStr);

        User user = (User)req.getSession().getAttribute("user");
        int userId = user.getId();

        Map<String,Object> return_map = new HashMap<>();
        MusicService musicService = new MusicService();
        //先查找这首歌以前是否被你添加过喜欢
        //boolean effect = musicService.findMusicByMusicId(userId,musicId);
           boolean flag = musicService.insertLoveMusic(userId,music_id);
           if(flag){
               return_map.put("msg",true);
           }else {
               return_map.put("msg",false);

        }

        //返回给前端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);

    }
}

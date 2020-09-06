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
 * 将音乐从喜欢的列表删除
 */
public class RemoveLoveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        User user = (User)req.getSession().getAttribute("user");
        int user_id = user.getId();

        String idStr = req.getParameter("id");
        int musicId = Integer.parseInt(idStr);

        MusicService musicService = new MusicService();
        int ret = musicService.removeLoveMusic(user_id,musicId);
        Map<String,Object> return_map = new HashMap<>();
        if(ret == 1){
            return_map.put("msg",true);
        }else {
            return_map.put("msg",false);
        }


        //返回给前端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);
    }
}

package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Music;
import service.MusicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 删除某个音乐
 */
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);

        MusicService musicService = new MusicService();
        Music music = musicService.findMusicById(id);
        if(music == null){
            return;
        }
        int delete = musicService.deleteMusicById(id);

        Map<String,Object> return_map = new HashMap<>();
        if(delete == 1){
            //仅仅代表数据库的音乐删除了,服务器上的还没有删除
            File file = new File("/root/java16/apache-tomcat-8.5.57/webapps/onLineMusic/" + music.getUrl()+".mp3");
            System.out.println(file);
            System.gc();
            if(file.delete()){
                return_map.put("msg",true);
                System.out.println("服务器删除成功");
            }else {
                return_map.put("msg",false);
                System.out.println("服务器删除失败");
            }
        }else {
            return_map.put("msg",false);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);

    }
}

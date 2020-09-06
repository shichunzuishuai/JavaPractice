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
 * 删除选中的所有音乐
 */
public class DeleteSelMusicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        MusicService musicService = new MusicService();
        //values中存放所要删除个去的id
       String values[] = req.getParameterValues("id[]");
       int sum = 0;
        Map<String,Object> return_map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            int id = Integer.parseInt(values[i]);
            Music music = musicService.findMusicById(id);
            int delete = musicService.deleteMusicById(id);
            if(delete == 1){
                File file = new File("/root/java16/apache-tomcat-8.5.57/webapps/onLineMusic/" + music.getUrl()+".mp3");

                if(file.delete()){
                    sum++;
                }else {
                    return_map.put("msg",false);
                    System.out.println("服务器删除失败");
                }
            }else {
                return_map.put("msg",false);
                System.out.println("数据库中数据删除失败");
            }

        }
        if(sum == values.length){
            return_map.put("msg",true);
        }else {
            return_map.put("msg",false);
        }
        //返回给前端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);

    }
}

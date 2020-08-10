package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 注册
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");

        System.out.println(username);
        System.out.println(password);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(email);



        User registerUser = new User();
        registerUser.setUsername(username);
        registerUser.setPassword(password);
        registerUser.setAge(Integer.parseInt(age));
        registerUser.setGender(gender);
        registerUser.setEmail(email);


        UserService userService = new UserService();
        boolean flag = userService.exit(registerUser.getUsername());
        int user = 0;
        if(flag == false) {
             user = userService.register(registerUser);
        }
        System.out.println(flag);

        Map<String,Object> return_map = new HashMap<>();
        if(user != 0 ){
            System.out.println("注册成功");
            //将该用户写到session中
            return_map.put("msg",true);
        }else {
            System.out.println("注册失败");
            return_map.put("msg",false);
        }

        //如何将return_map返回给前端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);

    }
}

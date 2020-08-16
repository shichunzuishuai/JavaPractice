package frank.controller;

import frank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//@Controller当前类型注册实例到容器中,并指定web请求的处理
@Controller
//@RequestMapping可以定义请求相关的配置,如路径,请求方法等
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Map<Integer, String> test1;

    //方式一:
//    @Autowired
//    @Qualifier("user1")
//    private User user;//变量名和bean的名称不一致,要加上@Qualifier指定bean的名称
//    private User user1;

    //方式二:
    @Resource(name = "user1")
    private User user;//变量名和bean的名称不一致, @Resource要制定name为bean的名称

    @RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object login() {
//        Map<String,String> map = new HashMap<>();
//        map.put("man","博哥");
//        map.put("tea","湯神");
//        return map;
        //模拟用户登录在数据库校验用户名密码
        return user;
    }

    @RequestMapping("/m")
    public String m() {
        return "/main.html";
    }

    @RequestMapping("/l1")
    public String l1() {
        //返回路径 不带/:以当前请求路径为相对位置
        // 带/: 会去掉当前路径,以项目的部署路径为相对位置
        //return "forward:login";//转发到user/login
        return "forward:/user/login";//一项目路径查找login
    }

    @RequestMapping("/l2")
    public String l2() {
        return "redirect:/user/login";
    }

    @RequestMapping("/test/{key}")//路径中使用变量占位符
    @ResponseBody
    public Object test1(@PathVariable("key") Integer k) {
        System.out.println("===============" + test1.get(k));
        return test1;
    }

    //请求GET /user/test2?k1=v1&k2=v2&k3=v3
    @RequestMapping(value = "/test2", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object test2(
            //可以匹配url中的参数，请求体k1=v1&k2=v2格式的数据
            //x-www-form-urlencoded和form-data的请求数据格式，都可以
            @RequestParam("k1") String ksss,//写全的做法，通过注解值为key查找请求数据
            @RequestParam String k2,//省略注解值的做法，默认以变量名为key查找请求数据
            String k3//最省略的做法：默认就是@RequestParam注解
    ) {
        System.out.println("=================" + ksss + ", " + k2 + ", " + k3);
        return test1;
    }

    @RequestMapping("/test3")
    @ResponseBody
    public Object test3(User user){//请求数据自动映射到参数类型的属性中:username=xxx&password=xxx
        System.out.println(user);
        return test1;
    }
    @RequestMapping("/test4")
    @ResponseBody
    public Object test4(User user){//请求数据自动映射到参数类型的属性中:username=xxx&password=xxx
        System.out.println(user);
        return null;//响应体为空
    }

    @RequestMapping("/test5")
    @ResponseBody
    public Object test5(User user){//请求数据自动映射到参数类型的属性中:username=xxx&password=xxx
        System.out.println(user);//返回字符串,响应数据格式不再是json,而是text/plain,字符串内容
        return "ok";
    }

    @RequestMapping("/test6")
    @ResponseBody
    public Object test6(HttpServletRequest req, HttpServletResponse res){//请求数据自动映射到参数类型的属性中:username=xxx&password=xxx
        System.out.println("============" + req.getParameter("username") +", " + req.getParameter("password"));
        return null;
    }

    @RequestMapping("/test7")
    @ResponseBody
    //请求数据类型为application/json时,解析请求体中json字符串为java对象
    public Object test7(@RequestBody User user){
        System.out.println("=============" + user);
        return null;//响应体为空
    }

    /**
     * web开发经常存在需求：
     * （1）统一处理异常
     * （2）统一返回数据格式
     * （3）统一会话管理（登录的敏感资源权限控制）
     */
    @RequestMapping("test8")
    @ResponseBody
    public Object test8(){
        throw new RuntimeException("数据库报错了");
    }
}

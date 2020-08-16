package frank.config;


import frank.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig  implements WebMvcConfigurer {//web框架在执行初始化工作的时候,会调用接口方法

    //注意:
    //  /**表示模糊匹配拦截静态资源也会被拦截
    /**
     *添加web配置:添加拦截器(根据路径进行拦截)
     * /* :代表一级的路径 如/user/*,可匹配到/user/abc,不能匹配到 /user/abc/1
     * /** :代表多级的路径
     * @param
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //实现用户会话管理的功能
//        registry.addInterceptor(new LoginInterceptor())//链式方法设计:当前类型的方法返回值就是this
//                .addPathPatterns("/user/**")//添加要拦截的路径
//                .excludePathPatterns("/user/login");//排除的路径
//
//    }

    @Bean
    public Map<Integer,String> test1(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"测试1");
        map.put(2,"测试2");
        return map;
    }

    @Bean
    public Map<Integer,String> test2(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"测试3");
        map.put(2,"测试4");
        return map;
    }

    @Bean
    public User user1(){
        User u= new User();
        u.setUsername("龙世春");
        u.setPassword("123");
        return u;
    }

    @Bean
    public User user2(){
        User u= new User();
        u.setUsername("小红");
        u.setPassword("456");
        return u;
    }

}

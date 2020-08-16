package frank.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//指定身份: 拦截Controller中web请求的类
@ControllerAdvice
public class AppControllerAdvice {

    //指定处理请求方法中抛出的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handler(Exception e){
        e.printStackTrace();
        return null;
    }
}


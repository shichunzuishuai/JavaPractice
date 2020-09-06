package service;

import dao.UserDao;
import entity.User;

public class UserService {
    //用户登录操作
    public User login(User loginUser){
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        return user;
    }

    //用户注册操作
    public int register(User register){
        UserDao userDao = new UserDao();
        int user = userDao.register(register);
        return user;
    }

    //判断用户是否注册过了
    public boolean exit(String name){
        UserDao userDao = new UserDao();
        return userDao.exit(name);
    }
}

package model;

//主要实现三个功能
//1. 插入用户,注册的时候使用
//2. 按名字查找用户, 登录时使用
//3. 按照用户id 查找, 展示信息的时候使用

import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public void add(User user) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1.先建立连接
            connection = DBUtil.getConnection();
            //2.拼装sql语句
            String sql = "insert into user values (null ,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1,user.getPassword());
            ps.setInt(2,user.getIsAdmin());
            ps.setString(3,user.getName());
            //执行sql语句
            int ret = ps.executeUpdate();
            if(ret != 1){
                throw new OrderSystemException("插入用户失败");
            }
            System.out.println("插入用户成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("插入用户失败");
            //关闭连接
        }finally {
            DBUtil.close(connection,ps,null);
        }
    }

    public User selectByName(String name) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from user where name = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按姓名查找用户失败");
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        return null;
    }

    public User selectById(int id) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from user where userId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按照id查找用户失败");
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        return null;
    }

    public static void main(String[] args) throws OrderSystemException {
        //这个方法进行UserDao的单元测试
        UserDao userDao = new UserDao();
//        //1.验证插入用户操作
//        User user = new User();
//        user.setName("long");
//        user.setPassword("123");
//        user.setIsAdmin(0);
//        userDao.add(user);
        //验证按照名字查找用户
        User user = userDao.selectByName("long");
        System.out.println("按照名字查找");
        System.out.println(user);

        //按照id查找
        user = userDao.selectById(2);
        System.out.println("按照id查找");
        System.out.println(user);

    }
}

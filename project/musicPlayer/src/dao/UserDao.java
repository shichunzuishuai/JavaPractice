package dao;

import entity.User;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//有关用户的操作
public class UserDao {

    //用户登录
    public  User login (User loginUser){
        Connection connection = null;
        PreparedStatement ps = null;
        User user = null;
        connection = DBUtils.getConnection();
        ResultSet rs = null;
        try {
            String sql = "select * from user where username = ? and password = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,loginUser.getUsername());
            ps.setString(2,loginUser.getPassword());

            //执行sql语句
            rs = ps.executeQuery();
            if(rs.next()){
                 user = new User();
                 user.setId(rs.getInt("id"));
                 user.setUsername(rs.getString("username"));
                 user.setPassword(rs.getString("password"));
                 user.setAge(rs.getInt("age"));
                 user.setGender(rs.getString("gender"));
                 user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,ps,rs);
        }
        return user;
    }

    //用户注册
    public int register (User registerUser) {
        Connection connection = null;
        PreparedStatement ps = null;
        int ret = 0;
        try {
            String sql = "insert into user (username,password,age,gender,email)VALUES(?,?,?,?,?)";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,registerUser.getUsername());
            ps.setString(2,registerUser.getPassword());
            ps.setInt(3,registerUser.getAge());
            ps.setString(4,registerUser.getGender());
            ps.setString(5,registerUser.getEmail());

            //执行sql语句
           ret = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,ps,null);
        }
        return ret;
    }

    //判断该用户是否已经注册过了
    public  boolean exit(String name){
        Connection connection = null;
        PreparedStatement ps = null;
        User user = null;
        connection = DBUtils.getConnection();
        ResultSet rs = null;
        try {
            String sql = "SELECT count(*) FROM user where username=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            int ret = 0;
            if (rs.next()){
                 ret = rs.getInt(1);
                 System.out.println(ret);
            }
            if(ret == 0){
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,ps,rs);
        }
       return true;
    }

    public static void main(String[] args) {
        User user = new User();
//        user.setUsername("bit");
//        user.setPassword("123");
//        User loginUser = login(user);
//        System.out.println(loginUser);
//        User user = new User();
//        user.setUsername("long");
//        user.setPassword("123");
//        user.setAge(22);
//        user.setGender("男");
 //       user.setEmail("13213213@qq.com");
//        int registerUser = register(user);
//        System.out.println(registerUser);

//        boolean flag = exit("bit");
//        System.out.println(flag);

    }
}

package test;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        //1.创建dataource对象
        DataSource dataSource = new MysqlDataSource();
        //接下来进行一些配制
        //主要配制三方面,URL,USER,Password需要进行向下转型
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java16_0531?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("LONG@0327");

        //2.和数据库键连接
        //建立连接的意义是为了验证当前网络是否正常
        //如果不正常就会抛出SQLException异常
        Connection connection = dataSource.getConnection();





        //3.拼装Sql语句,用到PrepareStatement对象
        //可以子在序运行时会获取到动态的拼接进去
        int id = 1;
        String name = "曹操";
        int ClassId = 10;

        String sql = "insert into student values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        //1,2,3相当于?的下标
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setInt(3,ClassId);
        System.out.println("statement: " + statement);

        //4.拼装好了之后可以执行
        //insert delete update 都使用executeUpdate方法来执行
        //返回值表示本次修改了多少行
        int ret = statement.executeUpdate();
        System.out.println("ret: " + ret);

        //执行完毕后需要关闭释放相关资源
        //一定是后创建的先释放
        statement.close();
        connection.close();
    }
}



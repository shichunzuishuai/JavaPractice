package test;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBCSelect {
    public static void main(String[] args) throws SQLException {
        //1.先创建DataSource对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java16_0531?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("LONG@0327");
        //2.创建Connection对象,和数据库建立连接
        Connection connection = dataSource.getConnection();
        //3.借助PrepareStatement拼装SQL语句
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        //4.执行SQL语句
        ResultSet resultSet = statement.executeQuery();
        //5.遍历结果集,遍历过程和集合使用迭代器遍历有点相似
        //结果集相当于一张表,这张表有很多行,每一行实一个记录
        //next()一方面是判断是否存在下一行, 另一方面如果存在下一行就获取下一行
        while (resultSet.next()){
            //resultSet的光标指向了当前行,可以获取当前行中列的数据
            //当前表中包含了3个数据,id,name,classId,可以根据列明获取对应的列数据
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int classId = resultSet.getInt("classId");
            System.out.println("id: " + id + " name: " + name + " classId: " + classId);
        }
        //关闭释放资源

        //后创建的先释放
        resultSet.close();
        statement.close();
        connection.close();

    }
}

















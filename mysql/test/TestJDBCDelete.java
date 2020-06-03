package test;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCDelete {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除学生的姓名");
        String name = scanner.next();
        //1.创建DataSource 对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java16_0531?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("LONG@0327");
        //2.创建Connection对象,和数据库建立联系
        Connection connection = dataSource.getConnection();
        //3.借助prepareStatement拼接SQL语句
        String sql = "delete from student where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        //4.执行sql语句
        int ret = statement.executeUpdate();
        if(ret ==1){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
        //5.关闭并释放资源
        statement.close();
        connection.close();
    }
}

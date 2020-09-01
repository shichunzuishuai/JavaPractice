package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/order_system?characterEncoding=utf8&useSSL=true";
    //private static final String URL = "jdbc:mysql://39.99.233.22:3306/order_system?characterEncoding=utf-8&useSSL=true";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static volatile DataSource dataSource = null;

    //数据库
    public static DataSource getDataSource(){
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if(dataSource == null){
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setUrl(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("数据库连接失败,请检查数据库还是否启动正确并检查url是否正确");
        return null;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try {
           if(resultSet != null){
               resultSet.close();
           }
           if(preparedStatement != null){
               preparedStatement.close();
           }
           if(connection != null){
               connection.close();
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

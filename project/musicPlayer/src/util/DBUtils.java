package util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//用于管理数据库连接
//1.能建立连接
//2.能断开连接
//JDBC使用DataSource来管理连接
//DBUtil 相当于对DataSource进行包装一层
//DataSource每个应用程序只应该有一个应用实例(单例)
//DBUtil本质上实现了一个单例模式,管理了唯一一个Datasource实例
//单例模式有两种模式
//1.懒汉模式
//2.饿汉模式
//此处用懒汉模式
public class DBUtils {
    private static volatile DataSource dataSource = null;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/musicserver?characterEncoding=utf-8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "LONG@0327";

    private static DataSource getDataSource(){
        if (dataSource == null) {
            synchronized (DBUtils.class) {
                if(dataSource == null){
                    dataSource = new MysqlDataSource();
                    //还需要改DataSource设置一些属性
                    ((MysqlDataSource) dataSource).setUrl(URL);
                    ((MysqlDataSource) dataSource).setUser(USERNAME);
                    ((MysqlDataSource) dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    //通过这个方法来获取连接
    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过这个方法来断开连接
    public static void close(Connection connection, PreparedStatement preparedStatement,
                             ResultSet resultSet){
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

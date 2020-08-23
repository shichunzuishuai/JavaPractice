import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class TestMysql {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://127.0.0.1:3306/java16_0531?useSSL=true&characterEncoding=utf8";
        String username = "root";
        String password = "LONG@0327";
        //1.创建DataSource实例,并设置数据库相关参数
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl(url);
        ((MysqlDataSource) dataSource).setUser(username);
        ((MysqlDataSource) dataSource).setPassword(password);
        //2.和数据库建立连接
        Connection connection = dataSource.getConnection();
        //访问数据库,徐拼装一个Sql语句
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        //执行sql
        ResultSet resultSet = statement.executeQuery();
        //5.遍历结果集
        //每次调用next方法就会获取到一条记录
        //进一步是用getxxx方法,根据列名,得到对应列的数据
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getInt("classId"));
        }
        //6.关闭连接释放资源
        //关闭顺序和创建顺序相反
        resultSet.close();
        statement.close();
        connection.close();
    }
}

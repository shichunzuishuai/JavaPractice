package model;

import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//操作订单
//1. 新增订单
//2. 查看所有订单(只有管理员才能查看)
//3. 查看指定用户的订单(普通用户查看)
//4. 查看订单的详细信息
//5. 修改订单状态(是否已经完成)
public class OrderDao {
    //新增订单
    //和两个表关联
    //1. order_user
    //2. order_dish 一个订单中可能会涉及点多个菜 ,就需要给这个表一次性插入多个数据
    public void add(Order order) throws OrderSystemException {
        //1.先操作order_user表
        addOrderUser(order);
        //2.在操作order_dish表
        //操作下面的需要知道orderId,但是这个是有数据库自动生成的,不知道具体是啥
        //所以还需要做一些处理来保存自动生成的id
        addOrderDish(order);
    }

    private void addOrderUser(Order order) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into order_user values (null ,?, now(), 0)";
            //保存了自动生成的自增id
            ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,order.getUserId());
            int ret = ps.executeUpdate();
            if(ret != 1){
                throw new OrderSystemException("插入订单失败");
            }
            //八字增主键的值读出来
            resultSet = ps.getGeneratedKeys();
            if(resultSet.next()){
                //理解1:读取resultSet的结果,可以使用列名,也可以使用下标
                //由于一个表中自增列可以有多个,返回的时候都返回了,下标填1,
                //表示想获取第一个自增列生成的值
                order.setOrderId(resultSet.getInt(1));
            }
            System.out.println("插入订单第一步成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("插入订单失败");
        }finally {
            DBUtil.close(connection,ps,resultSet);
        }
    }

    private void addOrderDish(Order order) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //关闭自动提交
            connection.setAutoCommit(false);
            connection = DBUtil.getConnection();
            String sql = "insert into order_dish values (?,?)";
            ps = connection.prepareStatement(sql);
            //遍历dishes 给sql添加多个values的值
            List<Dish> dishes = order.getDishes();
            for (Dish dish: dishes) {
                ps.setInt(1,order.getOrderId());
                ps.setInt(2,dish.getDishId());
                ps.addBatch();//给sql新增一片段
            }
            //执行sql(并不是真的执行),commit可以执行多个sql,一次调用commit统一发给服务器
            ps.executeBatch(); //把刚才的sql进行统一执行
            //发行给服务器(真的执行)
            connection.commit();
             System.out.println("插入订单成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("插入订单失败");
        }finally {
            DBUtil.close(connection,ps,null);
        }
    }

}

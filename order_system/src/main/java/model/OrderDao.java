package model;

import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//操作订单
//1. 新增订单
//2. 查看所有订单(只有管理员才能查看)
//3. 查看指定用户的订单(普通用户查看)
//4. 查看指定订单的详细信息
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
            //如果上面的操作出现异常,就认为整体新增订单的操作失败,就回滚之前的order_user表的内容
            deleteOrderUser(order.getOrderId());

            throw new OrderSystemException("插入订单失败");
        }finally {
            DBUtil.close(connection,ps,null);
        }
    }

    //这个方法用于删除order_user表中的记录
    private void deleteOrderUser(int orderId) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from order_user where orderId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,orderId);
            int ret = ps.executeUpdate();
            if(ret != 1){
                throw new OrderSystemException("删除order_user记录失败");
            }
            System.out.println("删除order_user记录成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("删除order_user记录失败");
        }finally {
            DBUtil.close(connection,ps,null);
        }
    }

    //查看所有订单
    //Order对象里,orderId,userId可以直接通过order_user来获取
    //订单中还有一个List<Dish>,都有哪些菜品
    //详细信息先根据order_dish获取到姓关的dishId,然后根据这些dishId到dishes表中查找对应的菜品
    //仔细思考,发现这里的订单获取不需要那么详细的信息,只要获取到订单的基本信息就行了
    //菜品信息,上面定义的时候有一个专门的类来做这件事
    //所以这个接口不包含菜品信息
    private List<Order> selectAll() throws OrderSystemException {
        List<Order> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from order_user";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                //此时order中没有dishes字段
                Order order = new Order();
                order.setOrderId(rs.getInt("orderId"));
                order.setOrderId(rs.getInt("userId"));
                order.setTime(rs.getTimestamp("time"));
                order.setIsDone(rs.getInt("isDone"));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        return list;
    }

    //查看指定用户的订单
    public List<Order> selectByUserId(int userId) {
        List<Order> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from order_user where userId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                //此时order中没有dishes字段
                Order order = new Order();
                order.setOrderId(rs.getInt("orderId"));
                order.setOrderId(rs.getInt("userId"));
                order.setTime(rs.getTimestamp("time"));
                order.setIsDone(rs.getInt("isDone"));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, ps, rs);
        }
        return list;
    }

    //查看指定订单的详细信息
    //这个方法要把Order中的详情写进去
    //包括有哪些菜品以及菜品的详情
    public Order selectById(int orderId) throws OrderSystemException {
        //1.先根据orderId得到一个Order对象
        Order order = builderOrder(orderId);
        //2.根据orderId得到该orderId对应的菜品id
        List<Integer> dishIds = selectDishIds(orderId);
        //3.根据菜品Id去dishes表中查询,获得菜品详情
        order = getDishDetail(order,dishIds);
        return order;
    }



    //根据orderId来查询对应的Order对象的基本信息
    //查找order_user表
    private Order builderOrder(int orderId) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "select * from orser_user where orderId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,orderId);
            rs = ps.executeQuery();
            if (rs.next()){
                Order order = new Order();
                order.setOrderId(rs.getInt("orderId"));
                order.setUserId(rs.getInt("userId"));
                order.setTime(rs.getTimestamp("time"));
                order.setIsDone(rs.getInt("isDone"));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        return null;
    }

    //
    private List<Integer> selectDishIds(int orderId) {
        List<Integer> dishIds = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from order_dish where orderId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
               dishIds.add(rs.getInt("dishId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, ps, rs);
        }
        return dishIds;

    }

    //返回一个完整的Order对象
    private Order getDishDetail(Order order, List<Integer> dishIds) throws OrderSystemException {
       List<Dish> dishes = new ArrayList<>();
       DishDao dishDao = new DishDao();
        for (Integer dishId : dishIds) {
            Dish dish = dishDao.selectById(dishId);
            dishes.add(dish);
        }
        //把dishes属性也设置到order对象中
        order.setDishes(dishes);
        return order;
    }

    //修改订单状态
    public void changeState(int orderId,int isDone) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "update order_user set isDone = ? where orderId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,isDone);
            ps.setInt(2,orderId);
            int ret = ps.executeUpdate();
            if(ret != 1){
                throw new OrderSystemException("修改订单状态失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("修改订单状态失败");
        } finally {
          DBUtil.close(connection,ps,null);
        }
    }

}

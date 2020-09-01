package model;

import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//操作菜品表
//1. 新增菜品
//2. 删除菜品
//3. 查询所有菜品
//4. 查询指定菜品
//修改菜品信息(主要是改价格)
public class DishDao {
    //新增菜品
    public void add(Dish dish) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement ps = null;
        try{
            connection = DBUtil.getConnection();
            String sql = "insert into dishes values (null ,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1,dish.getName());
            ps.setInt(2,dish.getPrice());
            int ret = ps.executeUpdate();
            if(ret != 1){
                throw new OrderSystemException("新增菜品失败");
            }
            System.out.println("新增菜品成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("新增菜品失败");
        }finally {
            DBUtil.close(connection,ps,null);
        }
    }

    //删除菜品
    public void delete(int dishId) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement ps = null;
        try{
            connection = DBUtil.getConnection();
            String sql = "delete from dishes where dishId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,dishId);
            int ret = ps.executeUpdate();
            if(ret != 1){
                throw new OrderSystemException("删除菜品失败");
            }
            System.out.println("删除菜品成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("删除菜品失败");
        }finally {
            DBUtil.close(connection,ps,null);
        }
    }
    //查找所有菜品
    public List<Dish> selectAll() throws OrderSystemException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Dish> list = new ArrayList();
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from dishes";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Dish dish = new Dish();
                dish.setDishId(rs.getInt("dishId"));
                dish.setName(rs.getString("name"));
                dish.setPrice(rs.getInt("price"));
                list.add(dish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("查找所有菜品失败");
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        return list;
    }

    //查询指定菜品
    public Dish selectById(int dishId) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from dishes where dishId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,dishId);
            rs = ps.executeQuery();
            if (rs.next()){
                Dish dish = new Dish();
                dish.setDishId(rs.getInt("dishId"));
                dish.setName(rs.getString("name"));
                dish.setPrice(rs.getInt("price"));
                return dish;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按照ID查找菜品失败");
        }finally {
            DBUtil.close(connection,ps,rs);
        }
        return null;
    }

    public static void main(String[] args) throws OrderSystemException {
        DishDao dishDao = new DishDao();
        //新增测试
//        Dish dish = new Dish();
//        dish.setName("红烧肉");
//        dish.setPrice(2000);//单位是分
//        dishDao.add(dish);

//        Dish dish = new Dish();
//        dish.setName("皮豇豆炒肉");
//        dish.setPrice(1500);//单位是分
//        dishDao.add(dish);
        //测试查找所有
//        List<Dish> list = dishDao.selectAll();
//        System.out.println("查找所有菜品");
//        for (Dish d:list) {
//            System.out.println(d);
//        }
        //测试查询指定菜品
        Dish dish = dishDao.selectById(2);
        System.out.println(dish);
        //测试删除菜品
      //  dishDao.delete(2);
    }
}

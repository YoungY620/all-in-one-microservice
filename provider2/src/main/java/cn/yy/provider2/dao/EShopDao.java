package cn.yy.provider2.dao;

import cn.yy.provider2.bean.Commodity;
import cn.yy.provider2.bean.Customer;
import cn.yy.provider2.bean.Order;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface EShopDao {
//    @Select("select * from city")
//    List<City> findAll();
//
//    @Select("select * from city where name=#{name}")
//    List<City> findByName(String name);

    @Select("select * from customer")
    List<Customer> findAllCustomers();

    @Select("select * from commodity")
    List<Commodity> findAllCommodities();

    @Select("select * from `order`")
    List<Order> findAllOrders();

    @Select("select * from `order` as o " +
            "where o.id=#{id}")
    List<Order> findByOrderID(int id);

    @Select("select * from `order` as o " +
            "where o.commodity_id=#{commodity_id}")
    List<Order> findByCommodityID(int commodity_id);

    @Select("select * from `order` as o " +
            "where o.customer_id=#{cus_id}")
    List<Order> findByCustomerID(int cus_id);

    @Select("select * from `order` as o " +
            "where o.customer_id=#{cus_id} " +
                "and o.commodity_id=#{commodity_id}")
    List<Order> find(int cus_id, int commodity_id);

    @Insert("INSERT INTO `order`(`customer_id`, `commodity_id`,`order_t`)\n" +
            "VALUES (#{cus_id}, #{com_id}, #{o_time})")
    void insertOrder(long cus_id, long com_id, Timestamp o_time);

    @Update("UPDATE `order` " +
            "SET `customer_id`=#{customer_id}, `commodity_id`=#{commodity_id},`order_t`=#{order_t}" +
            "WHERE `id`=#{id}")
    boolean updateOrder(Order order);

    @Delete("DELETE FROM `order` WHERE id=#{id}")
    boolean deleteOrderById(long id);
}

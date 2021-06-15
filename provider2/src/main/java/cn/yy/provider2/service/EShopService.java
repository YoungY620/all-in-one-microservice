package cn.yy.provider2.service;

import cn.yy.provider2.bean.Commodity;
import cn.yy.provider2.bean.Customer;
import cn.yy.provider2.bean.Order;

import java.util.List;

public interface EShopService {
    List<Customer> findAllCustomers();

    List<Commodity> findAllCommodities();

    List<Order> findAllOrders();

    List<Order> findByOrderID(int id);

    List<Order> findByCommodityID(int commodity_id);

    List<Order> findByCustomerID(int cus_id);

    List<Order> find(int cus_id, int commodity_id);

    void insertOrder(Order order);

    boolean deleteOrderById(long id);

    boolean updateOrder(Order order);
}


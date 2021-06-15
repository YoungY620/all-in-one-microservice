package cn.yy.provider2.service;

import cn.yy.provider2.bean.Commodity;
import cn.yy.provider2.bean.Customer;
import cn.yy.provider2.bean.Order;
import cn.yy.provider2.dao.EShopDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EShopServiceImpl implements EShopService {
    @Resource
    private EShopDao eShopDao;

    @Override
    public List<Customer> findAllCustomers() {
        return eShopDao.findAllCustomers();
    }

    @Override
    public List<Commodity> findAllCommodities() {
        return eShopDao.findAllCommodities();
    }

    @Override
    public List<Order> findAllOrders() {
        return eShopDao.findAllOrders();
    }

    @Override
    public List<Order> findByOrderID(int id) {
        return eShopDao.findByOrderID(id);
    }

    @Override
    public List<Order> findByCommodityID(int commodity_id) {
        return eShopDao.findByCommodityID(commodity_id);
    }

    @Override
    public List<Order> findByCustomerID(int cus_id) {
        return eShopDao.findByCustomerID(cus_id);
    }

    @Override
    public List<Order> find(int cus_id, int commodity_id) {
        return eShopDao.find(cus_id, commodity_id);
    }

    @Override
    public void insertOrder(Order order) {
        eShopDao.insertOrder(order.getCustomer_id(), order.getCommodity_id(), order.getOrder_t());
    }

    @Override
    public boolean updateOrder(Order order) {
        return eShopDao.updateOrder(order);
    }

    @Override
    public boolean deleteOrderById(long id) {
        return eShopDao.deleteOrderById(id);
    }
}

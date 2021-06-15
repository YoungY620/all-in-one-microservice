package cn.yy.feign.service;

import cn.yy.feign.bean.Commodity;
import cn.yy.feign.bean.Customer;
import cn.yy.feign.bean.Order;
import cn.yy.feign.conf.CallServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Service
@FeignClient(value = "provider/e-shop",fallbackFactory = CallServiceFallbackFactory.class)
public interface CallService {
    @RequestMapping("/findAllCustomers")
    List<Customer> findAllCustomers();

    @RequestMapping("/findAllCommodities")
    List<Commodity> findAllCommodities();

    @RequestMapping("/findAllOrders")
    List<Order> findAllOrders();

    @RequestMapping("/findByOrderID/{id}")
    List<Order> findByOrderID(@PathVariable("id") int id);

    @RequestMapping("/findByCommodityID/{commodity_id}")
    List<Order> findByCommodityID(@PathVariable("commodity_id") int commodity_id);

    @RequestMapping("/findByCustomerID/{cus_id}")
    List<Order> findByCustomerID(@PathVariable("cus_id") int cus_id) ;

    @RequestMapping("/find/{cus_id}/{commodity_id}")
    List<Order> find(@PathVariable("cus_id") int cus_id,
                     @PathVariable("commodity_id") int commodity_id) ;

    @RequestMapping(path = "/del/{id}", method = RequestMethod.DELETE)
    List<Order> deleteOrder(@PathVariable("id") long id);

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    List<Order> insertOrder(Order order);

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    List<Order> updateOrder(Order order);

    @RequestMapping("/discovery")
    Map<String, String> discovery();
}
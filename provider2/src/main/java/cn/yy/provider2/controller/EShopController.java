package cn.yy.provider2.controller;

import cn.yy.provider2.bean.Commodity;
import cn.yy.provider2.bean.Customer;
import cn.yy.provider2.bean.Order;
import cn.yy.provider2.service.EShopService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("e-shop")
public class EShopController {
    @Autowired
    EShopService eShopService;

    @RequestMapping("/findAllCustomers")
    List<Customer> findAllCustomers(){
        return eShopService.findAllCustomers();
    }

    @RequestMapping("/findAllCommodities")
    List<Commodity> findAllCommodities(){
        return eShopService.findAllCommodities();
    }

    @HystrixCommand(fallbackMethod = "fallbackReturnOrder")
    @RequestMapping("/findAllOrders")
    List<Order> findAllOrders() throws Exception{
        return eShopService.findAllOrders();
    }
    List<Order> fallbackReturnOrder(){
        return new ArrayList<>();
    }

    @HystrixCommand(fallbackMethod = "fallbackFindByOrderIDReturnOrder")
    @RequestMapping("/findByOrderID/{id}")
    List<Order> findByOrderID(@PathVariable("id") int id) throws Exception{
        if(id <= 0){
            throw new Exception();
        }
        return eShopService.findByOrderID(id);
    }
    List<Order> fallbackFindByOrderIDReturnOrder(@PathVariable("id") int id){
        return new ArrayList<>();
    }

    @HystrixCommand(fallbackMethod = "fallbackFindByCommodityIDReturnOrder")
    @RequestMapping("/findByCommodityID/{commodity_id}")
    List<Order> findByCommodityID(@PathVariable("commodity_id") int commodity_id) throws Exception{
        if(commodity_id <= 0){
            throw new Exception();
        }
        return eShopService.findByCommodityID(commodity_id);
    }
    List<Order> fallbackFindByCommodityIDReturnOrder(@PathVariable("commodity_id") int id){
        return new ArrayList<>();
    }

    @HystrixCommand(fallbackMethod = "fallbackFindByCustomerIDReturnOrder")
    @RequestMapping("/findByCustomerID/{cus_id}")
    List<Order> findByCustomerID(@PathVariable("cus_id") int cus_id) throws Exception{
        if(cus_id <= 0){
            throw new Exception();
        }
        return eShopService.findByCustomerID(cus_id);
    }
    List<Order> fallbackFindByCustomerIDReturnOrder(@PathVariable("cus_id") int id){
        return new ArrayList<>();
    }

    @HystrixCommand(fallbackMethod = "fallbackFindReturnOrder")
    @RequestMapping("/find/{cus_id}/{commodity_id}")
    List<Order> find(@PathVariable("cus_id") int cus_id,
                     @PathVariable("commodity_id") int commodity_id) throws Exception{
        if(cus_id <= 0 || commodity_id <= 0){
            throw new Exception();
        }
        return eShopService.find(cus_id, commodity_id);
    }

    List<Order> fallbackFindReturnOrder(@PathVariable("cus_id") int id1, @PathVariable("commodity_id") int id2){
        return new ArrayList<>();
    }

    @HystrixCommand(fallbackMethod = "deleteFallback")
    @RequestMapping(path = "/del/{id}", method = RequestMethod.DELETE)
    List<Order> deleteOrder(@PathVariable("id") long id) throws Exception{
        if(eShopService.deleteOrderById(id)){
            return eShopService.findAllOrders();
        }
        throw new Exception();
    }
    List<Order> deleteFallback(@PathVariable("id") long id){
        Order order = new Order();
        order.setCommodity_id(-1);
        order.setCustomer_id(-1);
        return Collections.singletonList(order);
    }

    @RequestMapping(path = "/insert",method = RequestMethod.POST)
    List<Order> insertOrder(@RequestBody Order order){
        eShopService.insertOrder(order);
        return eShopService.findAllOrders();
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    List<Order> updateOrder(@RequestBody Order order){
        eShopService.updateOrder(order);
        return eShopService.findAllOrders();
    }

    @RequestMapping("/discovery")
    Map<String, String> discovery() {
        Map<String, String> re = new HashMap<>();
        re.put("name", EShopController.class.getPackage().getName());
        return re;
    }
}

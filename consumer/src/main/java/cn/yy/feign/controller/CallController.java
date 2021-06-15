package cn.yy.feign.controller;

import cn.yy.feign.bean.Commodity;
import cn.yy.feign.bean.Customer;
import cn.yy.feign.bean.Order;
import cn.yy.feign.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("consumer")
public class CallController {
    @Autowired
    CallService callService;

    @RequestMapping("/findAllCustomers")
    List<Customer> findAllCustomers(){
        return callService.findAllCustomers();
    }

    @RequestMapping("/findAllCommodities")
    List<Commodity> findAllCommodities(){
        return callService.findAllCommodities();
    }

    @RequestMapping("/findAllOrders")
    List<Order> findAllOrders() throws Exception{
        System.out.println("customer ");
        return callService.findAllOrders();
    }

    @RequestMapping("/findByOrderID/{id}")
    List<Order> findByOrderID(@PathVariable("id") int id) throws Exception{
        return callService.findByOrderID(id);
    }

    @RequestMapping("/findByCommodityID/{commodity_id}")
    List<Order> findByCommodityID(@PathVariable("commodity_id") int commodity_id) throws Exception{
        return callService.findByCommodityID(commodity_id);
    }

    @RequestMapping("/findByCustomerID/{cus_id}")
    List<Order> findByCustomerID(@PathVariable("cus_id") int cus_id) throws Exception{
        return callService.findByCustomerID(cus_id);
    }

    @RequestMapping("/find/{cus_id}/{commodity_id}")
    List<Order> find(@PathVariable("cus_id") int cus_id,
                     @PathVariable("commodity_id") int commodity_id) throws Exception{
        return callService.find(cus_id, commodity_id);
    }

    @RequestMapping(path = "del/{id}", method = RequestMethod.DELETE)
    List<Order> deleteOrder(@PathVariable("id") long id){
        return callService.deleteOrder(id);
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    List<Order> insertOrder(@RequestBody Order order){
        return callService.insertOrder(order);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    List<Order> updateOrder(@RequestBody Order order){
        return callService.updateOrder(order);
    }
    
    @RequestMapping("/discovery")
    Map<String, String> discovery() {
        return callService.discovery();
    }

}
package cn.yy.feign.conf;

import cn.yy.feign.bean.Commodity;
import cn.yy.feign.bean.Customer;
import cn.yy.feign.bean.Order;
import cn.yy.feign.service.CallService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CallServiceFallbackFactory implements FallbackFactory<CallService> {
    @Override
    public CallService create(Throwable throwable) {
        return new CallService() {

            @Override
            public List<Customer> findAllCustomers() {
                return new ArrayList<>();
            }

            @Override
            public List<Commodity> findAllCommodities() {
                return new ArrayList<>();
            }

            @Override
            public List<Order> findAllOrders() {
                return new ArrayList<>();
            }

            @Override
            public List<Order> findByOrderID(int id) {
                return new ArrayList<>();
            }

            @Override
            public List<Order> findByCommodityID(int commodity_id) {
                return new ArrayList<>();
            }

            @Override
            public List<Order> findByCustomerID(int cus_id) {
                return new ArrayList<>();
            }

            @Override
            public List<Order> find(int cus_id, int commodity_id) {
                return new ArrayList<>();
            }

            @Override
            public List<Order> deleteOrder(long id) {
                return new ArrayList<>();
            }

            @Override
            public List<Order> insertOrder(Order order) {
                return new ArrayList<>();
            }

            @Override
            public List<Order> updateOrder(Order order) {
                return new ArrayList<>();
            }

            @Override
            public Map<String, String> discovery() {
                return new HashMap<>();
            }
        };
    }
}
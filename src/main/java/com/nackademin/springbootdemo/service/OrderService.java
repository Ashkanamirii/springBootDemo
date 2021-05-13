package com.nackademin.springbootdemo.service;

import com.nackademin.springbootdemo.model.Orders;
import com.nackademin.springbootdemo.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-12 <br>
 * Time: 12:10 <br>
 * Project: webshop-back-end <br>
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Orders> getAllOrders() {
        return orderRepo.findAll();
    }

    public Orders getOrderById(Long id) {
        return orderRepo.findById(id).orElse(null); // Makes it possible to return Category instead of Optional
    }

    public Orders addOrder(Orders order) {
        return orderRepo.save(order);
    }

    public List<Orders> addOrderList(List<Orders> orders) {
        return orderRepo.saveAll(orders);
    }

    public String removeOrderById(Long id) {
        orderRepo.deleteById(id);
        return "Deleted order with id " + id;
    }

    public String removeAllOrders(){
        orderRepo.deleteAllInBatch();
        return "Deleted all orders.";
    }

}

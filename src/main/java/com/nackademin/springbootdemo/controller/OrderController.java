package com.nackademin.springbootdemo.controller;

import com.nackademin.springbootdemo.model.Orders;
import com.nackademin.springbootdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-12 <br>
 * Time: 11:55 <br>
 * Project: webshop-back-end <br>
 */
//
@RestController
@RequestMapping( "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/get")
    public List<Orders> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/get/id")
    public Orders getOrdersById(@RequestParam Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/add")
    public Orders addOrder(@RequestBody Orders order){
        return orderService.addOrder(order);
    }

    @PostMapping("/add/list")
    public List<Orders> addOrderList(@RequestBody List<Orders> orders){
        return orderService.addOrderList(orders);
    }

    @PostMapping("/delete/{id}")
    public String deleteOrderById(@PathVariable Long id) {
        return orderService.removeOrderById(id);
    }

    @PostMapping("/delete/all")
    public String deleteAllOrders(){
        return orderService.removeAllOrders();
    }
}

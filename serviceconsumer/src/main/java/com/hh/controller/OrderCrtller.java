package com.hh.controller;

import com.hh.pojo.Order;
import com.hh.pojo.Product;
import com.hh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderCrtller {

    @Autowired
    private OrderService orderService;


    @GetMapping("/list/{id}")
    public Order getOrderById(@PathVariable("id") Integer id){

        return orderService.selectOrderById(id);
    }
    @GetMapping("/byProductId/{id}")
    public Order selectOrderByProductId(@PathVariable("id") Integer id) throws InterruptedException {

        return orderService.selectOrderByProductId(id);
    }

    @PostMapping("/save")
    public Map createProduct(@RequestBody Product product) {
        return orderService.createProduct(product);
    }
}

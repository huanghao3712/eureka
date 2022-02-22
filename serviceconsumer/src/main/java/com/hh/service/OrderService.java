package com.hh.service;

import com.hh.pojo.Order;
import com.hh.pojo.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

public interface OrderService {
    public ArrayList<Object> selectList();
    public Order selectOrderById(Integer id);
    public Order selectOrderByProductId(Integer id) ;


    public Map createProduct( Product product);

}

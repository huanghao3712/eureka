package com.hh.service;

import com.hh.pojo.Product;


import java.util.ArrayList;
import java.util.Map;

public interface ProductService {
    public ArrayList<Object> selectList();

    public Product findProductById(Integer id);

    Map createProduct(Product product);
}

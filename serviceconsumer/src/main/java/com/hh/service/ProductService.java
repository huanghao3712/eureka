package com.hh.service;

import com.hh.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient("serviceprovider")
public interface ProductService {
    @GetMapping("/product/list")
    public List<Product> selectList();


    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable("id")Integer id);
    @PostMapping("/product/save")
    public Map createProduct( Product product);
}

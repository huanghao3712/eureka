package com.hh.controller;

import com.hh.pojo.Product;
import com.hh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductCrtller {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Object> selectProductList(){
        return productService.selectList();
    }

    @GetMapping("/{id}")
    public Product selectProductList(@PathVariable("id") Integer id){
        return productService.findProductById(id);
    }

    @PostMapping("/save")
    public Map createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
}

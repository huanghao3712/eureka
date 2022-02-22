package com.hh.service.impl;

import com.hh.mapper.ProductMapper;
import com.hh.pojo.Product;
import com.hh.service.ProductService;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper pm;
//    @Autowired
//    JdbcTemplate jdbcTemplate;
    @Override
    public ArrayList<Object> selectList() {
        ArrayList al=new ArrayList();
        al.add(new Product(1,"华为手机" ,300,5999.0));
        al.add(new Product(2,"xm手机" ,300,4999.0));
        al.add(new Product(3,"vivo手机" ,300,3999.0));
        System.out.println("服务调用一次！");
        String sql="select * from product";
//        List<Map<String,Object>> t1=  jdbcTemplate.queryForList(sql);
//        System.out.println(t1);
        Product p=pm.selectProducts(1);
        System.out.println(p);
        al.add(p);
        Product p1=pm.selectProductsMap(2);
        System.out.println(p1);
        al.add(p1);
        System.out.println(al);
        return al;
    }

    @Override
    public Product findProductById(Integer id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Product> al=new ArrayList();
        al.add(new Product(1,"华为手机" ,300,5999.0));
        al.add(new Product(2,"xm手机" ,300,4999.0));
        al.add(new Product(3,"vivo手机" ,300,3999.0));
        for (Product t:al
             ) {
            if(t.getProductId().equals(id))
                return t;
        }
        return null;
    }

    @Override
    public Map createProduct(Product product) {
        System.out.println("product = " + product);
        return new HashMap() {
            {
                put("code", "200");
                put("message", "小资产个");
            }


        };
    }
}

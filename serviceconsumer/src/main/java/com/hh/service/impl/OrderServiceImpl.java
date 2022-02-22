package com.hh.service.impl;

import com.hh.pojo.Order;
import com.hh.pojo.Product;
import com.hh.service.OrderService;

import com.hh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductService productService;
//    @Autowired
//    private RestTemplate restTemplate;
//    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
//    @Autowired
//    private DiscoveryClient discoveryClient;
    @Override
    public ArrayList<Object> selectList() {
        ArrayList al=new ArrayList();
        al.add(new Product(1,"华为手机" ,300,5999.0));
        al.add(new Product(2,"xm手机" ,300,4999.0));
        al.add(new Product(3,"vivo手机" ,300,3999.0));

        return al;
    }

    @Override
    public Order selectOrderById(Integer id) {

       // return new Order(id,"","",100000.0,selectProductListByLoadBalancerAnnation());
         return new Order(id,"","",100000.0,productService.selectList());

    }

    @Override
    public Order selectOrderByProductId(Integer id) {

        // return new Order(id,"","",100000.0,selectProductListByLoadBalancerAnnation());
         List<Product> lp =new ArrayList<>();
        lp.add(productService.findProductById(id));

        return new Order(id, "", "", 100000.0, lp);

    }

    @Override
    public Map createProduct(Product product) {
        return productService.createProduct(product);
    }
//
//    public List<Product> selectProductListByDiscoverClient() {
//        List<String> ls=discoveryClient.getServices();
//        List<ServiceInstance> lsi=discoveryClient.getInstances("serviceprovider");
//        ServiceInstance si=lsi.get(0);
//        String url="http://"+si.getHost()+":"+si.getPort()+"/product/list";
//        ResponseEntity<List<Product>> response=restTemplate.exchange(
//                url,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Product>>(){}
//        );
//        return response.getBody();
//    }
//    @Override
//    public List<Product> selectProductListByLoadBalancerAnnation() {
//        ResponseEntity<List<Product>> response=restTemplate.exchange(
//                "http://serviceprovider/product/list",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Product>>(){}
//        );
//
//        return response.getBody();
//    }
}

package com.hh.service.impl;

import com.hh.mapper.ProductMapper;
import com.hh.model.MyPage;
import com.hh.pojo.Product;
import com.hh.service.ProductService;
import com.hh.util.SnowId;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper pm;
    @Override
    public ArrayList<Object> selectList() {
        ArrayList<Product> al=new ArrayList();
        al.add(new Product(1l,"华为手机" ,300,5999.0));
        al.add(new Product(2l,"xm手机" ,300,4999.0));
        al.add(new Product(3l,"vivo手机" ,300,3999.0));
        System.out.println("服务01调用一次！");
        IntStream.range(0,10000).forEach(j->pm.insert(new Product(SnowId.genId(),"华为手机" ,300+j,5999.0)));
        Product p=pm.selectProducts(1);
        al.add(pm.selectProducts(1));
        al.addAll(pm.selectList(null));
        List xx=al.parallelStream().filter(a->a.getProductId()%2==0)
                .filter(a->a.getProductId()<1000)
                .collect(Collectors.toList());
        System.out.println(xx);
        System.out.println(xx.size());
        System.out.println(al.size());
        Object[] xxx = xx.toArray();
        List xxxx=Arrays.asList(xxx);
        IntStream.range(0,10).forEach(i-> System.out.println(String.format("取前%s个元素 %s",i,xxx[i])));
//        MyPage<Product> pg=new MyPage<>(1,10);
//        pg=pm.mySelectPageMap(pg, new HashMap<String, Object> ());
//        System.out.println("..............."+pg.getRecords().size());
//        System.out.println("..............."+pg.getRecords().toString());
//        pm.deleteById(p);
        //pm.insert(p);
        Queue q=new LinkedList();
        System.out.println("调用一次");
        q.offer("String");
        Collection q1=Collections.unmodifiableCollection(xxxx);
        System.out.println(q.poll());
        System.out.println(q1);
        q1.clear();
        //System.out.println(q.remove());
        System.out.println(q.size());
        ArrayList<Object> all=new ArrayList<>();
        all.addAll(xx);
        return all;
    }

    @Override
    public Product findProductById(Integer id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Product> al=new ArrayList();
        al.add(new Product(1l,"华为手机" ,300,5999.0));
        al.add(new Product(2l,"xm手机" ,300,4999.0));
        al.add(new Product(3l,"vivo手机" ,300,3999.0));
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

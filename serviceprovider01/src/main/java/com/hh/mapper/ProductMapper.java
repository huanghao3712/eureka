package com.hh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hh.model.MyPage;
import com.hh.pojo.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ProductMapper extends BaseMapper<Product> {
    @Select("select * from Product where productId = #{productId}")
    Product selectProducts(int productId);

    Product selectProductsMap(int productId);
    @Select("select * from Product ")
    MyPage<Product> mySelectPageMap(MyPage<Product> pg, Map<String, Object> map);

}

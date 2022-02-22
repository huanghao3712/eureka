package com.hh.mapper;

import com.hh.pojo.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {
    @Select("select * from Product where productId = #{productId}")
    Product selectProducts(int productId);

    Product selectProductsMap(int productId);

}

package com.hh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    private Long productId;
    private String productName;
    private Integer productNum;
    private Double productPrice;


}

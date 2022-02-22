package com.hh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@MapperScan("com.hh.mapper")
@SpringBootApplication
@EnableEurekaClient
public class ServiceProvider {

    public static void main(String [] args){
        SpringApplication.run(ServiceProvider.class);


    }
}

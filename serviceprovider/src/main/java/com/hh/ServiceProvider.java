package com.hh;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@MapperScan("com.hh.mapper")
@SpringBootApplication
@EnableEurekaClient
public class ServiceProvider {

   public final static Logger logger = LoggerFactory.getLogger(ServiceProvider.class);

    public static void main(String [] args){
        SpringApplication.run(ServiceProvider.class);


    }
}

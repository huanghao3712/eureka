package com.hh;


import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableFeignClients
public class  ServiceConsumer {

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(){
//
//        return new RestTemplate();
//    }
        @Bean
        public Logger.Level getLog(){
            return  Logger.Level.BASIC;
        }
    public static void main(String [] args){
        SpringApplication.run(ServiceConsumer.class);


    }
}

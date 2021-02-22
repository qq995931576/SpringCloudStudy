package com.achang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/******
 @author 阿昌
 @create 2021-02-14 12:28
 *******
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients //开启Feign功能
public class OrderMain84 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain84.class,args);
    }
}

package com.achang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/******
 @author 阿昌
 @create 2021-02-03 11:13
 *******
 */
@SpringBootApplication
@EnableEurekaServer //表示此项目是eureka的服务注册中心
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}

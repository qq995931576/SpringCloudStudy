package com.achang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/******
 @author 阿昌
 @create 2021-02-08 22:06
 *******
 */

@EnableHystrixDashboard //启用Hystrix仪表板
@SpringBootApplication
public class HystrixDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9001.class, args);
    }

}


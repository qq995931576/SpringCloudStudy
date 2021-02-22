package com.achang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/******
 @author 阿昌
 @create 2021-02-02 12:13
 *******
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {

    // 主启动类
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
    }


}

package com.achang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/******
 @author 阿昌
 @create 2021-02-03 16:19
 *******
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping("/payment/zk")
    public String paymentZk(){
        return "springCloud with zookeeper： "+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}

package com.achang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/******
 @author 阿昌
 @create 2021-02-03 19:06
 *******
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")        //获取端口号
    private String serverPort;
    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        return "springCloud with consul：" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}

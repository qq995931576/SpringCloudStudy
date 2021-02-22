package com.achang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/******
 @author 阿昌
 @create 2021-02-03 19:25
 *******
 */
@RestController
@Slf4j
public class OrderController {

    public static final String INVOKE_URL="http://consul-provider-payment";

    @Resource
    RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return result;
    }



}

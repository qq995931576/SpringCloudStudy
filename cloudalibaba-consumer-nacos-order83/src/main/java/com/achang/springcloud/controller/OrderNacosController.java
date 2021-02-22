package com.achang.springcloud.controller;

import com.achang.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/******
 @author 阿昌
 @create 2021-02-11 19:03
 *******
 */
@RestController
@Slf4j
public class OrderNacosController {

//    @Resource //Rest调用
//    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Resource
    private PaymentFeignService paymentFeignService; //使用Feign的service对象


//    @GetMapping("consumer/payment/nacos/{id}")
//    public String getPayment(@PathVariable("id")Integer id){
//        return restTemplate.getForObject(serverURL + "/payment/nacos/" + id,String.class);
//    }


    @GetMapping("/consumer/payment/feign/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return paymentFeignService.getPayment(id);
    }

}

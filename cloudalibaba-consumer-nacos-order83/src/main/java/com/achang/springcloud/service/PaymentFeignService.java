package com.achang.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/******
 @author 阿昌
 @create 2021-02-11 19:59
 *******
 */
@Component
@FeignClient(value = "nacos-payment-provider")//去注册中心找的服务名
public interface PaymentFeignService {
    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id);
}

package com.achang.springcloud.service;

import com.achang.springcloud.bean.CommonResult;
import com.achang.springcloud.bean.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/******
 @author 阿昌
 @create 2021-02-07 11:31
 *******
 */
@FeignClient(value = "cloud-payment-service") //告知Feign去eureka上找cloud-payment-service名字的微服务
@Service
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")// value值为调用地址
    public CommonResult getPaymentById(@PathVariable("id")Long id);



    @GetMapping("payment/feign/timeout")
    public String paymentFeignTimeout();


}




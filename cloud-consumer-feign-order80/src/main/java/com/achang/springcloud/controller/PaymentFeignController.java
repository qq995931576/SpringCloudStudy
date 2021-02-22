package com.achang.springcloud.controller;

import com.achang.springcloud.bean.CommonResult;
import com.achang.springcloud.bean.Payment;
import com.achang.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/******
 @author 阿昌
 @create 2021-02-07 17:10
 *******
 */
@RestController
@Slf4j //日志
public class PaymentFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        log.info("********查询的id：" + id);
        return paymentFeignService.getPaymentById(id);
    }


    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        log.info("********Feign超时测试***********");
        //openfeign-ribbon，客户端一般默认等待1秒钟
        //人为的将服务提供者的方法设置为3秒钟
        return paymentFeignService.paymentFeignTimeout();
    }













}

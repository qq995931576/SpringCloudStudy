package com.achang.springcloud.controller;

import com.achang.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/******
 @author 阿昌
 @create 2021-02-07 22:22
 *******
 */
@RestController
@Slf4j
//设置全局fallback，类似统一异常处理
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    //没有指明具体的降级方法
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand //没指明，他就会调用在类上表明的全局降级方法
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
//        int i =10/0;
        return result;
    }


    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "消费者80，支付系统繁忙";
    }


    //全局fallback方法，不能有传参
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试！";
    }


}

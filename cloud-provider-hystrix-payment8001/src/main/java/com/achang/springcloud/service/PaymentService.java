package com.achang.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/******
 @author 阿昌
 @create 2021-02-07 20:52
 *******
 */
@Service
public class PaymentService {

    // 正常访问
    public String paymentInfo_OK(Integer id){
        return "线程池：  "+Thread.currentThread().getName()+"  paymentInfo_OK， id = "+id;
    }



    //超时访问方法
    /*
      通过@HystrixCommand来指定哪个方法由Hystrix来接管
         fallbackMethod属性： 指定哪个方法作为兜底方法
     */
    @HystrixCommand(fallbackMethod ="paymentInfo_TimeoutHandler", commandProperties = {
            //设置自身超时调用时间的峰值为 3 秒，峰值内可以正常运行，超过了需要有兜底的方法处理，服务降级fallback
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_timeout(Integer id){

        int timeNumber = 3000;

//        int i = 10/0;

        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池：  "+Thread.currentThread().getName()+"  paymentInfo_timeout， id = "+id + "，  耗时： 秒";
    }


    //服务降级的兜底方法
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池：  "+Thread.currentThread().getName()+"  paymentInfo_TimeoutHandler， id = "+id+", 不好意思 ，系统繁忙";

    }





    //====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),                      //开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),         //请求总数阈值（默认20）
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),   //休眠时间窗口期（休眠多久进入半开模式（单位毫秒，默认5秒））
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),       //请求次数的错误率达到多少跳闸（百分率%，默认50%）
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0){
            throw  new RuntimeException("****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return  Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数,请稍后再试， id: " + id;
    }






}

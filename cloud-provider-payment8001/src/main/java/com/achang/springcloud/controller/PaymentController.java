package com.achang.springcloud.controller;

import com.achang.springcloud.bean.CommonResult;
import com.achang.springcloud.bean.Payment;
import com.achang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/******
 @author 阿昌
 @create 2021-02-02 13:39
 *******
 */
@RestController
@Slf4j //日志
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    //前后端分离，所以不能直接返回对象，数据要先经过CommonResult封装再返回
    @PostMapping(value = "/payment/add")
    public CommonResult add(@RequestBody Payment payment){
        int result = paymentService.add(payment);
        log.info("-----插入结果----： "+ result);

        if (result > 0){
            //插入成功
            return new CommonResult(200,"插入数据库成功 serverPort="+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败 serverPort="+serverPort,null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("-----查询结果----： "+ result);
        if (result != null){
            //查询成功
            return new CommonResult(200,"查询成功 serverPort="+serverPort,result);
        }else {
            return new CommonResult(444,"没有对应记录，查询id： "+id+" ,serverPort="+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        //服务列表清单
        List<String> services = discoveryClient.getServices();
        for (String service:services){
            log.info("**********service****： "+service);
        }

        //获取对应服务名的实例清单
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance s:instances){
            log.info(s.getServiceId()+"\t"+s.getHost()+"\t"+s.getPort()+"\t"+s.getUri());
        }
        return this.discoveryClient;

    }


    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);//停三秒钟

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }



    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "paymentZipkin...";
    }


}

package com.achang.springcloud.controller;

import com.achang.springcloud.bean.CommonResult;
import com.achang.springcloud.bean.Payment;
import com.achang.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/******
 @author 阿昌
 @create 2021-02-02 22:18
 *******
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL ="http://localhost:8001";
    public static final String PAYMENT_URL ="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    //new一个自己写的loadbalancer
    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;



    @GetMapping("/consumer/payment/add")
    public CommonResult<Payment> add(Payment payment){
        log.info("********插入的数据：" + payment);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        log.info("********查询的id：" + id);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }


    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id")Long id){
        log.info("********查询的id：" + id);
        //getForObject两个参数：请求地址，返回的对象类型
//        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);

        //getStatusCode获取状态码，is2xxSuccessful如果是状态码是2xx
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();//返回请求体
        }else {
            return new CommonResult<>(444,"操作失败");
        }

    }

    @GetMapping("/consumer/payment/addEntity")
    public CommonResult<Payment> add2(Payment payment){
        log.info("********插入的数据：" + payment);
        //postForObject分别有三个参数：请求地址，请求参数，返回的对象类型
//        return restTemplate.postForObject(PAYMENT_URL + "/payment/add", payment, CommonResult.class);
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/add", payment, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        //判断服务有效
        if (instances ==null || instances.size() <=0){
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);

        URI uri = serviceInstance.getUri();
        System.out.println(uri);

        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }



    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin(){
        String result = restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin", String.class);
        return result;
    }

}

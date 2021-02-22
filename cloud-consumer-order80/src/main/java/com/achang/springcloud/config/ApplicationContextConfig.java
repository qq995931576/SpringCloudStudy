package com.achang.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/******
 @author 阿昌
 @create 2021-02-02 22:23
 *******
 */
@Configuration
public class ApplicationContextConfig {

    //往容器中添加一个RestTemplate
    //RestTemplate提供了多种便捷访问远程http访问的方法
    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
//applicationContext.xml <bean id="" class="">

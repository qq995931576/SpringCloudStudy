package com.achang.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/******
 @author 阿昌
 @create 2021-02-14 12:29
 *******
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced //Ribbon负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

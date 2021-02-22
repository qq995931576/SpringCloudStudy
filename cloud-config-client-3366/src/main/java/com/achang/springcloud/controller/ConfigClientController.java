package com.achang.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/******
 @author 阿昌
 @create 2021-02-10 13:06
 *******
 */
@RestController
@RefreshScope  //开启刷新功能
public class ConfigClientController {

    @Value("${config.info }")	//spring的@Value注解
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return "serverPort： " + serverPort+ "configInfo： " + configInfo;
    }
}

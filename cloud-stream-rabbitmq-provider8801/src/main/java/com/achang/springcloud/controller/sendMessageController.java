package com.achang.springcloud.controller;

import com.achang.springcloud.service.IMessageProvider;
import com.achang.springcloud.service.impl.IMessageProviderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/******
 @author 阿昌
 @create 2021-02-11 13:30
 *******
 */
@RestController
public class sendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }

}

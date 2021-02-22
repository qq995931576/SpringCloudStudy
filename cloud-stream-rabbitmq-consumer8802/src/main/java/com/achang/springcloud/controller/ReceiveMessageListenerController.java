package com.achang.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

/******
 @author 阿昌
 @create 2021-02-11 13:56
 *******
 */
@EnableBinding(Sink.class)
@Controller
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)   //通过这个注解，监听Sink的输入
    public void input(Message<String> message){
        System.out.println("消费者1号------> 收到的消息： "+message.getPayload()+ "\t port： "+serverPort);
    }

}

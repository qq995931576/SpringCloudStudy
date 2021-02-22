package com.achang.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/******
 @author 阿昌
 @create 2021-02-13 16:53
 *******
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        log.info(Thread.currentThread().getName()+"\t"+"。。。。testA");
        return "----testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName()+"\t"+"。。。。testB");
        return "----testB";
    }

    @GetMapping("/testC")
    public String testC(){
        //暂停1秒钟线程
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
//        log.info(Thread.currentThread().getName()+"\t"+"。。。testC，测试 R T");

        log.info("testC 异常比例");
        int age = 10/0;
        return "----testC";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常数");
        int age = 10 / 0;
        return "----testE 测试异常数";
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value ="testHotKey",blockHandler = "deal_testHotKey")
    //value值：随意设定，只要名称唯一，id唯一名字
    //blockHandler：指定哪个方法作为兜底方法
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        return "-------testHotKey";
    }

    //兜底方法
    public String deal_testHotKey(String p1, String p2, BlockException blockException){
        return "-------deal_testHotKey";
        // sentinel的默认提示都是： Blocked by Sentinel (flow limiting)
    }
















}









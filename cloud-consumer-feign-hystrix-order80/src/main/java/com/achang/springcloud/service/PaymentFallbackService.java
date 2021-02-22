package com.achang.springcloud.service;

import org.springframework.stereotype.Component;

/******
 @author 阿昌
 @create 2021-02-08 14:10
 *******
 */
//统一为接口里面的方法进行异常处理
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back，ooookkkkk paymentInfo_OK--------------";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back，555555555 paymentInfo_TimeOut--------------";
    }
}

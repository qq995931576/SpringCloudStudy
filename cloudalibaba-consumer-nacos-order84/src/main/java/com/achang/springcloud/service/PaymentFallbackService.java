package com.achang.springcloud.service;

import com.achang.springcloud.bean.CommonResult;
import com.achang.springcloud.bean.Payment;
import org.springframework.stereotype.Component;

/******
 @author 阿昌
 @create 2021-02-14 14:21
 *******
 */
@Component //组件加入ioc容器，不要忘记了
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回，---PaymentFallbackService",new Payment(id,"ErrorSerial"));
    }
}

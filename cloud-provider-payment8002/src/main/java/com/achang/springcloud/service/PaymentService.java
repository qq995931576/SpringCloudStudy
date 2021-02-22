package com.achang.springcloud.service;

import com.achang.springcloud.bean.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/******
 @author 阿昌
 @create 2021-02-02 13:30
 *******
 */

public interface PaymentService {

    //增
    public int add(Payment payment);

    //查
    public Payment getPaymentById(@Param("id")Long id);
}

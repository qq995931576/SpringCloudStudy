package com.achang.springcloud.dao;

import com.achang.springcloud.bean.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/******
 @author 阿昌
 @create 2021-02-02 12:57
 *******
 */
@Mapper
public interface PaymentDao {
    //增
    public int add(Payment payment);

    //查     加上@Param注解，mapper中就可以采用#{}的方式把@Param注解括号内的参数进行引用
    public Payment getPaymentById(@Param("id")Long id);

    //这里用增和改进行演示，有兴趣的可以自己加其他的方法
}

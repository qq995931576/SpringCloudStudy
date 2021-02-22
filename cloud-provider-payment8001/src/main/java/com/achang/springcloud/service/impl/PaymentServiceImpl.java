package com.achang.springcloud.service.impl;

import com.achang.springcloud.bean.Payment;
import com.achang.springcloud.dao.PaymentDao;
import com.achang.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/******
 @author 阿昌
 @create 2021-02-02 13:32
 *******
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    //@Autowired也可以
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

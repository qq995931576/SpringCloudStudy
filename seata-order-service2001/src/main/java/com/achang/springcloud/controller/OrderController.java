package com.achang.springcloud.controller;

import com.achang.springcloud.domain.CommonResult;
import com.achang.springcloud.domain.Order;
import com.achang.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/******
 @author 阿昌
 @create 2021-02-14 19:37
 *******
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建完成");
    }

}

package com.achang.springcloud.service;

import com.achang.springcloud.domain.Order;
import org.springframework.stereotype.Service;

/******
 @author 阿昌
 @create 2021-02-14 19:06
 *******
 */

public interface OrderService {
    public void  create(Order order);

}

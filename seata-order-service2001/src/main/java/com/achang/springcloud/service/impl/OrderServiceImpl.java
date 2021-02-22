package com.achang.springcloud.service.impl;

import com.achang.springcloud.dao.OrderDao;
import com.achang.springcloud.domain.Order;
import com.achang.springcloud.service.AccountService;
import com.achang.springcloud.service.OrderService;
import com.achang.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/******
 @author 阿昌
 @create 2021-02-14 19:09
 *******
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：下订单->扣库存->减余额->改状态
     */
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("--------开始【新建订单】");
        //1、新建订单
        orderDao.create(order);

        log.info("--------订单微服务开始调用【库存】，开始扣减库存数量");
        //2、扣减库存
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("--------订单微服务开始调用【库存】，结束扣减库存数量");

        log.info("--------订单微服务开始调用【账户余额】，开始扣减钱");
        //3、扣减账户余额
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("--------订单微服务开始调用【账户余额】，结束扣减钱");

        //4、修改订单状态，从0到1，1代表已经完成
        log.info("--------修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("--------修改订单状态完成");

        log.info("下订单结束了-----------------");
    }

}

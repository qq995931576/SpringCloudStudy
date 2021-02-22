package com.achang.springcloud.service.impl;

import ch.qos.logback.core.util.TimeUtil;
import com.achang.springcloud.dao.AccountDao;
import com.achang.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/******
 @author 阿昌
 @create 2021-02-14 21:09
 *******
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("---> AccountService中扣减账户余额");
        
        //模拟超时异常，全局事务回滚
        //睡眠20s
//        try{TimeUnit.SECONDS.sleep(20);}catch(InterruptedException e){ e.printStackTrace();}

        accountDao.decrease(userId,money);
        log.info("---> AccountService中扣减账户余额完成");
    }
}

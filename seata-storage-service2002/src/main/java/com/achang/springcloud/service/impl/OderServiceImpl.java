package com.achang.springcloud.service.impl;

import com.achang.springcloud.dao.StorageDao;
import com.achang.springcloud.domain.CommonResult;
import com.achang.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/******
 @author 阿昌
 @create 2021-02-14 20:44
 *******
 */
@Service
@Slf4j
public class OderServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("----> StorageService中扣减库存");
        storageDao.decrease(productId, count);
        log.info("----> StorageService中扣减库存完成");
    }
}

package com.achang.springcloud.controller;

import com.achang.springcloud.domain.CommonResult;
import com.achang.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/******
 @author 阿昌
 @create 2021-02-14 20:50
 *******
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId,Integer count){
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功!");
    }
}

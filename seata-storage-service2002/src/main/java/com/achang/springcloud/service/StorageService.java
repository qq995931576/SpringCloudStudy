package com.achang.springcloud.service;

import com.achang.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/******
 @author 阿昌
 @create 2021-02-14 20:42
 *******
 */
public interface StorageService {

    void decrease(Long productId, Integer count);

}

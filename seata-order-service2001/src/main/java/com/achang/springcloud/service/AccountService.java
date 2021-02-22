package com.achang.springcloud.service;

import com.achang.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/******
 @author 阿昌
 @create 2021-02-14 19:12
 *******
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId")Long userId,@RequestParam("money") BigDecimal money);

}

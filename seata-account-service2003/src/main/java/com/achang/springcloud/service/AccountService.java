package com.achang.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/******
 @author 阿昌
 @create 2021-02-14 21:08
 *******
 */
public interface AccountService {
    void decrease(@RequestParam("userId")Long userId, @RequestParam("money")BigDecimal money);
}

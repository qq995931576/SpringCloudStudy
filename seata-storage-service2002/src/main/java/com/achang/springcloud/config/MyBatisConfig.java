package com.achang.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/******
 @author 阿昌
 @create 2021-02-14 20:51
 *******
 */
@Configuration
@MapperScan({"com.achang.springcloud.dao"})
public class MyBatisConfig {
}

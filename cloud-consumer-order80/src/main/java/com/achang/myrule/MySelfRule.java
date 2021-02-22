package com.achang.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/******
 @author 阿昌
 @create 2021-02-04 23:31
 *******
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();    //根据上面的各种实现类的负载机制，new一个你想要的返回，这里负载均衡机制改为随机
    }
}

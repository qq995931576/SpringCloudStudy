package com.achang.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/******
 @author 阿昌
 @create 2021-02-09 22:35
 *******
 */
@Component
@Slf4j
//@Order(0)   //设置过滤器优先次序
public class MyLogGateWayFilter implements GlobalFilter, Ordered {//Ordered优先次序设置；GlobalFilter过滤器设置


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("**************come in MyLogGateWayFilter：" + new Date());

        //获取request中的uname参数
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");

        if(uname == null){
            log.info("*******用户名为null，非法用户！！");
            //设置响应，不被接受
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);

            return exchange.getResponse().setComplete();
        }

        //返回chain.filter(exchange)，放行
        return chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        //返回值是过滤器的优先级，越小优先级越高（最小-2147483648，最大2147483648）
        return 0;
    }

}

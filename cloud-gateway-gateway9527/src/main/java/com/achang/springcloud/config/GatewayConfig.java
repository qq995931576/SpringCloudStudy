package com.achang.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/******
 @author 阿昌
 @create 2021-02-09 12:30
 *******
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator CustomRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_achang"
                ,r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .build();
                //现在访问localhost:9527/guonei 会被转发到 http://news.baidu.com/guonei


        return routes.build();

    }

    @Bean
    public RouteLocator CustomRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_achang"
                ,r -> r.path("/guoji")
                        .uri("http://news.baidu.com/guoji"))
                .build();
        //现在访问localhost:9527/guonei 会被转发到 http://news.baidu.com/guoji


        return routes.build();

    }

}

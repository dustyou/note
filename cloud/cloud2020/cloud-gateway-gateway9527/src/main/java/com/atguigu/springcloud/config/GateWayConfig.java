package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator costumRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        //配置了一个id为rout_name的路由规则
        //当访问地址http://localhost:9527//guonei时会自动转发到地址: http://news.baidu.com/guonei
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
    
        routes.route("path_rout_atguigu",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"));
        
        return routes.build();
    }
}

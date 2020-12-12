package com.atguigu.springcloud.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    
    @Bean
    Logger.Level feignLoggerlevel() {
        return Logger.Level.FULL;
    }
    
}





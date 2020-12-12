package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystixService paymentHystixService;
    
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystixService.paymentInfo_OK(id);
    }
    
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "15000")})
//    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymentHystixService.paymentInfo_TimeOut(id);
    }
    
    public String paymentTimeOutFallbackMethod(Integer id) {
        return "我是消费者80, 对方支付系统繁忙, 请10秒钟后再试试或者自己运行出错, 请检自己,~~~~(>_<)~~~~";
    }
    
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息, 请稍后再试 /(ToT)/";
    }
    
}

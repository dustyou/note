package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_OK, o(Π——Π)o";
    }
    
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_TimeOut, o(Π——Π)o";
    }
}

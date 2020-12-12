package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {
    
    @Resource
    private IMessageProvider messageProvider;
    
    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
    @GetMapping("/test")
    public String test() {
        return "test";
    }
    
}

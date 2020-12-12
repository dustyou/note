package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {
    
    @Resource
    private AccountService accountService;
    
    @RequestMapping("/account/decrease")
    public CommonResult decrease(Long userId, BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减账户余额成功");
    }
    
    @GetMapping("/getname")
    public CommonResult getName(@RequestParam("name") String name) {
        return new CommonResult(200, name);
    }
}

package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Order;

public interface OrderService {
    
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
    
    CommonResult getName(String name);
    
}

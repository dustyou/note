package com.itheima.proxy;


//对生产厂家要求的接口
public interface IProducer {
    //销售
    void saleProduct(Float money);
    
    //售后
    void afterService(Float money);
}

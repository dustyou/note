package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.remoting.RemoteTimeoutException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "   paymentInfo_OK" + id + "hhhO(∩_∩)O哈哈哈~";
        
    }
    
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {@HystrixProperty(name =
            "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    public String paymentInfo_TimeOut(Integer id) {
        Integer timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + "   paymentInfo_TimeOut" + id + "hhhO(∩_∩)O哈哈哈~" + "耗时" + timeNumber + "秒钟";
        
    }
    
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "   paymentInfo_TimeOurHandler" + id + "~~~~(>_<)~~~~ " +
                "呜呜呜" + "耗时";
    }
    //----------服务熔断---------------
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数并发超过这个次数,开启断路器
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),//时间窗口期
            @HystrixProperty(name ="circuitBreaker.errorThresholdPercentage",value="60")//失败率达到多少后跳闸  60%, 比如,10次造求6次失败则跳闻
            
    
    }
    )
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RemoteTimeoutException("****id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "/t" + "调用成功, 流水号" + serialNumber;
        
    }
    
    
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能为负数, 请稍后再试 /(ToT)/~~" + id;
    
    }
}

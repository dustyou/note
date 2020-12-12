package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
@Slf4j
@RestController
public class FlowLimitController
{
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }
    
    @GetMapping("/testB")
    public String testB() {
        
        return "------testB";
    }
    
    @GetMapping("/testD")
    public String testD() {
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("testD 测试RT");
        
        log.info("testD 测试异常比例");
        int age = 10/0;
        return "----testD";
    }
    
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")//value名称只要唯一即可, 在这里设置为testHotKey方便统一规范
    public String testHotKey(@RequestParam(value="p1", required = false) String p1,
                             @RequestParam(value="p1", required = false) String p2
                             ) {
        return "----testHotKey";
    }
    
    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "------deal_testHotKey";//sentinel系统的默认提示: Blocked by Sentinel(flow limiting)
    }
}

package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)//定义消息的推送管道
//表示当前这个类是 Source负责生产消息,并目发送给 channel
public class MessageProvider implements IMessageProvider {
    
    @Resource
    private MessageChannel output;//消息发送管道
    //我们将消息发送给channel
    
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        //build方法会构建一个Message类
        System.out.println("******serial: " + serial);
        return null;
    }
}

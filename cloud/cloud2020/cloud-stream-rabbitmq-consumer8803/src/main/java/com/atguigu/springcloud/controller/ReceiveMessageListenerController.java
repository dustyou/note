package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class) //启用绑定, 就是表示当前类是sink, 负责接收channel发送过来的数据进行消费
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;
    
    @StreamListener(Sink.INPUT) //这里表示监听sink的input, 而input我们在配置文件中配置了绑定在一个指定 Exchange上获取数据
    public void input(Message<String> message) {
        System.out.println("消费者2号，接收到的消息---> message: "+message.getPayload()+"\t port:"+serverPort);
    }
    
}

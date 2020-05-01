package com.itheima.test;

import com.itheima.service.impl.Accountservice;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPtest {
    @Test
    public void AopTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        Accountservice accountservice = ac.getBean("accountService", Accountservice.class);
        accountservice.save();
    }
    
//    public static void main(String[] args) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        Accountservice accountservice = ac.getBean("accountService", Accountservice.class);
//        accountservice.save();
//    }
}

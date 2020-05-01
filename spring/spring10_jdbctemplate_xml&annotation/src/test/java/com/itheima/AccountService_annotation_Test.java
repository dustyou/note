package com.itheima;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountService_annotation_Test {
    ApplicationContext ac;
    IAccountDao accountDao;
    IAccountService accountService;
    
    @Before
    public void BeforeTest(){
        ac = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println("aa");
        accountService = ac.getBean("accountService",IAccountService.class);
    }
    
    @Test
    public void AccountDaoTest(){
        Account account = accountService.findAccountById(2);
        System.out.println(account);
    }
    
    @Test
    public void AccountDaoTest2() {
        Account account = accountService.findAccountByName("aaa");
        System.out.println(account);
    }
    
    
    
    
}

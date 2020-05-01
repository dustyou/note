package com.itheima;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Account_annotation_Test {
    ApplicationContext ac;
    IAccountDao accountDao;
    
    @Before
    public void BeforeTest(){
        ac = new AnnotationConfigApplicationContext("com.itheima");
        accountDao = ac.getBean("accountDao2",IAccountDao.class);

    }
    
    @Test
    public void AccountDaoTest(){
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
    }
    
    @Test
    public void AccountDaoTest2() {
        Account account = accountDao.findAccountByName("aaa");
        System.out.println(account);
    }
    
    
}

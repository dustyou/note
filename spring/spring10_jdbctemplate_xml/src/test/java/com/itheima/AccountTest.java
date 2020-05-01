package com.itheima;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
    ApplicationContext ac;
    IAccountDao accountDao;
    
    @Before
    public void BeforeTest(){
        ac = new ClassPathXmlApplicationContext("bean.xml");
        accountDao = ac.getBean("accountDao",IAccountDao.class);

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

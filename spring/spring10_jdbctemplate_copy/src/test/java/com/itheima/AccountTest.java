package com.itheima;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
    @Test
    public void AccountTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao",IAccountDao.class);
        Account account = accountDao.getAccountById(1);
        System.out.println(account);
    }
    
}

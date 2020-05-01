package com.itheima.test;


import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

//    @Test
//    public void aoptest() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService as = (IAccountService)ac.getBean("accountService");
//        Account account = new Account();
//        as.saveAccount(account);
//}
    
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = (IAccountService)ac.getBean("accountService");
        Account account = new Account();
        as.saveAccount();
        as.updateAccount(account);
        as.deleteAccount(0);
    }


}


package com.itheima.test;


import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccounServiceTest {
//    @Autowired
//    @Qualifier("proxyAccountService")
    private IAccountService as = new AccountServiceImpl();


}

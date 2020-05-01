package ui;

import com.itheima.service.IAccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    @Test
    public void test1() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = (IAccountService) ac.getBean("accountServiceImpl");
//        System.out.println(as);
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(adao);
//        adao.saveAccount();
        as.save();
        ac.close();
    
    }
}

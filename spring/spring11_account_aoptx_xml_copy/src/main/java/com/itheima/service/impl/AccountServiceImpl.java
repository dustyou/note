package com.itheima.service.impl;


import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    //@Autowired

    
    
    @Override
    public void  saveAccount() {
        System.out.println("执行了保存");
    }
    
    @Override
    public void updateAccount(Account account) {
        System.out.println("执行了更新");
    }
    
    @Override
    public int deleteAccount(Integer accountId) {
        System.out.println("执行了删除");
        return 0;
    }
}


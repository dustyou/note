package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    //@Autowired
    private IAccountDao accountDao;
    
    private TransactionManager txmanager;
    
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }
    
    public void setTxmanager(TransactionManager txmanager) {
        this.txmanager = txmanager;
    }
    
    
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


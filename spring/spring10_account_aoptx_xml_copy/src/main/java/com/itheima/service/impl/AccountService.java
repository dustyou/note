package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("accountService")
public class AccountService implements IAccountService {
    @Autowired
    @Qualifier("accountDao2")
    private IAccountDao accountDao;
    
    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }
    
    @Override
    public Account findAccountByName(String accountName) {
        return accountDao.findAccountByName(accountName);
    }
    
    @Override
    public void updateAccount(Account account) {
    
    }
}

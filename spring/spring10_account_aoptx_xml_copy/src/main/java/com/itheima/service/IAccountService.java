package com.itheima.service;

import com.itheima.domain.Account;

public interface IAccountService {
    Account findAccountById(Integer accountId);
    Account findAccountByName(String accountName);
    void updateAccount(Account account);
}

package com.itheima.service;

import com.itheima.domain.Account;

/*
* 账户的业务层接口
*
* */
public interface IAccountService {

    //保存 模拟保存账户
    void saveAccount();
    
    //更新
    void updateAccount(Account account);
    
    //删除
    int deleteAccount(Integer accountId);
    
    
    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    
}

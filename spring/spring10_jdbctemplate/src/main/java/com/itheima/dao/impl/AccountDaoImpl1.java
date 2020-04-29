package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;


//持久层的实现
//继承JdbcDaoSupport,减少注入和定义的重复代码
//JdbcDaoSupport其实spring已经提供，不用自己写
//但是不能在源码上加注解
//如果采用注解配置，选择AccountImpl版本
//如果采用xml配置，选择这个版本

public class AccountDaoImpl1 extends JdbcDaoSupport implements IAccountDao {
    
    //这里不写JdbcTemplate，也就不能加@Autowired注解（因为在继承的源码中不能加注解，源码不能被修改）
    //只能在xml中配置
//    private JdbcTemplate jdbcTemplate;
    
    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }
    
    @Override
    public Account findAccountByName(String accountName) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class));
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1) {
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }
    
    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name=?, money=? where id=?", account.getName(), account.getMoney(), account.getId());
    }
}

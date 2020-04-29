package com.itheima.jdbctemplate;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateDemo4 {
    public static void main(String[] args) {

//        JdbcTemplate的CRUD操作
    //1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. 获取对象
        IAccountDao accountDao = (IAccountDao) ac.getBean("accountDao1");
        //3. 执行操作
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
        account.setMoney(30000f);
        accountDao.updateAccount(account);
        System.out.println(account);
    
    }
    
    
    
}

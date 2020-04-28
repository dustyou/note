package com.itheima.dao.impl;


import org.springframework.jdbc.core.JdbcTemplate;

//此类用于抽取Dao中的重复代码
public class JdbcDaoSupport {
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}

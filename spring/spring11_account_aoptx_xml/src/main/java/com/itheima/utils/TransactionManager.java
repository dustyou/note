package com.itheima.utils;


import java.sql.SQLException;

/*
* 和事务相关的工具类，它包含了开启事务，提交事务，回滚事务和释放连接
*
* */
public class TransactionManager {
    
    private ConnectionUtils connectionUtils;
    
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }
    
    /*
     * 开启事务
     * */
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
    /*
     * 提交事务
     * */
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
    /*
     * 回滚事务
     * */
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
    /*
     * 释放事务
     * */
    public void release() {
        try {
            connectionUtils.getThreadConnection().close();//还会连接池中，不是真正的关闭
            connectionUtils.removeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
}

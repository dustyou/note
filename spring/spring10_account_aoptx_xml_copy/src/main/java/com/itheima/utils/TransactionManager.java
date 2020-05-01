package com.itheima.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("txManager")
public class TransactionManager {
    public void beginTransaction() {
        System.out.println("before transaction");
    }
    
    public void commit() {
        System.out.println("commit");
    }
    
    public void release() {
        System.out.println("release");
    }
    
    public void rollback() {
        System.out.println("rollback");
    }
    
}

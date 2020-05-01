package com.itheima.service.impl;

import com.itheima.service.IAccountService;

import java.util.*;

public class AccountServiceImpl3 implements IAccountService {
    private String [] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;
    
    public void save() {
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps);
    }
    public AccountServiceImpl3() {
        System.out.println("AccountService 对象创建了");
        
    }
    
    public void setMyStr(String[] myStr) {
        this.myStrs = myStr;
    }
    
    public void setMyList(List<String> myList) {
        this.myList = myList;
    }
    
    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }
    
    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }
    
    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }
}

package com.itheima.ssm.utils;

public class Derived extends Base{
    
    public static void main(String[] args) {
        Base derived = new Derived();
        derived.f1();
        
    }
    
    @Override
    public void f1() {
        System.out.println("f1() in derived");
        
    }
    

    
}

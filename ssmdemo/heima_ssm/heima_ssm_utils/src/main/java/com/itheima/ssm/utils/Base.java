package com.itheima.ssm.utils;

public class Base {
    private String s1 = "base string";
    
    
    public String getS1() {
        return s1;
    }
    
    public void setS1(String s1) {
        this.s1 = s1;
    }
    
//    {
//        System.out.println("none static code, f1() in base, s1 = "+ s1);
//        f1();
//
//    }
    static {
        System.out.println("static code, static f2() in base");
        f2();
    }
    
    public Base() {
        f1();
        System.out.println("s1="+s1);
    }
    
    private static void f2() {
        System.out.println("static f2() in base");
    }
    
    
    public void f1() {
        System.out.println("f1() in base");
    }
}

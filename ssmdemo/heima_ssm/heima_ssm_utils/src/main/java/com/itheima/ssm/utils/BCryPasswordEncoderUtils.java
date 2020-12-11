package com.itheima.ssm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
    
    public static void main(String[] args) {
        String password = "123";
        String pwd = encodPassword(password);
        System.out.println(pwd);
//        $2a$10$SvrLLsN15SDY3PPXFARyD.jwNW4K2aH1SWqzITqwPqksPsh6Z4yCa
//        $2a$10$fsE90FMgMI8EO9T7fN.OBuTw/BXSsUrzlthB4hc7ka.yTwf1L8lwK
//        $2a$10$wKp5Qws1D6GO2qpJYGnbTeoeNIN3OSEVb0Ov3up.nC7NtrFyn3oBu
    
    }
}

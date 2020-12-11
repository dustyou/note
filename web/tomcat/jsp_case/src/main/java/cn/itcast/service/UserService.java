package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

public interface UserService {
//    查询所有用户信息
    public List<User> findAll();
    //登录方法
    void login(User user);
    
    void update(User user);
    
    //保存user
    void addUser(User user);
}

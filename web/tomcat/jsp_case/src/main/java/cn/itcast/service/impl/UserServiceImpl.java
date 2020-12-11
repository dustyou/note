package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao;
    
    @Override
    public void update(User user) {
    
    }
    
    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }
    
    @Override
    public List<User> findAll() {
        return null;
    }
    
    @Override
    public void login(User user) {
    
    }
}

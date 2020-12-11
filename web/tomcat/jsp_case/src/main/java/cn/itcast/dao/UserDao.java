package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {
    void update(User user);
    
    void addUser(User user);
}

package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

public class UserDaoImpl implements UserDao {
    @Override
    public void update(User user) {
    
    }
    
    @Override
    public void addUser(User user) {
        String sql = "insert into user values()";
    }
}

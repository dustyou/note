package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public UserInfo findById(int id) throws Exception {
        return userDao.findById(id);
    }
    
    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }
    
    @Override
    public void save(UserInfo userInfo) throws Exception {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findUserByUsername(username);
//            System.out.println(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String password = userInfo.getPassword();
        //处理自己的用户对象封装成UserDetails
        User user = new User(userInfo.getUsername(), password, userInfo.getStatus()==0?false:true, true, true, true, getAuthority(userInfo.getRoles()));
//        System.out.println("user: "+user);
        return user;
    }
    
    //作用是返回一个List集合, 集合中装入的是角色
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role: roles
             ) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }
    
    @Override
    public List<Role> findOtherRoles(int userId) throws Exception {
        return userDao.findOtherRoles(userId);
    }
    
    @Override
    public void addRoleToUser(int userId, int[] roleIds) {
        for (int roleId: roleIds
             ) {
            userDao.addRoleToUser(userId,roleId);
    
        }
    }
}

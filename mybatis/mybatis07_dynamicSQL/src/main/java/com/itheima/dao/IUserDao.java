package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//用户的持久层接口
public interface IUserDao {
//    查询所有用户
    List<User> findAll();
//    保存用户

    User findById(Integer userId);
    
    //根据名称模糊查询用户信息
    List<User> findByName(String username);
    
    //根据QueryVo中的条件查询用户
    List<User> findUserByVo(QueryVo vo);
    
    /**
     *根据传入参数条件
     * @param user 查询的条件，可能有用户名，性别，地址，也可能什么都没有
     * @return
     */
    List<User> findUserByCondition(User user);
    
    /**
     * 根据queryvo中提供的id集合，查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
    
    
}

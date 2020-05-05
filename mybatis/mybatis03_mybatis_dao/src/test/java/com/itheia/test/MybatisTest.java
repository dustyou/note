package com.itheia.test;

import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws Exception{
        //1. 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();//构建者模式：把对象的创建细节隐藏，使用者直接调用方法即可拿到对象
        SqlSessionFactory factory = builder.build(in);//创建工厂mybatis使用了构建者模式，builder就是构建者
        //3. 使用工厂创建dao对象
        IUserDao userDao = new UserDaoImpl(factory);
        //5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }

        in.close();
    }
    
    
}

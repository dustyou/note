package com.itheia.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;
    
    @Before//在测试方法执行之前执行
    public void init() throws IOException{
        //1. 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();//构建者模式：把对象的创建细节隐藏，使用者直接调用方法即可拿到对象
        SqlSessionFactory factory = builder.build(in);//创建工厂mybatis使用了构建者模式，builder就是构建者
        //3. 使用工厂生产SqlSession对象
        session = factory.openSession();//生产SqlSession使用了工厂模式，优势，解耦
        // 4. 使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);//创建Dao接口实现类使用了代理模式，优势：不修改源码的基础上对已有的方法增强
    }
    
    @After//在测试方法执行之后执行
    public void destroy() throws IOException {
        //提交事务
        session.commit();
        //6. 释放资源
        session.close();
        in.close();
    }
    
    //测试查询所有方法
    @Test
    public void testFindAll() throws Exception {

        //5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }
    
    //测试保存操作
    @Test
    public void testSaveUser() throws IOException {
        User user = new User();
        user.setUsername("mybatis last insert id test");
        user.setAddress("北京市顺义局");
        user.setSex("男");
        user.setBirthday(new Date());


        //5. 使用代理对象执行方法
        System.out.println("保存操作之前，"+user);
        userDao.saveUser(user);
        System.out.println("保存操作之后，"+user);
        //提交事务
        //设置了autocommit=false，所以必须要有提交事务，下面这一行代码，否则不能提交，事务回滚，会占用一个id，下次成功insert数据id会向后一个
        //移到destroy方法中
//        session.commit();
    
    }
    
    //测试更新操作
    @Test
    public void testUpdateUser() throws Exception {
        
        User user = new User();
        user.setId(52);
        user.setUsername("mybatis updateuser");
        user.setAddress("北京市顺义局");
        user.setSex("男");
        user.setBirthday(new Date());
    
        //5. 使用代理对象执行方法
        userDao.updateUser(user);
    }
    
    //测试删除操作
    @Test
    public void testDeleteUser() throws Exception {

        
        //5. 使用代理对象执行方法
        userDao.deleteUser(48);
    }
    
    //测试根据id查询一个
    @Test
    public void testFindById() throws Exception {
        
        //5. 使用代理对象执行方法
        User user = userDao.findById(41);
        System.out.println(user);
        
    }
    
    //
    @Test
    public void testFindByName() throws Exception {
        
        //5. 使用代理对象执行方法
        List<User> users = userDao.findByName("%王%");
        //查询不到结果，需要在jdbc连接配置中的url后加上?characterEncoding=utf-8
        for (User user: users) {
            System.out.println(user);
        }
//        System.out.println(users.isEmpty());
//        System.out.println(users);
    
    }
    
    //查询总记录条数
    @Test
    public void testFindTotal() throws Exception {
        
        //5. 使用代理对象执行方法
        int total = userDao.findTotal();
        System.out.println(total);
        
    }
    
    //
    @Test
    public void testFindByVo() throws Exception {
    
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        //5. 使用代理对象执行方法
        List<User> users = userDao.findUserByVo(vo);
        //查询不到结果，需要在jdbc连接配置中的url后加上?characterEncoding=utf-8
        for (User u: users) {
            System.out.println(u);
        }
//        System.out.println(users.isEmpty());
//        System.out.println(users);
    
    }
}




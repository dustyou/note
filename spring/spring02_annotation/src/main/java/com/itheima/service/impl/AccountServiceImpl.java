package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;
/*
 * 曾经xml的注解
 * <bean id="accountService2" class="com.itheima.service.impl.AccountServiceImpl" scope init-method destroy-method >
    <property name="", value/ref=""></property>
    * </beans>
 *用于创建对象的
 *      作用和在xml配置文件中编写一个<bean>标签实现的功能是一样的
 *      @Component
 *          作用：用于把当前类对象存入spring容器中
 *          属性：value：用于指定bean的id，当我们不写时，它的默认值是当前类名，首字母改成小写
 *      @Controller：一般用在表现层
 *      @Service：一般用在业务层
 *      @Respository：一般用在持久层
 *      以上三个注解的作用和属性与Component是一模一样的，可以通用
 * 用于注入数据的
 *      作用和在xml配置文件中的<bean>标签中写一个<property>标签的作用是一样的
 *      @Autowired
 *          作用：自动安装类型注入。只要容器中有位移的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *          出现位置：可以是变量上，也可以是方法上
 *          细节：在使用注解注入时，set方法就不是必须的
 *          如果只有一个符合类型的类，就直接注入
 *          如果有两个相同类型的类，按名字查找对应的id并注入，如果找到相同名字的id就注入成功，找不到就报错
 *      @Qualifier
 *          作用：在按照类中注入的基础上再按照名称注入。它在给类成员注入时不能单独使用，但是在给方法参数注入时可以
 *          属性：value：用于指定注入bean的id
 *      @Resource
 *          作用：直接按照bean的id注入，可以独立使用
 *          属性：name：用于执行bean的id
 *          @Resource(name="xxx")相当于@Autowired+@Qualifier(value="xxx")
 * 以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现
 * 另外，集合类型的注入只能通过xml来实现
 *      @Value
 *          作用：用于注入基本类型和String类型的数据
 *          属性：value，用于指定数据的值，它可以使用spring中SpEL（也就是spring的el表达式）
 *              SpEL的写法：$(表达式)
 *
 *
 *
 * 用于改变作用范围的
 *      作用和在<bean>标签中使用scope属性实现的功能是一样的
 *      @Scope
 *          作用：用于指定bean的作用范围
 *          属性：value，指定范围的取值，常用取值：singleton,prototype,默认singleton
 * 和生命周期相关的(了解)
 *      作用和<bean>标签中使用init-method destroy-method作用是一样的
 *          @PreDestroy
 *              作用：用于指定销毁方法
 *          @PostConstruct
 *              作用：用于指定初始化方法
 * */
@Component//(value = "accountSericeImpl")
//如果注解中有一个value属性，那么value= 是可以不写的，如果有多个属性或者位移的一个属性不是value，就不能不写
//@Component("accountServiceImpl")
@Scope("singleton")
public class AccountServiceImpl implements IAccountService {
//    @Autowired
//    @Qualifier("accountDao1")
////    @Qualifier("accountDao2")
//    //@Qualifier用来指定被注入的类的id，必须要和@Autowired组合在一起使用
    @Resource(name = "accountDao2")
    private IAccountDao accountDao2;
    @Value("test")
    private String name;
    private Integer age;
    private Date birthday;
    public AccountServiceImpl() {
        System.out.println("AccountService 对象创建了");

    }
    
    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        
    }
    
    public IAccountDao getAccountDaoImpl() {
        return accountDao2;
    }
    
    public void setAccountDaoImpl(IAccountDao accountDaoImpl) {
        this.accountDao2 = accountDaoImpl;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public void save() {
        System.out.println("AccountServiceImpl中的save方法执行了"+name+","+age+","+birthday);
        accountDao2.saveAccount();
    }
    @PostConstruct
    public void init() {
        System.out.println("对象初始化了");
    }
    @PreDestroy
    //多例对象的销毁spring不负责，如果scope是prototype，这个方法不会执行
    public void destroy() {
        System.out.println("对象销毁了");
    }
    

}

package com.itheima.ssm.controller;

import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    
    private Date visitTime;//开始的时间
    long time;
    private Class clazz;//访问的类
    private Method method;//访问的方法
    private String url;
    private String ip;
    private String username;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    ISysLogService sysLogService;
    
    //前置通知 获取开始时间, 执行的类是哪一个, 执行的是哪一个方法
    @Before("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        visitTime = new Date();//当前时间, 就是开始访问的时间
        clazz = joinPoint.getTarget().getClass();//具体要访问的类
        String methodName = joinPoint.getSignature().getName();//获取访问的方法的名称
        Object[] args = joinPoint.getArgs();//获取访问的方法的参数
        //获取具体执行的方法的Method对象
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);//只能获取无参数的方法
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classArgs);
        }
        System.out.println("class: "+clazz + " method" + methodName);
        System.out.println("name: class: "+clazz.getName() + " method" + method.getName());
    }
    
    @After("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception {
        time = new Date().getTime() - visitTime.getTime();//获取访问时长
        
        
        //获取url
        if (clazz != null && method != null && clazz != LogAop.class) {
            //1. 获取类上的@RequestMapping("/orders)
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValue = classAnnotation.value();
                
                //2. 获取方法上的RequestMapping(xxx)
                RequestMapping methodAnnotation = (RequestMapping) method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                }
                
                
            }
            
            //获取访问的ip
            ip = request.getRemoteAddr();
            
            //获取当前操作的用户
            SecurityContext context = SecurityContextHolder.getContext();//从上下文中获取当前登录的用户
            User user = (User) context.getAuthentication().getPrincipal();
            username = user.getUsername();
            //也可以通过request.getSession获取
//        SecurityContext context1 = (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
            
            //将日志相关信息封装到SysLog对象
            SysLog sysLog = new SysLog();
            sysLog.setExecutionTime(time);
            sysLog.setIp(ip);
            sysLog.setMethod("[类名]" + clazz.getName() + "[方法名]" + method.getName());
            System.out.println(sysLog.getMethod());
            sysLog.setUrl(url);
            sysLog.setUsername(username);
            sysLog.setVisitTime(visitTime);
            //调用Service完成操作
            System.out.println("@After name: class: "+clazz.getName() + " method: " + method.getName());
            sysLogService.save(sysLog);
        }
        
        
    }
}

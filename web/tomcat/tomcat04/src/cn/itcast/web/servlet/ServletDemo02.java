package cn.itcast.web.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo02 implements Servlet {
    /*
    * 初始化方法
    * 在Servlet被创建时执行, 只执行一次
    * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init......");
    }
    
    /*
    *获取ServletConfig对象 (Servlet的配置对象)
    * 了解
    * */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    
    /*
    * 提供服务的方法
    * 每一次Servlet被访问时执行. 执行多次
    * */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException,
            IOException {
        System.out.println("service......");
    }
    
    /*
    * 获取Servlet的一些信息(版本, 作者等)
    * 一般不会实现, 了解
    * */
    @Override
    public String getServletInfo() {
        return null;
    }
    /*
    * 销毁方法
    * 在服务器正常关闭时执行
    * */
    @Override
    public void destroy() {
        System.out.println("destroy......");
    }
}

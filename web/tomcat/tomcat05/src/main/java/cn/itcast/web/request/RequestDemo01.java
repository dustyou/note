package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestdemo01")
public class RequestDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
* 1. 方法: 获取请求方式:    GET
String getMethod()
2. 获取虚拟目录:        /tomcat05    (重要)
    getContextPath()
3. 获取Servlet路径:        /demo01
    String getServletPath()
4. 获取get方式请求参数:        name=zhangsan
    String getQueryString()
5. 获取请求URI:        /tomcat05/demo01    (重要)
    String getRequestURI():        返回/tomcat/demo01
    StringBuffer getRequestURL():           返回http://localhost/tomcat03/demo01
6. 获取协议及版本:        HTTP/1.1
    String getProtocol()
7. 获取客户机的IP地址:
    String getRemoteAddr()
重要方法: getContextPath(), getURI()
        * */
        String method = req.getMethod();
        System.out.println(method);
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        String queryString = req.getQueryString();
        System.out.println(queryString);
        StringBuffer url = req.getRequestURL();
        String uri = req.getRequestURI();
        System.out.println(url);
        System.out.println(uri);
        String protocol = req.getProtocol();
        System.out.println(protocol);
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);
    
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    
    
    }
}

package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")//访问所有资源之前都会执行该过滤器
public class FilterDemo01 implements Filter {
    public void destroy() {
        System.out.println("destroy in filter demo01");
    }
    
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo01被执行了......");
        chain.doFilter(req, resp);//放行
    }
    
    public void init(FilterConfig config) throws ServletException {
    
    }
    
}

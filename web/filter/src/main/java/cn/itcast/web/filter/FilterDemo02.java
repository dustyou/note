package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/filterDemo02")
public class FilterDemo02 implements Filter {
    public void destroy() {
    }
    
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter demo02 被执行了......");
        chain.doFilter(req, resp);
        System.out.println("filter demo02 回来了");
    }
    
    public void init(FilterConfig config) throws ServletException {
    
    }
    
}

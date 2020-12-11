package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }
    
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("loginFilter 被执行了......");
        //强制转换, 这样才有相关方法, getURI/getURL
        HttpServletRequest request = (HttpServletRequest) req;
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/login.jsp")||requestURI.contains("/loginServlet") || requestURI.contains("/checkCodeServlet") ) {
            //包含, 用户就是想登录
            chain.doFilter(req, resp);
        } else {
            //不包含, 需要验证用户是否登录
            //3. 从session中获取user
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                //登录了, 放行
                chain.doFilter(req, resp);
            } else {
                //没有登录, 跳转页面
                request.setAttribute("login_msg", "您尚未登录, 请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }
        
    }
    
    public void init(FilterConfig config) throws ServletException {
    
    }
    
}

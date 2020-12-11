package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestdemo07")
public class RequestDemo07 extends HttpServlet {
    
    boolean flag = true;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
        
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post 获取请求参数
    
        System.out.println("--------");
        System.out.println("--------");
        //根据请求参数名称获取参数值
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
//        System.out.println("post");
        System.out.println(username);
    
    }
    

}

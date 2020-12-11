package cn.itcast.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* Cookie快速入门
*
* */
@WebServlet("/cookieDemo04")
public class CookieDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 创建Cookie对象
        Cookie c1 = new Cookie("msg1", "setMaxAge");
        //设置cookie的存活时间
//        c1.setMaxAge(1);//将cookie持久化到硬盘, 30秒后会删除cookie文件
        //2. 发送Cookie
        response.addCookie(c1);
    
        //1. 创建Cookie对象
        Cookie c2 = new Cookie("msg2", "你好");
        
        c2.setPath("/");
        //2. 发送Cookie
        response.addCookie(c2);
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestdemo08")
public class RequestDemo08 extends HttpServlet {
    
    boolean flag = true;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("requestdemo08......");
        
        //
        
        //转发到demo09资源
        
        //存储数据到request域中
        req.setAttribute("msg", "hello");
        req.getRequestDispatcher("/requestdemo09").forward(req, resp);
    
    }
}

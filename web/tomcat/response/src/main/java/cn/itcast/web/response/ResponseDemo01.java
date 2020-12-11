package cn.itcast.web.response;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo01......");
//        //访问/responseDemo01, 会自动调转到/responseDemo02
//        //1. 设置状态码为302
//        resp.setStatus(302);
//
//        //2. 设置响应头location
//        resp.setHeader("location", "/response/responseDemo02");
        
        //简单的重定向方法
        //resp.sendRedirect("/response/responseDemo02");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        this.doPost(req, resp);
    }
}

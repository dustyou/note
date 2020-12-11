package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo05")
public class ServletContextDemo05 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletContext对象获取
        ServletContext context = this.getServletContext();
        //获取文件的真实路径
        String realPath = context.getRealPath("/b.txt");//webapp目录下资源访问
        System.out.println(realPath);
        String realPath2 = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
        System.out.println(realPath2);
        String realPath3 = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
        System.out.println(realPath3);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
        
    }
}

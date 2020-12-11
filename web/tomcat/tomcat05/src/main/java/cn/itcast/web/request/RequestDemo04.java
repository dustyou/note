package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestdemo04")
public class RequestDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String referer = req.getHeader("referer");
        System.out.println(referer);
        if (null != referer) {
            if (referer.contains("tomcat05")) {
                //正常跳转
                System.out.println("播放视频");
                resp.getWriter().write("播放高清视频");
            } else {
                //盗链
                System.out.println("想看吗, 来优酷首页吧");
                resp.getWriter().write("想看吗, 来优酷首页吧");
            }
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    
    }
}

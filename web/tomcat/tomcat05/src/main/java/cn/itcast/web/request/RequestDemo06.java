package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestdemo06")
public class RequestDemo06 extends HttpServlet {
    
    boolean flag = true;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get 获取请求参数
    
        //根据请求参数名称获取参数值
        String username = req.getParameter("username");
//        System.out.println("get");
        System.out.println(username);
        this.doPost(req, resp);
    
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post 获取请求参数
        
        
        //根据请求参数名称获取参数值
        String username = req.getParameter("username");
//        System.out.println("post");
        System.out.println(username);
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby: hobbies
             ) {
//            System.out.println(hobby);
        
        }
        Enumeration<String> parameterNames = req.getParameterNames();
        System.out.println("--------start------");
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = req.getParameter(name);
            System.out.println(value);
            System.out.println("---------");
        }
        System.out.println("#################");
    
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keyset = parameterMap.keySet();
        for (String name: keyset
             ) {
            System.out.println(name);
            String[] values = parameterMap.get(name);
            for (String value: values
                 ) {
                System.out.println(value);
            }
            
        }
        System.out.println("--------");
    
    
    }
    

}

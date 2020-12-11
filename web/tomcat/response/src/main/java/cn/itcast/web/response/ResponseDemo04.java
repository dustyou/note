package cn.itcast.web.response;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo04")
public class ResponseDemo04 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取流对象之前, 设置流的默认编码 ISO-8859-1 -> GBK
//        resp.setCharacterEncoding("GBK");
        //2. 告诉浏览器, 服务器发送的消息体数据的编码, 建议浏览器使用该编码解码
        //下面这行代码同时会设置输出流的编码形式为utf-8, 所以不需要再写第一行代码
//        resp.setHeader("content-type", "text/html;charsert=utf-8");
        
        //简单的形式, 设置编码
        resp.setContentType("text/html;charset=utf-8");
        
        
//        1. 获取字符输出流
        PrintWriter writer = resp.getWriter();
        //2. 输出数据
        writer.write("<h1>hello response<h1>");
        writer.write("<h1>你好啊啊啊啊啊<h1>");
        //输出流不需要刷新, 会自动刷新
    
    
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        this.doPost(req, resp);
    }
}

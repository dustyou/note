package cn.itcast.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        
        //1. 创建对象, 在内存中存图片(验证码图片对象)
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2. 美化图片
        //2.1 填充背景色
        Graphics graphics = image.getGraphics();//画笔对象
        graphics.setColor(Color.PINK);//设置颜色
        graphics.fillRect(0, 0, width, height);//填充矩形
        //2.2 画边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, width-1, height-1);//画矩形边框
        //写验证码
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        str += str.toLowerCase();
        str += "0123456789";
        //生成随机角标
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <5 ; i++) {
            //获取字符
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            graphics.setColor(Color.BLUE);
            graphics.drawString(ch+"", width/5*i, height/2);
            sb.append(ch);
        }
        String checkCode_session = sb.toString();
        req.getSession().setAttribute("checkCode_session", checkCode_session);
        
    
        //2.4 画干扰线
        graphics.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            
            
            //随机生成坐标点
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            //画线
            graphics.drawLine(x1,x2,y1,y2);
        }
        
        
        
        //3. 将图片输出展示
        ImageIO.write(image, "jpg", resp.getOutputStream());
        
        
        
        
        resp.setContentType("text/html;utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("nihao图片");
    
    
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

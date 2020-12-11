package dtd.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/*
* jsoup快速入门
* */
public class JsoupDemo04 {
    public static void main(String[] args) throws IOException {
    
        String path;
        path = "src\\main\\java\\xml\\dtd\\jsoup\\student.xml";
    
        //2.2 解析xml文档, 加载文档进内存, 获取DOM树
        Document document = Jsoup.parse(new File(path), "utf-8");
        
        Elements elements = document.getElementsByTag("student");
        Element student = elements.get(0);
//        System.out.println(student);
        
        //获取student对象的属性值
//        String numer = student.attr("number");
//        System.out.println(numer);
        String html = student.html();
        System.out.println(html);
        
        
        
    }
}

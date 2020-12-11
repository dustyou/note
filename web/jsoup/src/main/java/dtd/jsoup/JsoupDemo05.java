package dtd.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/*
* 选择器查询
* */
public class JsoupDemo05 {
    public static void main(String[] args) throws IOException {
        //1. 获取student.xml的path
        String path;
        path = "src\\main\\java\\xml\\dtd\\jsoup\\student.xml";
    
        //2.2 解析xml文档, 加载文档进内存, 获取DOM树
        Document document = Jsoup.parse(new File(path), "utf-8");
        
        Elements elements = document.select("name");
//        System.out.println(elements);
        //查询id值为itcast的元素
        System.out.println("-----------");
        Elements elements1 =document.select("#itcast");
//        System.out.println(elements1);
    
        System.out.println("---------");
        //获取student标签并且number属性为s002的age子标签
        Elements elements2 = document.select("student[number='s002'] age");
        System.out.println(elements2);
        
        
        
    }
}

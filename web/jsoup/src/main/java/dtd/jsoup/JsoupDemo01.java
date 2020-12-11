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
public class JsoupDemo01 {
    public static void main(String[] args) throws IOException {
        //2. 获取document对象, 根据xml文档获取
        //2.1 获取student.xml的path
        String path;
        path = "src\\main\\java\\xml\\dtd\\jsoup\\student.xml";
        
        //2.2 解析xml文档, 加载文档进内存, 获取DOM树
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements elements;
        Element element;
        //3. 获取元素对象Element
        elements = document.getElementsByTag("name");
        element = elements.get(0);
        String name = element.text();
//        System.out.println(name);
        
        elements = document.getElementsByAttribute("id");
        element = elements.get(0);
        System.out.println(element);
        
        elements = document.getElementsByAttributeValue("number", "s001");
        element = elements.get(0);
        System.out.println(element);
    }
}

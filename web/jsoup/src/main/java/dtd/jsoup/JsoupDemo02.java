package dtd.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

/*
* jsoup快速入门
* */
public class JsoupDemo02 {
    public static void main(String[] args) throws IOException {
        //parse也可以传入URL得到Document对象
        URL url = new URL("https://www.w3cschool.cn/xml/xml-parser.html");//代表网络路径的一个资源
        Document document = Jsoup.parse(url, 1000);
        
        
        //3. 获取元素对象Element
        Elements elements = document.getElementsByTag("html");
        Element element = elements.get(0);
        String name = element.text();
        System.out.println(element);

    }
}

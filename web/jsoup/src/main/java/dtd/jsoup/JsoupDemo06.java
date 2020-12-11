package dtd.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/*
* 选择器查询
* */
public class JsoupDemo06 {
    public static void main(String[] args) throws IOException {
        //1. 获取student.xml的path
        String path;
        path = "src\\main\\java\\xml\\dtd\\jsoup\\student.xml";
    
        //2.2 解析xml文档, 加载文档进内存, 获取DOM树
        Document document = Jsoup.parse(new File(path), "utf-8");
        
        //根据document对象, 创建JXDocument对象
        
        
        
    }
}

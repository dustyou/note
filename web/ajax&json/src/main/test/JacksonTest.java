
import cn.itcast.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;


public class JacksonTest {
    @Test
    public void test1() throws IOException {
        //1. 创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthdate(new Date());
        
        //2. 创建Jacson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3. 转换
        /*
         * 转换方法:
         *   writeVlue(参数1, obj)
         *       参数1:
         *           File: 将obj对象转换为JSON字符串, 并保存到指定的文件中
         *           Writer: 将obj对象转换为JSON字符串, 并填充到字符输出流中
         *           OutputStream: 将obj对象转换为JSON字符串, 并填充到字节输出流中
         *   writeValueAsString(obj): 将对象转为json字符串
         * */
        
        String json = null;
        //将数据传入字符串, 打印输出
        json = mapper.writeValueAsString(p);
        System.out.println(json);
        
        //将数据写到a.txt文件中
        mapper.writeValue(new File("a.txt"), p);
        //将数据关联到Writer中
        mapper.writeValue(new FileWriter("b.txt"), p);
        
    }
    
    //JSON字符串转为Java对象
    @Test
    public void test2() throws IOException {
        //1. 初始化JSON字符串
        String json="{\"name\":\"张三\",\"age\":23,\"gender\":\"男\",\"birthdate\":\"2020-07-12\"}";
        //2. 创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //3. 转换为Java对象 Person
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }
}



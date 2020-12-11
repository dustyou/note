import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

//jedis
public class JedisTest {
    //快速入门
    @Test
    public void test1() {
        //1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379);//如果使用空参构造, 默认值"localhost", 6379
        //2. 操作
        jedis.set("username", "zhangsan");
        //3. 关闭连接
        jedis.close();
    }
    
    @Test
    public void test2() {
        //1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2. 操作
        //存储
        jedis.setex("activecode",10, "code");
        String username = jedis.get("username");
        System.out.println(username);
        //3. 关闭连接
        jedis.close();
    }
    
    @Test
    public void test3() {
        //1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2. 操作
        //存储
        jedis.hset("user","name", "lisi");
        jedis.hset("user","age", "23");
        jedis.hset("user","gender", "male");
        String name = jedis.hget("user", "name");
        System.out.println(name);
        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keyset = user.keySet();
        for (String key: keyset) {
            String value = user.get(key);
            System.out.println(String.format("%s: %s", key, value));
        }
        //3. 关闭连接
        jedis.close();
    }
    
    //list操作
    @Test
    public void test4() {
        //1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2. 操作
        //存储
        jedis.lpush("mylist", "a","b","c");//从左边存
        jedis.rpush("mylist", "a","b","c");//从右边存
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);
        String element1 = jedis.lpop("mylist");
        System.out.println(element1);
        //3. 关闭连接
        jedis.close();
    }
    
    //jedis连接池使用
    @Test
    public void test5() {
        //0. 创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(50);
        //设置最大空闲数
        config.setMaxIdle(10) ;
        //1. 创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost", 6379);
        //2. 获取连接
        Jedis jedis = jedisPool.getResource();
        //3. 使用
        jedis.set("name","hehe");
        String name = jedis.get("name");
        System.out.println(name);
        //4. 关闭, 归还到连接池中
        jedis.close();
    }
}

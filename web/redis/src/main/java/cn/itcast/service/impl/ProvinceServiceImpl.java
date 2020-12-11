package cn.itcast.service.impl;

import cn.itcast.dao.ProvinceDao;
import cn.itcast.dao.impl.ProvinceDaoImpl;
import cn.itcast.domain.Province;
import cn.itcast.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    
    //声明dao
    private ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        
        return dao.findAll();
    }
    
    //使用redis缓存
    @Override
    public String findAllJson() {
        //1. 先从redis中查询数据
        //1.1 获取redis客户端连接
        //0. 创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(50);
        //设置最大空闲数
        config.setMaxIdle(10);
        //1. 创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);
        //2. 获取连接
        Jedis jedis = jedisPool.getResource();
        //3. 使用
        String province_json = jedis.get("province");
        
        //2. 判断province_json是否为null
        if (province_json == null || province_json.length() == 0) {
            //redis中没有数据
            System.out.println("redis中没有数据, 查询数据库...");
            //2.1 从数据库中查询
            List<Province> ps = dao.findAll();
            //2.2 将list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                String s = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //2.3 将json数据存入redis
            jedis.set("province_jsonn", province_json);
            //归还连接
            jedis.close();
        } else {
            System.out.println("redis中有数据, 查询缓存...");
        }
        
        
        
        return province_json;
    
    }
}

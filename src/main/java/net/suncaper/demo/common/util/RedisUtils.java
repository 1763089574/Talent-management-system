package net.suncaper.demo.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/*
封装好的redis工具类一，使用springboot集成的StringRedisTemplate模板
key和value的序列化方式都为String
如果是<String,String>类型的数据使用这个工具类
如果是<String,Object>类型的数据使用另外一个工具类
 */
@Service
public class RedisUtils {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String get(String key){//传入key值，获取value值，value类型为String
        String result = null;
        try {
            result=stringRedisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            System.out.println("RedisUtil读取redis缓存失败！错误信息为：" + e.getMessage());        }
        return result;
    }

    public boolean set(String key, String value){//传入key,value值，set进redis数据库
        boolean result = false;
        try {
            stringRedisTemplate.opsForValue().set(key,value);
            result = true;
        } catch (Exception e) {
            System.out.println("RedisUtil写入redis缓存失败！错误信息为：" + e.getMessage());
        }
        return result;
    }







}

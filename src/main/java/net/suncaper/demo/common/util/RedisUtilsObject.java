package net.suncaper.demo.common.util;

import net.suncaper.demo.common.domain.Achievement;
import net.suncaper.demo.common.domain.Employ;
import net.suncaper.demo.common.domain.Mistake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.springframework.data.redis.core.RedisTemplate;

/*
封装好的redis工具类二，使用自己配置的redisTemplate模板
key的序列化方式都为String，value的序列化方式为json
如果是<String,Object>类型的数据使用这个工具类
如果是<String,String>类型的数据使用另外一个工具类
 */
@Service
public class RedisUtilsObject {
    @Autowired
    @Qualifier("redisTemplate")//因为springboot也提供了RedisTemplate模板，但是不好用，为防止歧义，使用此注解指定模板
    private RedisTemplate redisTemplate;


    public boolean set(String key, Object value){//设置key,value
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key,value);
            result = true;
        } catch (Exception e) {
            System.out.println("写入redis缓存失败！错误信息为：" + e.getMessage());
        }
        return result;
    }

    public Object get(String key){//传入key，得到一个对象value
        Object result = null;
        try {
            result=redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            System.out.println("读取redis缓存失败！错误信息为：" + e.getMessage());        }
        return result;
    }

    public boolean expire(String key,Object value,long time){//设置一对key,value，并指定过期时间
        boolean result = false;
        try {
            if(time>0){
                redisTemplate.opsForValue().set(key,value,time, TimeUnit.SECONDS);
                result = true;
            }
        } catch (Exception e) {
            System.out.println("写入redis缓存失败！错误信息为：" + e.getMessage());
        }
        return result;
    }

    public boolean hasKey(String key) {//输入key，判断当前key是否存在
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean lpush(String key, Object value){
        boolean result = false;
        try{
            redisTemplate.opsForList().leftPushAll(key,value);
            result=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public List<Employ> lrangeAllEmploy(String key){//根据key得到对应的list的所有内容
        return redisTemplate.opsForList().range(key,0,-1);

    }

    public List<Achievement> lrangeAllAchievement(String key){//根据key得到对应的list的所有内容
        return redisTemplate.opsForList().range(key,0,-1);

    }
    public List<Mistake> lrangeAllMistake(String key){//根据key得到对应的list的所有内容
        return redisTemplate.opsForList().range(key,0,-1);

    }










}

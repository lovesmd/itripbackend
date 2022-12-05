package cn.itrip.util;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * @author YiShi
 * @date 2022/11/8 16:13
 */
@Component
public class RedisHelp {

    public String getkey(String key){
        Jedis redis=new Jedis("192.168.122.136");
        redis.auth("123456");
        String obj=(String)redis.get(key);
        return obj;
    }
    public void setKet(String key,String value,int expireTime)
    {
        Jedis redis=new Jedis("192.168.122.136");
        redis.auth("123456");
        redis.setex(key,expireTime,value);
    }
}

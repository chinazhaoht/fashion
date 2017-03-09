package com.xiaoneng.fashion;

import com.fashion.config.JedisPoolManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoht
 * @date 2017/2/13 11:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:fashion-context.xml", "classpath:fashion-security.xml"})
public class RedisTest {

    Jedis jedis = null;

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;
    @Test
    public void test() {
        try {
            jedis = JedisPoolManager.getMgr().getResource();
            jedis.set("nihao", "hello");
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Test
    public void hashMapTest() {
        Map map = new HashMap();

        for(int i = 1;i<=20;i++){
            map.put(i+"",i);
        }

        System.out.println(map.size());
        System.out.println(map.values());
        System.out.println(map.entrySet().size());
        map.entrySet().stream().forEach(x->{
           System.out.print(x);
        });
        System.out.println(map.entrySet());
    }


    @Test
    public void redisTest(){
        Jedis jedis1 = jedisConnectionFactory.getConnection().getNativeConnection();
        jedis1.set("hello","hello");
    }
}

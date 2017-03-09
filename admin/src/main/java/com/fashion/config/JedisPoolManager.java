package com.fashion.config;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.Properties;

/**
 * @author zhaoht
 * @date 2017/2/13 11:11
 */
@Component
public class JedisPoolManager {

    private volatile static JedisPoolManager manager;
    private final JedisPool pool;

    private JedisPoolManager(){
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(4);
            config.setMaxIdle(4);
            config.setMinIdle(1);
            config.setMaxWaitMillis(40000);
            config.setTestOnBorrow(true);
            config.setTestOnReturn(true);
            pool = new JedisPool(config, "192.168.30.230", 6378);
    }

    public static JedisPoolManager getMgr(){
        if(manager == null){
            synchronized (JedisPoolManager.class){
                if(manager == null){
                    manager = new JedisPoolManager();
                }
            }
        }
        return manager;
    }

    public Jedis getResource(){
        return pool.getResource();
    }

    public void close(){
        pool.close();
    }

}

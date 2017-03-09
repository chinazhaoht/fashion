package com.fashion;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaoht
 * @date 2017/2/13 17:58
 */
public class RedisSentinelClient {

    public static void main(String[] args) {
        Set sentinels = new HashSet();
        sentinels.add(new HostAndPort("192.168.30.230",26379).toString());
        JedisSentinelPool sentinelPool = new JedisSentinelPool("mymaster",sentinels);
        System.out.println("Current master:"+sentinelPool.getCurrentHostMaster().toString());
        Jedis master = sentinelPool.getResource();
        master.set("username","zhaohongtao");
        System.out.println(master.get("username"));
        sentinelPool.destroy();
    }
}

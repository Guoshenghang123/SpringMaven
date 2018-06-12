package com.guosh.redis.impl;

import com.guosh.redis.AbstractClient;
import com.guosh.redis.RedisCluster;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * Created by guosh on 2018/6/7.
 */
public class RedisClusterImpl  extends AbstractClient implements RedisCluster {
    private static final org.slf4j.Logger Logger = LoggerFactory
            .getLogger(RedisClusterImpl.class);
    private Jedis jedis;
    public RedisClusterImpl(String host, int port) {
       super(host,port);
    }

    public boolean set(String key, String value) {
        jedis = getJedisFromPool();
        jedis.set(key, value);
        close(jedis);
        return true;
    }

    private Jedis getJedisFromPool() {
        JedisPool pool = getJedisPool();
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
        } catch (JedisConnectionException e) {
            if (null != jedis)
                Logger.error(e.getMessage(),e);
        }
        return jedis;
    }

    ;

    public void close(Jedis jedis) {
        jedis.quit();
        jedis.disconnect();
    }

}

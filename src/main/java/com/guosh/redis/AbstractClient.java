package com.guosh.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by guosh on 2018/6/7.
 */
public abstract class AbstractClient {
    private String host;
    private int port;
    private JedisPool jedisPool;

    protected AbstractClient(String host, int port) {
        this.host = host;
        this.port = port;
        initJedisPool();
    }

    public JedisPool getJedisPool() {
        return this.jedisPool;
    }

    private void initJedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(10);
        config.setMaxTotal(10);
        config.setMaxWaitMillis(60000);
        this.jedisPool = new JedisPool(config, this.host, this.port,60000);
    }
}

package com.guosh.controller;

import com.guosh.dao.CommonDao;
import com.guosh.kafaka.KafkaConsumerDemo;
import com.guosh.kafaka.KafkaProducerDemo;
import com.guosh.redis.RedisCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.JedisCluster;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by guosh on 2018/6/7.
 */
@Controller
public class HelloController {
    @Autowired
    private RedisCluster redisCluster;
    @Autowired
    private JedisCluster jedisCluster;

    @Autowired
    private CommonDao commonDao;
    @Autowired
    private KafkaProducerDemo producer;
    @Autowired
    KafkaConsumerDemo kafkaConsumerDemo;
    @Autowired
    private KafkaConsumerDemo consumer;
    @RequestMapping("/helloWorld")
    public String helloWorld(Model model) {
        if (jedisCluster.set("guosh", "sucess") == "1") {
            model.addAttribute("info", "success");
        } else {
            model.addAttribute("info", "fail");
        };
        Map<String, Object> a=new HashMap<>();
        try{
            producer.sendMessage("123");
            kafkaConsumerDemo.receive();
            commonDao.T_SYS_STAFF(a);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return "hello.ftl";
    }
}

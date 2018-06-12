package com.guosh.kafaka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

/**
 * Created by guosh on 2018/6/12.
 */
public class KafakaConsumer  implements MessageListener<Integer, String> {
    private static final Logger logger= LoggerFactory.getLogger(KafakaConsumer.class);
    @Override
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) {
        Object o = consumerRecord.value();
        System.out.println(String.valueOf(o));
        logger.info(o.toString());
    }
}

package com.guosh.kafaka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created by guosh on 2018/6/8.
 */
public class KafkaProducerDemo {
    Properties properties;

    public KafkaProducerDemo(Properties properties) {
        super();
        this.properties = properties;
    }

    public KafkaProducerDemo() {
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void sendMessage(String msg) {

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        ProducerRecord<String, String> record = new ProducerRecord<String, String>(properties.getProperty("topic"),
                msg);
        producer.send(record);
        producer.flush();
        producer.close();


    }

}

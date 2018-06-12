package com.guosh.kafaka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by guosh on 2018/6/8.
 */
public class KafkaConsumerDemo {
    private Properties props;

    public KafkaConsumerDemo(Properties props) {
        super();
        this.props = props;
    }

    public KafkaConsumerDemo() {
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public String receive() {

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(props.getProperty("topic")));

        String msg = "";
        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                msg += consumerRecord.value();
            }
            consumer.close();
            return msg;
        }

    }
}

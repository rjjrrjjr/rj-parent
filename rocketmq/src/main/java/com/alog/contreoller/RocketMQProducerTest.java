package com.alog.contreoller;

import com.alibaba.rocketmq.common.message.Message;

/**
 * Created by 10064028 on 2018/1/4.
 */
public class RocketMQProducerTest {
    public static void main(String[] args) {
        String mqNameServer = "192.168.49.130:9876";
        String mqTopics = "MQ_MSG_TOPICS_TEST";

        String producerGroupName = "PRODUCER_MQ_GROUP";
        RocketMQProducer mqProducer = new RocketMQProducer(mqNameServer, producerGroupName, mqTopics);
        mqProducer.init();

        for (int i = 0; i < 5; i++){
            Message message = new Message();
            message.setBody(("i am message to rocketMQ " + i).getBytes());
            mqProducer.send(message);
        }

    }
}

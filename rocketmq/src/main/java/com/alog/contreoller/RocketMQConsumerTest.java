package com.alog.contreoller;

/**
 * Created by 10064028 on 2018/1/4.
 */
public class RocketMQConsumerTest {

    public static void main(String[] args) {
        String mqNameServer = "192.168.49.130:9876";
        String mqTopics = "MQ_MSG_TOPICS_TEST";

        String consumerMqGroupName = "CONSUMER_MQ_GROUP";
        RocketMQListener mqListener = new RocketMQListener();
        RocketMQConsumer mqConsumer = new RocketMQConsumer(mqListener, mqNameServer, consumerMqGroupName, mqTopics);
        mqConsumer.init();

        try {
            Thread.sleep(1000 * 60L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

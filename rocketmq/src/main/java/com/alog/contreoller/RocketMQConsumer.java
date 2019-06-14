package com.alog.contreoller;

import java.util.UUID;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.MessageListener;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;

/**
 * Created by 10064028 on 2018/1/4.
 */
public class RocketMQConsumer {

    private DefaultMQPushConsumer consumer;

    private MessageListener listener;

    private String nameServer;

    private String groupName;

    private String topics;

    public RocketMQConsumer(MessageListener listener, String nameServer, String groupName, String topics) {
        this.listener = listener;
        this.nameServer = nameServer;
        this.groupName = groupName;
        this.topics = topics;
    }

    public void init() {
        consumer = new DefaultMQPushConsumer(groupName);
        try {
            consumer.subscribe(topics, "*");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        consumer.setNamesrvAddr(this.nameServer);
        consumer.setInstanceName(UUID.randomUUID().toString());
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.registerMessageListener((MessageListenerConcurrently) this.listener);

        try {
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        System.out.println("RocketMQConsumer Start! group= " +consumer.getConsumerGroup() + " instance = " + consumer.getInstanceName());
    }
}

package com.alog.contreoller;

import java.util.UUID;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.SendStatus;
import com.alibaba.rocketmq.common.message.Message;

/**
 * Created by 10064028 on 2018/1/4.
 */
public class RocketMQProducer {

    private DefaultMQProducer producer;

    private String nameServer;

    private String groupName;

    private String topics;

    public RocketMQProducer(String nameServer, String groupName, String topics) {
        this.nameServer = nameServer;
        this.groupName = groupName;
        this.topics = topics;
    }

    public void init(){
        producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr(nameServer);
        producer.setInstanceName(UUID.randomUUID().toString());
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public void send(Message message){
        message.setTopic(this.topics);

        try {
            SendResult result = producer.send(message);
            SendStatus status = result.getSendStatus();
            System.out.println("messageId= " + result.getMsgId() + ", status= " + status);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

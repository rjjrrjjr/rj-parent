package com.alog.contreoller;

import java.util.List;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * Created by 10064028 on 2018/1/4.
 */
public class RocketMQListener implements MessageListenerConcurrently{


    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        System.out.println("get data from rocketMQ: " + list);
        for (MessageExt me : list){
            String msg = new String(me.getBody());
            System.out.println("msg data from rocket :" + msg);
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}

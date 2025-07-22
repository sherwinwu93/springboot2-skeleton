package com.wusd.skeleton.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author Wusd
 * @date 2025/7/17
 * @description
 */
@Component
@RocketMQMessageListener(topic = "string", consumerGroup = "testGroup250717")
@Slf4j
public class MyListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        log.info("MyListener.onMessage...topic->string,s->{}", s);
    }
}

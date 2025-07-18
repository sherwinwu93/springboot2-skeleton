package com.wusd.skeleton.controller.test;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wusd
 * @date 2025/7/17
 * @description
 */
@RestController
@RequestMapping("/mq")
public class MqController {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    private String topic = "string";

    @GetMapping("/send")
    public void send() {
        Message<String> message = MessageBuilder.withPayload("hello, RocketMQ").build();
        rocketMQTemplate.send(topic, message);
    }
}

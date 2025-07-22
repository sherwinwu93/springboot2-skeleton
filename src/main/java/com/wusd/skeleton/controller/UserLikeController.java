//package com.wusd.skeleton.controller.test;
//
//import com.wusd.skeleton.constant.RocketConstant;
//import com.wusd.skeleton.entity.po.UserLike;
//import com.wusd.skeleton.service.UserLikeService;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author Wusd
// * @date 2025/7/21
// * @description
// */
//@RestController
//@RequestMapping("/userLike")
//public class UserLikeController {
//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;
//
//    @GetMapping("/{userId}")
//    public Boolean like(@PathVariable("userId") Long userId) {
//        // syncSend() 同步发送
//        // asyncSend() 异步发送
//        // sendOneWay() 单向发送, 也是异步发送,不等待Broker返回确认,性能更高
//        rocketMQTemplate.sendOneWay(RocketConstant.Topic.USER_LIKE, MessageBuilder.withPayload(userId).build());
//        return true;
//    }
//}

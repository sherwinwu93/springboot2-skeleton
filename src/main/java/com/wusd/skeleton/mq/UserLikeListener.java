//package com.wusd.skeleton.mq;
//
//import com.wusd.skeleton.constant.RocketConstant;
//import com.wusd.skeleton.entity.po.UserLike;
//import com.wusd.skeleton.service.UserLikeService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * @author Wusd
// * @date 2025/7/21
// * @description
// */
//@Component
//@RocketMQMessageListener(topic = RocketConstant.Topic.USER_LIKE, consumerGroup = "testGroup250717")
//@Slf4j
//public class UserLikeListener implements RocketMQListener<Long>/*, RocketMQPushConsumerLifecycleListener*/ {
//    @Autowired
//    private UserLikeService service;
//
//    @Override
//    public void onMessage(Long userId) {
//        log.info("UserLikeListener.onMessage...userId->{}", userId);
//        UserLike userLike = new UserLike();
//        userLike.setUserId(userId);
//        service.save(userLike);
//    }
//
////    @Override
////    public void prepareStart(DefaultMQPushConsumer consumer) {
////        // 每次拉取的间隔,单位为毫秒
////        consumer.setPullInterval(1000);
////        // 设置每次从队列拉取的消息数为16
////        consumer.setPullBatchSize(64);
////    }
//}

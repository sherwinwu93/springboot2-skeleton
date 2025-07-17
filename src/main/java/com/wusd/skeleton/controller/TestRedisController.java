package com.wusd.skeleton.controller;

import com.wusd.skeleton.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Wusd
 * @date 2025/7/14
 * @description
 */
@RestController
@RequestMapping("/test/redis")
@Slf4j
public class TestRedisController {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/hello")
    public String hello() {
        redisTemplate.opsForValue().set("hello333", "world");
        return (String) redisTemplate.opsForValue().get("hello");
    }

    @GetMapping("/obj")
    public Student obj() {
        Student student = new Student();
        student.setStudentId(1L);
        student.setStudentName("wusd");
        redisTemplate.opsForValue().set("obj", student);
        return (Student) redisTemplate.opsForValue().get("obj");
    }

    @GetMapping("/keys")
    public String keys() {
        Set<String> keys = redisTemplate.keys("*");
        return keys.stream().collect(Collectors.joining(","));
    }

    @GetMapping("/isUpdatingExpiredTimeAfterGetting")
    public void isUpdatingExpiredTimeAfterGetting() {
        String key = "isUpdatingExpiredTimeAfterGetting";

        redisTemplate.opsForValue().set(key, "", 30, TimeUnit.SECONDS);
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("=========================================time before getting->{}", redisTemplate.getExpire(key, TimeUnit.SECONDS));       ;
        Object o = redisTemplate.opsForValue().get(key);
        log.info("=========================================time after getting->{}", redisTemplate.getExpire(key, TimeUnit.SECONDS));       ;
    }
}

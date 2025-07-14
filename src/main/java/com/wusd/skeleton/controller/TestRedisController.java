package com.wusd.skeleton.controller;

import com.wusd.skeleton.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Wusd
 * @date 2025/7/14
 * @description
 */
@RestController
@RequestMapping("/test/redis")
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
        student.setId(1L);
        student.setStudentName("wusd");
        redisTemplate.opsForValue().set("obj", student);
        return (Student) redisTemplate.opsForValue().get("obj");
    }

    @GetMapping("/keys")
    public String keys() {
        Set<String> keys = redisTemplate.keys("*");
        return keys.stream().collect(Collectors.joining(","));
    }
}

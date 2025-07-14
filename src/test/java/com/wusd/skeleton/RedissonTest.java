package com.wusd.skeleton;

import com.alibaba.fastjson.JSON;
import com.wusd.skeleton.entity.Student;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @author Wusd
 * @date 2025/7/14
 * @description
 */
public class RedissonTest {
    public static RedissonClient redissonClient = null;

    public static void main(String[] args) {
        initRedissonClient();
//        keys();
//        strings();
//        obj();
//        rhash();
//        rList();
//        rSet();
        rSortSet();
        shutdown();
    }

    private static void rSortSet() {
        RSortedSet<Student> rSortedSet = redissonClient.getSortedSet("sortSetKey");
        Student st1 = new Student();
        st1.setId(2L);
        st1.setStudentName("张三");
        Student st2 = new Student();
        st2.setId(1L);
        st2.setStudentName("李四");
        rSortedSet.add(st1);
        rSortedSet.add(st2);
        System.out.println("rSortSet.get()->" + JSON.toJSONString(redissonClient.getSortedSet("sortSetKey")));
    }

    private static void rSet() {
        RSet<Student> rSet = redissonClient.getSet("setKey");
        rSet.add(new Student() {{
            setId(1L);
            setStudentName("张三");
        }});
        rSet.add(new Student() {{
            setId(2L);
            setStudentName("李四");
        }});
        System.out.println("rSet.get()->" + JSON.toJSONString(redissonClient.getSet("setKey")));
    }

    private static void rList() {
        RList<Student> rList = redissonClient.getList("listKey");
        rList.add(new Student() {{
            setId(1L);
            setStudentName("张三");
        }});
        rList.add(new Student() {{
            setId(2L);
            setStudentName("李四");
        }});
        System.out.println("rList.get()->" + JSON.toJSONString(redissonClient.getList("listKey")));
    }


    private static void rhash() {
        RMap<String, String> rMap = redissonClient.getMap("mapKey");
        rMap.put("name", "张三");
        rMap.put("age", "18");
        System.out.println("rMap.get()->" + JSON.toJSONString(redissonClient.getMap("mapKey")));
    }

    private static void obj() {
        Student student = new Student() {{
            setId(1L);
            setStudentName("wusd");
        }};
        RBucket<Student> rBucket = redissonClient.getBucket("objKey");
        rBucket.set(student, 30, TimeUnit.SECONDS);
        System.out.println("rBucket.get()->" + JSON.toJSONString(redissonClient.getBucket("objKey").get()));
    }

    private static void strings() {
        RBucket<String> rBucket = redissonClient.getBucket("strKey");
        rBucket.set("张三", 30, TimeUnit.SECONDS);
        System.out.println("rBucket.get()->" + redissonClient.getBucket("strKey").get());
    }

    private static void keys() {
        redissonClient.getKeys().getKeys().forEach(key -> {
            System.out.println("getKeys.key->" + key);
        });
    }

    public static void initRedissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
        redissonClient = Redisson.create(config);
    }

    public static void shutdown() {
        redissonClient.shutdown();
    }
}

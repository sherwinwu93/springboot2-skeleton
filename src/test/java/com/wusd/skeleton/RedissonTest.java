package com.wusd.skeleton;

import com.alibaba.fastjson.JSON;
import com.wusd.skeleton.entity.Student;
import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.*;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Wusd
 * @date 2025/7/14
 * @description
 */
public class RedissonTest {
    public static RedissonClient redissonClient = null;

    public static void main(String[] args) throws Exception {
//        initRedissonClient();
//        keys();
//        strings();
//        obj();
//        rhash();
//        rList();
//        rSet();
//        rSortSet();
//        bloomFilter();
//        atomicIncrement();
        List<Integer> flags = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
//        flags.parallelStream().forEach(flag -> {
//            distributedLock(flag);
//        });
        flags.parallelStream().forEach(flag -> {
            redLock(flag);
        });
//        shutdown();
    }

    private static void masterSlave() {
        Config config = new Config();
        config.useMasterSlaveServers()
                .setMasterAddress("redis://127.0.0.1:6379")
                .addSlaveAddress("redis://127.0.0.1:6380", "redis://127.0.0.1:6381");
        RedissonClient redissonClient1 = Redisson.create(config);
    }

    /**
     * 哨兵模式
     */
    private static void sentinel() {
        Config config = new Config();
        config.useSentinelServers()
                .setMasterName("mymaster")
                .addSentinelAddress("redis://127.0.0.1:26379", "redis://127.0.0.1:26380", "redis://127.0.0.1:26381");
        RedissonClient redissonClient1 = Redisson.create(config);
    }

    /**
     * 集群模式
     */
    private static void  clusters() {
        Config config = new Config();
        config.useClusterServers()
                .setScanInterval(2000)
                .addNodeAddress("redis://127.0.0.1:7000", "redis://127.0.0.1:7001", "redis://127.0.0.1:7002", "redis://127.0.0.1:7003", "redis://127.0.0.1:7004", "redis://127.0.0.1:7005");
        RedissonClient redissonClient1 = Redisson.create(config);
    }

    /**
     * 红锁的实现原理:
     *  1. 如果多个redis集群,当多数(超过一半)的节点都取到锁,且获取锁的时间小于锁失效时间,则锁获取成功
     *  2. 如果获取失败,客户端会解锁所有redis节点
     *  3. 集群下,redis不存在任何复制或分布式协调机制,否则会存在失效
     */
    private static void redLock(int flag) {
        Config config1 = new Config();
        config1.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
        config1.setCodec(new JsonJacksonCodec());
        RedissonClient redissonClient1 = Redisson.create(config1);

        Config config2 = new Config();
        config2.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(1);
        config2.setCodec(new JsonJacksonCodec());
        RedissonClient redissonClient2 = Redisson.create(config2);

        Config config3 = new Config();
        config3.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(2);
        config3.setCodec(new JsonJacksonCodec());
        RedissonClient redissonClient3 = Redisson.create(config3);

        final String lockKey = "abc";
        RLock rLock1 = redissonClient1.getLock(lockKey);
        RLock rLock2 = redissonClient2.getLock(lockKey);
        RLock rLock3 = redissonClient3.getLock(lockKey);

        RedissonRedLock redLock = new RedissonRedLock(rLock1, rLock2, rLock3);
        try {
            boolean res = redLock.tryLock(5, 60, TimeUnit.SECONDS);
            if (res) {
                System.out.println("获得锁成功.flag:"+flag);
            }
        } catch (Exception e) {
            System.out.println("获取锁失败,失败原因:" + e.getMessage() + ".flag:" + flag);
        } finally {
            if (redLock.isLocked() && redLock.isHeldByCurrentThread()) redLock.unlock();
        }
    }

    private static void distributedLock(Integer flag) {
        final String lockKey = "abc";
        RLock rLock = redissonClient.getLock(lockKey);
        try {
            // 尝试5秒内获取锁,如果获取到了,最长60秒自动释放
            boolean res = rLock.tryLock(5, 60, TimeUnit.SECONDS);
            if (res) {
                // 成功获得锁,在这里处理业务
                System.out.println("获取锁成功.flag:" + flag);
            }
        } catch (Exception e) {
            System.out.println("获取锁失败,失败原因:" + e.getMessage() + ".flag:" + flag);
        } finally {
            // 无论如何,最后释放锁
            if (rLock.isLocked() && rLock.isHeldByCurrentThread()) rLock.unlock();
        }
    }

    /**
     * 分布式自增ID
     */
    private static void atomicIncrement() throws Exception {
        final String lockKey = "aaaa";
        RAtomicLong atomicLong = redissonClient.getAtomicLong(lockKey);
        atomicLong.expire(30, TimeUnit.SECONDS);
        long expiredTime = System.currentTimeMillis() + 10000;
        while (System.currentTimeMillis() < expiredTime) {
            System.out.println(atomicLong.incrementAndGet());
            Thread.sleep(1000);
        }
    }

    /**
     * 把数据库的所有key放入过滤器里,快速判断某个数据是否在数据库中,避免缓存穿透
     */
    private static void bloomFilter() {
        /**
         * 显示在,不一定在.显示不在,一定不在
         */
        RBloomFilter rBloomFilter = redissonClient.getBloomFilter("seqId");
        // 预期插入数据量为1000000和期望误差率为0.01
        rBloomFilter.tryInit(1000000, 0.01);
        rBloomFilter.add("100");
        rBloomFilter.add("200");
        rBloomFilter.add("300");
        // 设置过期时间
        rBloomFilter.expire(30, TimeUnit.SECONDS);
        // 判断是否存在
        System.out.println(rBloomFilter.contains("300"));
        System.out.println(rBloomFilter.contains("200"));
        System.out.println(rBloomFilter.contains("100"));
    }

    private static void rSortSet() {
        RSortedSet<Student> rSortedSet = redissonClient.getSortedSet("sortSetKey");
        Student st1 = new Student();
        st1.setStudentId(2L);
        st1.setStudentName("张三");
        Student st2 = new Student();
        st2.setStudentId(1L);
        st2.setStudentName("李四");
        rSortedSet.add(st1);
        rSortedSet.add(st2);
        System.out.println("rSortSet.get()->" + JSON.toJSONString(redissonClient.getSortedSet("sortSetKey")));
    }

    private static void rSet() {
        RSet<Student> rSet = redissonClient.getSet("setKey");
        rSet.add(new Student() {{
            setStudentId(1L);
            setStudentName("张三");
        }});
        rSet.add(new Student() {{
            setStudentId(2L);
            setStudentName("李四");
        }});
        System.out.println("rSet.get()->" + JSON.toJSONString(redissonClient.getSet("setKey")));
    }

    private static void rList() {
        RList<Student> rList = redissonClient.getList("listKey");
        rList.add(new Student() {{
            setStudentId(1L);
            setStudentName("张三");
        }});
        rList.add(new Student() {{
            setStudentId(2L);
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
            setStudentId(1L);
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
        config.setCodec(new JsonJacksonCodec());
        redissonClient = Redisson.create(config);
    }

    public static void shutdown() {
        redissonClient.shutdown();
    }
}

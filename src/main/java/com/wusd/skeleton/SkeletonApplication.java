package com.wusd.skeleton;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wusd.skeleton.mapper")
public class SkeletonApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkeletonApplication.class, args);
    }

}

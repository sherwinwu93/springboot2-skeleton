package com.wusd.skeleton;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class SkeletonApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkeletonApplication.class, args);
    }
}

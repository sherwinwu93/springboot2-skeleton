package com.wusd.skeleton.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Wusd
 * @date 2025/7/17
 * @description
 */
public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. 创建个异步任务,返回个字符串
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);// 模拟耗时操作
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "hello, completableFuture";
        });

        // 2. 执行其他操作,不阻塞主线程
        System.out.println("do something else...");
        // 3. 获取异步任务的结果, get()会阻塞到任务完成
        String result = future.get();
        System.out.println("Result:" + result);
    }
}

package com.wusd.skeleton.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Wusd
 * @date 2025/7/17
 * @description
 */
public class CompletableFutureExample3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. 两个异步任务
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Res") ;
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 42);

        // 2. 组合结果
        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (result1, result2) -> result1 + "," + result2);

        String combinedResult = combinedFuture.get();
        System.out.println("Combined Result: " + combinedResult);
    }
}

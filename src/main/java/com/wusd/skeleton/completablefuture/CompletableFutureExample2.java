package com.wusd.skeleton.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Wusd
 * @date 2025/7/17
 * @description
 */
public class CompletableFutureExample2 {
    public static void main(String[] args) {
        // 1. 异步任务,可能有异常
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (Math.random() < 1.5) {
                throw new RuntimeException("something went wrong!");
            }
            return "Task completed successfully!";
        });

        // 2. 处理正常
        future.thenAccept(result -> System.out.println("Result: " + result));

        // 3. 处理异常
        future.exceptionally(ex -> {
            System.out.println("Error: " + ex.getMessage());
            return "产生错误了";
        });

        // 4. 获取最终结果, 可以捕获get()的异常,也可以join()
        try {
            String finalResult = future.get();
            System.out.println("finalResult: " + finalResult);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.err.println("Execution Exception: " + e.getCause().getMessage());
        }
        // 或者使用join(), 会抛出异常
//        String finalResult = future.join();
//        System.out.println("finalResult: " + finalResult);
    }
}

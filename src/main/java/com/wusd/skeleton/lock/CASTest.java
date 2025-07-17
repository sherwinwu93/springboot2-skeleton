package com.wusd.skeleton.lock;

/**
 * @author Wusd
 * @date 2025/7/17
 * @description
 */
public class CASTest {
    public static void main(String[] args) {
    }

    private static void change() {
        // 共享数据
        Integer data = 123;

        // 更新数据的线程会进行如下操作
        boolean flag = true;
        while (flag) {
            Integer oldValue = data; // 保存原始数据
            Integer newValue = doSomething(oldValue);

            if (data == oldValue) {// 比较
                data = newValue;// 设置
                flag = false;// 结束
            } else {
                // 啥也不干,循环重试
            }
        }
        /**
         * 这里是非原子的,解释原理.实际是CPU指令
         */
    }

    private static Integer doSomething(Integer oldValue) {
        return null;
    }
}

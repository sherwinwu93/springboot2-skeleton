package com.wusd.skeleton.designpattern.adapter;

/**
 * 目标接口
 * @author wusd
 * @date 2020/1/12 19:57
 */
public interface ScoreOperation {
    int[] sort(int[] array);
    int search(int[] array, int key);
}

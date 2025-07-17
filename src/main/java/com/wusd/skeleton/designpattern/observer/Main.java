package com.wusd.skeleton.designpattern.observer;

import org.junit.jupiter.api.Assertions;

/**
 * Observable 使用 observer的list 循环执行接口的调用
 * 有新的observer时,向list添加.
 * 这样可以无缝地增加observer的调用
 */
public class Main {
    public static void main(String[] args) {
        NewsAgency observable = new NewsAgency();
        CCTVChannel observer = new CCTVChannel();

        observable.addObserver(observer);
        observable.setNews("news");
        Assertions.assertEquals("news", observer.getNews());
    }
}

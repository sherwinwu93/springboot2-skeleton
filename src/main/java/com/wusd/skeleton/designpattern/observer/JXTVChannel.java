package com.wusd.skeleton.designpattern.observer;

/**
 * @author Wusd
 * @date 2025/7/17
 * @description
 */
public class JXTVChannel implements Channel {
    private String news;
    @Override
    public void update(Object news) {
        this.news = (String) news;
    }
}

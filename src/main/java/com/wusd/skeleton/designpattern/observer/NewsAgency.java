package com.wusd.skeleton.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 核心类
 */
public class NewsAgency {
    private String news;
    private List<Channel> channels = new ArrayList<Channel>();

    // 频道注册
    public void addObserver(Channel channel) {
        this.channels.add(channel);
    }

    // 频道移除
    public void removeObserver(Channel channel) {
        this.channels.remove(channel);
    }

    // 新闻发布
    public void setNews(String news) {
        this.news = news;
        // 每个频道都更新新闻
        for (Channel channel : this.channels) {
            channel.update(this.news);
        }
    }
}

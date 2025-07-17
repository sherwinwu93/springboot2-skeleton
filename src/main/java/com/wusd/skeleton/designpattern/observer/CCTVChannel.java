package com.wusd.skeleton.designpattern.observer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CCTVChannel implements Channel {
    private String news;

    public void update(Object o) {
        this.setNews((String) o);
    }
}

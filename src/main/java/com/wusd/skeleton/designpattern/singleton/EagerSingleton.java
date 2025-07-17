package com.wusd.skeleton.designpattern.singleton;

/**
 * @author wusd
 * @date 2020/1/8 23:41
 */
public class EagerSingleton {
    private final static EagerSingleton instance = new EagerSingleton();
    private EagerSingleton(){}

    public static EagerSingleton getInstance() {
        return instance;
    }
}

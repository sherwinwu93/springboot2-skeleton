package com.wusd.skeleton.designpattern.singleton;

/**
 * @author wusd
 * @date 2020/1/7 19:53
 */
public class TaskManager {
    private static TaskManager tm = null;
    private TaskManager() {}
    public static TaskManager getInstance() {
        if (tm == null) {
            tm = new TaskManager();
        }
        return tm;
    }
}

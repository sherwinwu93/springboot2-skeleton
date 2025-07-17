package com.wusd.skeleton.designpattern.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author wusd
 * @date 2020/1/7 20:09
 */
public class LoadBalancer {
    private static LoadBalancer instance = null;
    private static List<String> serverList = null;

    private LoadBalancer() {
        serverList = new ArrayList<>();
    }
    public LoadBalancer getLoadBalancer() {
        if (instance == null) {
            instance = new LoadBalancer();
        }
        return instance;
    }
    public void addServer(String server) {
        serverList.add(server);
    }
    public void removerServer(String server) {
        serverList.remove(server);

    }
    String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return serverList.get(i);
    }
}

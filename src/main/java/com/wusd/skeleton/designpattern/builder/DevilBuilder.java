package com.wusd.skeleton.designpattern.builder;

/**
 * @author wusd
 * @date 2020/1/12 1:05
 */
public class DevilBuilder extends ActorBuilder {
    public void buildType() {
        actor.setType("d-t");
    }

    @Override
    public void buildSex() {
        actor.setSex("d-s");
    }

    @Override
    public void buildFace() {
        actor.setFace("d-f");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("d-c");

    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("d-h");
    }
}

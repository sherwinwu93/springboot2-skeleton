package com.wusd.skeleton.designpattern.builder;

/**
 * @author wusd
 * @date 2020/1/12 1:05
 */
public class AngelBuilder extends ActorBuilder {
    public void buildType() {
        actor.setType("a-t");
    }

    @Override
    public void buildSex() {
        actor.setSex("a-s");
    }

    @Override
    public void buildFace() {
        actor.setFace("a-f");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("a-c");

    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("a-h");
    }
}

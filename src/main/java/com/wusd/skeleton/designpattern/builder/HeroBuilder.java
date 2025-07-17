package com.wusd.skeleton.designpattern.builder;

/**
 * @author wusd
 * @date 2020/1/12 1:04
 */
public class HeroBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("h-t");
    }

    @Override
    public void buildSex() {
        actor.setSex("h-s");
    }

    @Override
    public void buildFace() {
        actor.setFace("h-f");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("h-c");

    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("h-h");
    }
}

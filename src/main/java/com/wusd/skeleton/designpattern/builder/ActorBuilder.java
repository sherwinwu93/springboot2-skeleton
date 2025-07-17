package com.wusd.skeleton.designpattern.builder;

/**
 * @author wusd
 * @date 2020/1/12 1:04
 */
public abstract class ActorBuilder {
    protected Actor actor = new Actor();
    public abstract void buildType();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildCostume();

    public abstract void buildHairstyle();

    public Actor getResult() {
        return this.actor;
    }
}

package com.wusd.skeleton.designpattern.builder;

/**
 * @author wusd
 * @date 2020/1/12 1:04
 */
public class ActorController {
    private ActorBuilder actorBuilder;

    public ActorController(ActorBuilder actorBuilder) {
        this.actorBuilder = actorBuilder;
    }

    public Actor construct() {
        actorBuilder.buildType();
        actorBuilder.buildSex();
        actorBuilder.buildFace();
        actorBuilder.buildCostume();
        actorBuilder.buildHairstyle();
        return actorBuilder.getResult();
    }
}

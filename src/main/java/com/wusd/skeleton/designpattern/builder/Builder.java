package com.wusd.skeleton.designpattern.builder;

/**
 * 抽象建造者类
 * @author wusd
 * @date 2020/1/12 0:43
 */
public abstract class Builder {
    protected Product product = new Product();

    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();
    public abstract void buildPartD();
    public Product getResult() {
        return product;
    }
}

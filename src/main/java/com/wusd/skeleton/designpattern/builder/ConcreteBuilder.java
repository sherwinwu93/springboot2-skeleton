package com.wusd.skeleton.designpattern.builder;

/**
 * 具体建造者类
 * @author wusd
 * @date 2020/1/12 0:45
 */
public class ConcreteBuilder extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("a");
    }

    @Override
    public void buildPartB() {
        product.setPartB("b");
    }

    @Override
    public void buildPartC() {
        product.setPartC("c");

    }

    @Override
    public void buildPartD() {
        product.setPartD("d");
    }
}

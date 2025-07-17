package com.wusd.skeleton.designpattern.builder;

/**
 * 指挥者类
 * @author wusd
 * @date 2020/1/12 0:47
 */
public class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        builder.buildPartD();
        return builder.getResult();
    }

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        System.out.println(product);
    }
}

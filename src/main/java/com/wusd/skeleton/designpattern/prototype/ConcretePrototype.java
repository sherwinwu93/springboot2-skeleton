package com.wusd.skeleton.designpattern.prototype;

import lombok.Data;

/**
 * @author wusd
 * @date 2020/1/10 16:49
 */
@Data
public class ConcretePrototype implements Prototype, Cloneable {
    //成员属性
    private String attr;

    /**
     * 克隆方法
     * @return: 抽象克隆类
     */
    public Prototype clone() {
//        Prototype prototype = new ConcretePrototype();
//        ((ConcretePrototype) prototype).setAttr(this.attr);
//        return prototype;
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("Not support cloneable");
        }
        return (Prototype) object;
    }
}

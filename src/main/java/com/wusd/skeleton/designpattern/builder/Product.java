package com.wusd.skeleton.designpattern.builder;

import lombok.Data;
import lombok.ToString;

/**
 * 产品类
 * @author wusd
 * @date 2020/1/12 0:42
 */
@Data
@ToString
public class Product {
    private String partA;
    private String partB;
    private String partC;
    private String partD;
}

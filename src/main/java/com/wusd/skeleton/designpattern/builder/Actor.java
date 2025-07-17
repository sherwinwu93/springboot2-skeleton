package com.wusd.skeleton.designpattern.builder;

import lombok.Data;
import lombok.ToString;

/**
 * 产品类
 * @author wusd
 * @date 2020/1/12 1:03
 */
@Data
@ToString
public class Actor {
    private String type;
    private String sex;
    private String face;
    private String costume;
    private String hairstyle;
}

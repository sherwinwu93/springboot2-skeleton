package com.wusd.skeleton.query;

import lombok.Data;

/**
 * @author Wusd
 * @date 2025/7/17
 * @description
 */
@Data
public class Pager<T> {
    private int pageNum;
    private int pageSize;
    private T param;
}

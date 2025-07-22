package com.wusd.skeleton.utils;

import com.github.pagehelper.PageInfo;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author Wusd
 * @date 2025/7/17
 * @description
 */
public class PageInfoUtils {
    public static <T> PageInfo<T> createPageInfo(List<T> list) {
        if (CollectionUtils.isEmpty(list)) return new PageInfo<>();
        return new PageInfo<>(list);
    }
}

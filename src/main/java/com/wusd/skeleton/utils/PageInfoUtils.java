package com.wusd.skeleton.utils;

import com.github.pagehelper.PageInfo;
import com.wusd.skeleton.entity.StudentLi;
import org.apache.commons.collections4.CollectionUtils;

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

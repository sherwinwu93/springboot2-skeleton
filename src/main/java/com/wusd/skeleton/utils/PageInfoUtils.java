package com.wusd.skeleton.utils;

import com.github.pagehelper.PageInfo;
import com.wusd.skeleton.entity.Student;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author Wusd
 * @date 2025/7/17
 * @description
 */
public class PageInfoUtils {
    public static PageInfo<Student> createPageInfo(List<Student> list) {
        if (CollectionUtils.isEmpty(list)) return new PageInfo<>();
        return new PageInfo<>(list);
    }
}

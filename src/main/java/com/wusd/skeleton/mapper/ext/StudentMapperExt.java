package com.wusd.skeleton.mapper.ext;

import com.wusd.skeleton.entity.StudentLi;
import com.wusd.skeleton.entity.po.Student;

/**
 * @author Wusd
 * @date 2025/7/11
 * @description
 */
public interface StudentMapperExt {
    Student selectById(Long id);
}

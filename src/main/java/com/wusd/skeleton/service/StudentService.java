package com.wusd.skeleton.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wusd.skeleton.entity.Student;
import com.wusd.skeleton.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
 * @author Wusd
 * @date 2025/7/11
 * @description
 */
@Service
public class StudentService extends ServiceImpl<StudentMapper, Student> {
}

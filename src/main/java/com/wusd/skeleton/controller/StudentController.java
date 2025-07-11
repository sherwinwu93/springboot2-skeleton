package com.wusd.skeleton.controller;

import com.wusd.skeleton.entity.Student;
import com.wusd.skeleton.mapper.ext.StudentMapperExt;
import com.wusd.skeleton.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Wusd
 * @date 2025/7/11
 * @description
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/{id}")
    public Student getById(@PathVariable("id") Long id) {
        Student student = service.getById(id);
        return student;
    }

    @GetMapping("/list")
    public List<Student> list() {
        List<Student> list = service.list();
        return list;
    }

    @Autowired
    private StudentMapperExt studentMapperExt;
    @GetMapping("/ext/{id}")
    public Student extGetById(@PathVariable("id") Long id) {
        Student student = studentMapperExt.selectById(id);
        return student;
    }
}

package com.wusd.skeleton.controller.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.wusd.skeleton.entity.po.Student;
import com.wusd.skeleton.mapper.ext.StudentMapperExt;
import com.wusd.skeleton.query.Pager;
import com.wusd.skeleton.service.StudentService;
import com.wusd.skeleton.utils.PageInfoUtils;
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
@RequestMapping("/test/student")
public class StudentController {
    @Autowired
    private StudentService service;
    @Autowired
    private StudentMapperExt studentMapperExt;

    @GetMapping("/{id}")
    @ApiOperationSupport(order = 1)
    public Student getById(@PathVariable("id") Long id) {
        Student student = service.getById(id);
        return student;
    }

    @GetMapping("/list")
    @ApiOperationSupport(order = 2)
    public List<Student> list() {
        List<Student> list = service.list();
        return list;
    }

    @GetMapping("/ext/{id}")
    @ApiOperationSupport(order = 3)
    public Student extGetById(@PathVariable("id") Long id) {
        Student student = studentMapperExt.selectById(id);
        return student;
    }

    @GetMapping("/pageInfo")
    @ApiOperationSupport(order = 4)
    public PageInfo<Student> pageInfo(Pager<String> pager) {
        PageHelper.startPage(pager.getPageNum(), pager.getPageSize());
        List<Student> list = service.lambdaQuery()
                .list();
        return PageInfoUtils.createPageInfo(list);
    }
}

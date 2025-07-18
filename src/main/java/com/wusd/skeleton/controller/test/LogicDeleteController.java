package com.wusd.skeleton.controller.test;

import com.wusd.skeleton.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Wusd
 * @date 2025/7/18
 * @description
 */
@RestController
@RequestMapping("/test/logicDelete")
public class LogicDeleteController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{studentId}")
    public Long student(@PathVariable("studentId") Long studentId) {
        studentService.removeById(studentId);
        return studentId;
    }
}

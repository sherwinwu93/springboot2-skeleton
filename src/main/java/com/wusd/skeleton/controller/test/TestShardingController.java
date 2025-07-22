package com.wusd.skeleton.controller.test;

import com.wusd.skeleton.entity.po.Order;
import com.wusd.skeleton.entity.po.Student;
import com.wusd.skeleton.service.OrderService;
import com.wusd.skeleton.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Wusd
 * @date 2025/7/22
 * @description
 */
@RequestMapping("/sharding")
@RestController
public class TestShardingController {
    // 分表
    @Autowired
    private OrderService orderService;
    // 分库
    @Autowired
    private StudentService studentService;

    @GetMapping("getOrderById")
    public Order getOrderById(Long orderId) {
        return orderService.getById(orderId);
    }

    @PostMapping("/insertOrder")
    public Order insertOrder(@RequestBody Order order) {
        orderService.save(order);
        return order;
    }

    @GetMapping("/listOrder")
    public List<Order> listOrder() {
        return orderService.list();
    }

    @GetMapping("/getStudentById")
    public Student getStudentById(Long studentId) {
        return studentService.getById(studentId);
    }

    @PostMapping("/insertStudent")
    public Student insertStudent(@RequestBody Student student) {
        studentService.save(student);
        return student;
    }

    @GetMapping("/listStudent")
    public List<Student> listStudent() {
        return studentService.list();
    }
}

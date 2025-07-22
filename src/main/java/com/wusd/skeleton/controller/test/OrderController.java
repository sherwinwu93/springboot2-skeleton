package com.wusd.skeleton.controller.test;

import com.wusd.skeleton.entity.OrderLi;
import com.wusd.skeleton.entity.po.Order;
import com.wusd.skeleton.service.OrderService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Wusd
 * @date 2025/7/16
 * @description
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public List<Order> list() {
        return orderService.lambdaQuery()
                .list();
    }

    @GetMapping("/{userId}")
    public void insert(@PathVariable("userId") Long userId) {
        OrderLi order = new OrderLi();
        order.setUserId(userId);
        order.setPrice(new BigDecimal(RandomUtils.nextDouble(0.0, 2.0)));
        orderService.save(order);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/test-sql")
    public String testSql() {
        jdbcTemplate.queryForList("SELECT * FROM t_order WHERE order_id = 1");
        return "Check console for actual SQL";
    }
}

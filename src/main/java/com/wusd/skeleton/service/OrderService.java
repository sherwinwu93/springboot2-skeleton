package com.wusd.skeleton.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wusd.skeleton.entity.Order;
import com.wusd.skeleton.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
 * @author Wusd
 * @date 2025/7/16
 * @description
 */
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {
}

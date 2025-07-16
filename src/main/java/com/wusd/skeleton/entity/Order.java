package com.wusd.skeleton.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Wusd
 * @date 2025/7/16
 * @description
 */
@TableName("t_order")
@Data
public class Order {
    @TableId(type = IdType.AUTO)
    private Long orderId;
    @TableField("price")
    private BigDecimal price;
    @TableField("user_id")
    private Long userId;
    @TableField("status")
    private String status;
}

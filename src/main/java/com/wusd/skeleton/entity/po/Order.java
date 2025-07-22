package com.wusd.skeleton.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author Wusd
 * @since 2025-07-22
 */
@Getter
@Setter
@ToString
@TableName("t_order")
@ApiModel(value = "Order对象", description = "")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId("order_id")
    @ApiModelProperty("订单id")
    private Long orderId;

    /**
     * 订单价格
     */
    @TableField("price")
    @ApiModelProperty("订单价格")
    private BigDecimal price;

    /**
     * 下单用户id
     */
    @TableField("user_id")
    @ApiModelProperty("下单用户id")
    private Long userId;

    /**
     * 订单状态
     */
    @TableField("status")
    @ApiModelProperty("订单状态")
    private String status;
}

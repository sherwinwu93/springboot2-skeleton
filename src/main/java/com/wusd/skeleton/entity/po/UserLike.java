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
import java.time.LocalDateTime;

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
@TableName("t_user_like")
@ApiModel(value = "UserLike对象", description = "")
public class UserLike implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("user_like_id")
    private Long userLikeId;

    @TableField("user_id")
    private Long userId;

    @TableField("update_time")
    private LocalDateTime updateTime;
}

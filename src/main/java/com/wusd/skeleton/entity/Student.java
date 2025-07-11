package com.wusd.skeleton.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Wusd
 * @date 2025/7/11
 * @description
 */
@TableName("student")
@Setter
@Getter
public class Student {
    @TableId("id")
    private Long id;
    @TableField("student_name")
    private String studentName;
}

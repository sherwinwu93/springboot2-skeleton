package com.wusd.skeleton.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Wusd
 * @date 2025/7/11
 * @description
 */
@TableName("student")
@Setter
@Getter
public class Student implements Comparable<Student> {
    @TableId("id")
    private Long id;
    @TableField("student_name")
    private String studentName;

    @Override
    public int compareTo(Student other) {
        return id.compareTo(other.id);
    }
}

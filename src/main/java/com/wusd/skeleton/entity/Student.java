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
@TableName("t_student")
@Setter
@Getter
public class Student implements Comparable<Student> {
    @TableId("student_id")
    private Long studentId;
    @TableField("student_name")
    private String studentName;

    @Override
    public int compareTo(Student other) {
        return studentId.compareTo(other.studentId);
    }
}

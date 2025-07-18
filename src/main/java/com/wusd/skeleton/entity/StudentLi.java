package com.wusd.skeleton.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wusd.skeleton.entity.po.Student;
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
public class StudentLi extends Student implements Comparable<StudentLi> {
    @Override
    public int compareTo(StudentLi other) {
        return this.getStudentId().compareTo(other.getStudentId());
    }
}

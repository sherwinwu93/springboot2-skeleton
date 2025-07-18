package com.wusd.skeleton.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Wusd
 * @since 2025-07-18
 */
@Getter
@Setter
@ToString
@TableName("t_student")
@ApiModel(value = "Student对象", description = "")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "student_id", type = IdType.AUTO)
    private Long studentId;

    @TableField("student_name")
    private String studentName;

    @TableLogic
    @TableField("del_flag")
    private Integer delFlag;
}

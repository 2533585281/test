package com.wzb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author WangZhiBo
 * @since 2022-08-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Person implements Serializable {

//    private static final long serialVersionUID = 1L;

    /**
     * 人员ID
     */
    @TableId("pId")
    private Integer pId;

    /**
     * 人员名称
     */
    @TableField("pName")
    private String pName;

    /**
     * 人员年龄
     */
    @TableField("pAge")
    private String pAge;

    /**
     * 人员联系方式
     */
    @TableField("pPhone")
    private String pPhone;


}

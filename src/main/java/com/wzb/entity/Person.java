package com.wzb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author WangZhiBo
 * @since 2022-08-18
 * Data                 注在类上，提供类的get、set、equals、hashCode、canEqual、toString方法
 * EqualsAndHashCode    注在类上，提供对应的 equals 和 hashCode 方法
 * Accessors            https://blog.51cto.com/u_15344989/3654132
 * NoArgsConstructor    无参构造方法
 * AllArgsConstructor   有参构造方法
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

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

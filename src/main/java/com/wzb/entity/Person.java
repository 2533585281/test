package com.wzb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
     * @TableId(value = "pId",type = IdType.AUTO) 数据库主键自增
     * @TableId(value = "pId",type = IdType.ASSIGN_ID) 随机ID,数字类型
     * @TableId(value = "pId",type = IdType.ASSIGN_UUID) 随机ID,字符串类型
     */
    @TableId(value = "pId",type = IdType.AUTO)
//    @NotNull(message = "人员ID不能为空")
    private Integer pId;

    /**
     * 人员名称
     */
    @TableField("pName")
    @NotNull(message = "人员名称不能为空")
    private String pName;

    /**
     * 人员年龄
     */
    @TableField("pAge")
    @NotNull(message = "年龄不能为空")
    @Range(message = "年龄范围为 {min} 到 {max} 之间", min = 1, max = 100)
    private String pAge;

    /**
     * 人员联系方式
     */
    @TableField("pPhone")
    @NotNull(message = "手机号码不能为空")
    @Pattern(regexp = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$",message = "手机号码不正确！")
    private String pPhone;


}

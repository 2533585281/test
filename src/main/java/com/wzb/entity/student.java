package com.wzb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class student {
    @NotNull(message = "id不能为空")
    private Integer sid;
    @NotNull(message = "用户名不能为空")
    private String sname;
    @NotNull(message = "年龄不能为空")
    private String sage;
    @NotNull(message = "性别不能为空")
    private String sex;
    @NotNull(message = "手机号不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String phone;

    @Override
    public String toString() {
        return "student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sage='" + sage + '\'' +
                ", sex='" + sex + '\'' +
                ", \"phone\"='" + phone + '\'' +
                '}';
    }

    public static void main(String[] args) {
        student s=new student(1,"彭博","20","男","1233");
        System.out.println(s.toString());
    }
}

package com.wzb.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class student {

    private Integer sid;
    @NotBlank(message = "用户名不能为空")
    private String sname;
    @NotBlank(message = "年龄不能为空")
    private String sage;
    @NotBlank(message = "性别不能为空")
    private String sex;
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String phone;

    public student(Integer sid, String sname, String sage, String sex, String phone) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.sex = sex;
        this.phone = phone;
    }

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

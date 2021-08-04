package com.wzb.entity;

import lombok.Data;

@Data
public class student {

    private Integer sid;
    private String sname;
    private String sage;
    private String sex;
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

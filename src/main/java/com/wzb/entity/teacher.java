package com.wzb.entity;

import lombok.Data;

/**
 * @Author Administrator
 * @Date 2021/8/9 0009 16:29
 */
@Data
public class teacher {

    private Integer sid;
    private String sname;
    private String sage;
    private String sex;
    private String phone;

    public teacher(Integer sid, String sname, String sage, String sex, String phone) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.sex = sex;
        this.phone = phone;
    }
}

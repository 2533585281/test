package com.wzb.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2022/3/11 0011 10:41
 */
@Data
public class unSerialize {
    private String id;

    private List<unSerialize> unSerializeList;


    @Override
    public String toString() {
        return "unSerialize{" +
                "id='" + id + '\'' +
                ", unSerializeList=" + unSerializeList +
                '}';
    }
}

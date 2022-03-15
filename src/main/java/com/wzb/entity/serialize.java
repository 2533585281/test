package com.wzb.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2022/3/11 0011 10:39
 */
@Data
public class serialize implements Serializable {

    private String id;
    private List<serialize> slist;

    @Override
    public String toString() {
        return "serialize{" +
                "id='" + id + '\'' +
                ", slist=" + slist +
                '}';
    }
}

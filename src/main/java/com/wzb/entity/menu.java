package com.wzb.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/12/7 0007
 */
@Data
public class menu {
    String id;
    String name;
    String text;
    String url;
    String parentId;
    List<menu> children;

    public menu() {
    }

    public menu(String id, String name, String text, String url, String parentId, List<menu> children) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.url = url;
        this.parentId = parentId;
        this.children = children;
    }
}

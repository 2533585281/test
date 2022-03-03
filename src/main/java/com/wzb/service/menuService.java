package com.wzb.service;

import com.wzb.entity.menu;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/12/7 0007
 */
public interface menuService {
    List<menu> getAll();

    List<menu> getTree();

    menu getTreeGetEntity();
}

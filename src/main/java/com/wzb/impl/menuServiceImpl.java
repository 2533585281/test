package com.wzb.impl;

import com.wzb.dao.menuDao;
import com.wzb.entity.menu;
import com.wzb.service.menuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/12/7 0007
 */
@Service
public class menuServiceImpl implements menuService {

    @Autowired
    menuDao menuDao;


    @Override
    public List<menu> getAll() {
        List<menu> list = menuDao.getAll();
        System.out.println(list);
        return list;
    }

    @Override
    public List<menu> getTree() {
        // 首先查出我们的数据
        List<menu> list = menuDao.getAll();
        // 定义我们返回的数据类型，树 样式
        List<menu> treeMenus =new ArrayList<menu>();
        // getRootNode(list)  获取集合的根节点，遍历根节点
        for (menu m:getRootNode(list)) {
            // 带上父节点数据，和所有数据 进行递归
            buildChilTree(m, list);
            // 将对象添加到返回数据
            treeMenus.add(m);
        }
        // 返回数据
        return treeMenus;
    }

    /**
     * 获取根节点
     * @param list
     * @return
     */
    private List<menu> getRootNode(List<menu> list) {
        // 定义父节点集合
        List<menu> rootMenuLists =new ArrayList<menu>();
        // 遍历查到的所有数据，找到根节点
           for(menu menuNode : list) {
               // 父id为0数据，就是父节点
              if("0".equals(menuNode.getParentId())) {
                  // 加入父节点集合
                  rootMenuLists.add(menuNode);
              }
           }
        // 返回父节点集合
        return rootMenuLists;
    }

    /**
     * 递归方法，建立子树形结构
     * @param m
     * @param list
     * @return
     */
    private menu buildChilTree(menu m,List<menu> list) {
        // 定义一对象里面的儿子集合
        List<menu> chilMenus =new ArrayList<menu>();
        // 遍历所有数据
        for (menu menu:list) {
            // 遍历数据的父id 与 传入父对象的id 相同
            if (menu.getParentId().equals(m.getId())){
                // 递归，自己调自己，查出 下面所有儿子
                chilMenus.add(buildChilTree(menu,list));
            }
        }
        // 父对象修改儿子集合
        m.setChildren(chilMenus);
        return m;
    }




}

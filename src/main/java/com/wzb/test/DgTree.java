package com.wzb.test;

import com.wzb.controller.menuController;
import com.wzb.entity.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2022/3/3 0003 8:58
 */
public class DgTree {

    private static menuController menuDao;

    public static void main(String[] args) {
        menu m1=new menu("1","","","","0",null);
        menu m2=new menu("2","","","","1",null);
        menu m3=new menu("3","","","","2",null);
        menu m4=new menu("4","","","","0",null);

        // 首先查出我们的数据
        List<menu> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);


        menu maxMenu=new menu();
        maxMenu.setId("0");
        // 定义我们返回的数据类型，树 样式
        // getRootNode(list)  获取集合的根节点，遍历根节点
//        for (menu m:getRootNode(list)) {
        // 带上父节点数据，和所有数据 进行递归
        buildChilTree2(maxMenu, list);
        // 将对象添加到返回数据
//            treeMenus.add(m);
//        }
        // 返回数据
        System.out.println(maxMenu);
}
    /**
     * 递归方法，建立子树形结构
     * @param m
     * @param list
     * @return
     */
    private static menu buildChilTree2(menu m, List<menu> list) {
        // 定义一对象里面的儿子集合
        List<menu> chilMenus =new ArrayList<menu>();
        // 遍历所有数据
        for (menu menu:list) {
            // 遍历数据的父id 与 传入父对象的id 相同
            if (menu.getParentId().equals(m.getId())){
                // 递归，自己调自己，查出 下面所有儿子
                chilMenus.add(buildChilTree2(menu,list));
            }
        }
        // 父对象修改儿子集合
        m.setChildren(chilMenus);
        return m;
    }


}

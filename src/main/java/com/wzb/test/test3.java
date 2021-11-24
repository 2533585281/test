package com.wzb.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出两个数组中相同的元素
 *
 * 静态方法调用静态方法
 *
 * 单元测试不能调用静态方法
 *
 *
 */

public class test3 {

    public  void main(String[] args) {
        String[] a=new String[]{"a","b","c","d"};
        String[] b=new String[]{"b","c"};
        List<String> c=getEques(a,b);
        System.out.println(c);
    }

    public  List getEques(String[] a,String[] b){
        List<String> c=new ArrayList<>();

        for (int i=0;i<a.length;i++){
            for (int j=0;j<b.length;j++){
                if (a[i].equals(b[j])){
                    c.add(a[i]);
                }
            }
        }
        return c;
    }


}

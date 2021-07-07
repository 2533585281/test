package com.wzb.test;

import java.util.ArrayList;
import java.util.List;

public class test3 {

    public static void main(String[] args) {
        String[] a=new String[]{"a","b","c","d"};
        String[] b=new String[]{"b","c"};

        List<String> c=new ArrayList<>();

        for (int i=0;i<a.length;i++){
            for (int j=0;j<b.length;j++){
                if (a[i].equals(b[j])){
                    c.add(a[i]);
                }
            }
        }
        System.out.println(c);

    }
}

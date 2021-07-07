package com.wzb.test;

import java.util.ArrayList;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
        Integer[]  list =new Integer[]{1,2,3,4};
        Integer max=list[0];
        Integer min=list[0];
        for (int i=0;i<list.length;i++){
           if (list[i]>max){
               max=list[i];
           }
            if (list[i]<min){
                min=list[i];
            }

        }
        System.out.println(max-min);

    }

}

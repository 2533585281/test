package com.wzb.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @Author Administrator
 * @Date 2022/3/9 0009 15:35
 */
public class test6 {

    public static void main(String[] args) {

        ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");

        String str="1,2,4";
        String s1 = str.replace(",","+");
        System.out.println("s1的值："+s1);
        try {
            System.out.println("s1相加的结果："+jse.eval(s1));
        } catch (Exception t) {
        }

        String s2 = str.replace(",","");
        System.out.println("s2的值："+s2);
        System.out.println("s2的长度："+s2.length());


        String str2="1,2,4,11,14,67980";
        int count=findCount(str2,",");
        System.out.println("str2中逗号出现了多少次："+count);
        count+=1;
        System.out.println("现在让逗号出现次数加1："+count);

    }

    //计算字符串在给定字符串出现的次数
     public static int findCount(String src,String des) {
         int index = 0;
         int count = 0;
         while((index = src.indexOf(des, index)) != -1) {
                 count++;
                 index = index + des.length();
             }
         return count;
     }
}

package com.wzb.test;

import java.util.Arrays;
import java.util.List;

public class test1 {
    /**
     * 获取一个数组中两值相加等于某一个数，
     *      输出两值的下标
     *
     *  Lambda 表达式  代码越来越少了
     * @param
     */
    public static void main(String[] args) {
//        Integer[] nums={4,2,3,5};
//        int target=9;
//        for (int i=0;i<nums.length;i++){
//            for (int j=0;j<nums.length;j++){
//                if (nums[i] + nums[j]==target) {
//                    System.out.println(i+"   ---      "+j);
//                }
//                }
//            }
        List<String> list = Arrays.asList("item1", "item2");
        //test1.mai(list);
        list.forEach(System.err::println);
        }

    public static void mai(List<String> list) {
         list.forEach(item -> System.out.println(item));
    }


}


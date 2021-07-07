package com.wzb.test;

public class test1 {

    public static void main(String[] args) {
        Integer[] nums={4,2,3,5};
        int target=9;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length;j++){
                if (nums[i] + nums[j]==target) {
                    System.out.println(i+"   ---      "+j);
                }
                }
            }

        }


    }


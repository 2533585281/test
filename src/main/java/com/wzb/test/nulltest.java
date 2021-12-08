package com.wzb.test;

/**
 * @Author Administrator
 * @Date 2021/7/21 0021 9:54
 */
public class nulltest {


    public static void main(String[] args) {
        String ss=null;
        try{
            if("a".equals(ss)){
                System.out.println("a");
            }

        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("报错了");
        }
    }


}

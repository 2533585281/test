package com.wzb.test;

import java.util.Random;

/**
 * 随机数
 * 1.使用  Random 的 nextInt 方法，
 *      生成的区间从  0 到 参数-1
 * 2.返回0到1的double类型数值，通过int转化，得到随机数
 *
 */
public class test4 {
    public static void main(String[] args) {

        Random random = new Random();
        Integer ran1= random.nextInt(100);
        System.out.println("随机数1:" +ran1);

        int max=100,min=1;
        int ran2 = (int) (Math.random()*(max-min)+min);
        System.out.println("随机数2:" +ran2);

    }

}

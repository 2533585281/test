package com.wzb.test;

/**
 * @Author Administrator
 * @Date 2022/8/22 0022 15:39
 * Integer 类型变量缓存
 *
 */
public class test7 {

    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);

        Integer i11 = 128;
        Integer i22 = 128;
        System.out.println(i11 == i22);

        Integer i3 = -128;
        Integer i4 = -128;
        System.out.println(i3 == i4);

        Integer i33 = -129;
        Integer i44 = -129;
        System.out.println(i33 == i44);

    }

}

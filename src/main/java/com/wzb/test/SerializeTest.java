package com.wzb.test;

import com.wzb.entity.serialize;
import com.wzb.entity.unSerialize;

/**
 * @Author Administrator
 * @Date 2022/3/11 0011 10:42
 */
public class SerializeTest {

    public static void main(String[] args) {
        unSerialize usl=new unSerialize();

        serialize  sl=new serialize();

        System.out.println(usl.toString());

        System.out.println(sl.toString());

    }
}

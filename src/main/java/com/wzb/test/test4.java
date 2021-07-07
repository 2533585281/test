package com.wzb.test;

import java.util.Random;

public class test4 {
    public static void main(String[] args) {

        Random random = new Random();
        Integer a= random.nextInt(2);
        System.out.println("随机数:" +a);

        if(a/2==0){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

    }

}

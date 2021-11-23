package com.wzb.test;

/**
 * @Author Administrator
 * @Date 2021/11/23 0023
 * 测试    当调用子类构造器来初始化子类对象时，父类构造器总会在子类构造器之前执行；
 */
public class test5 {
    public static void main(String[] args) {
        //  new A();
        new B();
//            A ab = new B();
//            ab = new A();
    }
}


class A {
    String name;
    static { // 父类静态代码块
        System.out.print("A");
    }

    public A() { // 父类构造器
        System.out.print("a");
    }
}

class B extends A {
    static { // 子类静态代码块
        System.out.print("B");
    }

    public B() { // 子类构造器
        System.out.print("b");
    }

}
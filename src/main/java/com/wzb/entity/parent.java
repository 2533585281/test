package com.wzb.entity;

/**
 * @Author Administrator
 * @Date 2021/10/28 0028
 */
public class parent {
    public String name;
    public String age;

    public parent() {
    }

    public parent(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

package com.wzb.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/8/9 0009 16:31
 */
@Data
public class clazz {
    private teacher teacher;
    private student student1;
    private student student2;


    public com.wzb.entity.teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(com.wzb.entity.teacher teacher) {
        this.teacher = teacher;
    }

    public student getStudent1() {
        return student1;
    }

    public void setStudent1(student student1) {
        this.student1 = student1;
    }

    public student getStudent2() {
        return student2;
    }

    public void setStudent2(student student2) {
        this.student2 = student2;
    }

    public static void main(String[] args) {
        List<clazz> list=new ArrayList<>();
        List<student> stulist=new ArrayList<>();
        List<teacher> tealist=new ArrayList<>();

        stulist.add(new student(1,"彭博1","20","男","12331"));
        stulist.add(new student(2,"彭博2","21","男","12332"));
        stulist.add(new student(3,"彭博3","22","男","12333"));
        stulist.add(new student(4,"彭博4","23","男","12334"));
        stulist.add(new student(5,"彭博5","24","男","12335"));
        stulist.add(new student(6,"彭博6","25","男","12336"));


        tealist.add(new teacher(1,"王志博","22","男","1111111111"));
        tealist.add(new teacher(2,"王志博","22","男","2222222222"));

        for (int i=0;i<stulist.size();i++){
            clazz c=new clazz();
            c.setStudent1(stulist.get(i));
            c.setStudent2(stulist.get(++i));
            list.add(c);
        }

        for (int i=0;i<tealist.size();i++){
            list.get(i).setTeacher(tealist.get(i));
        }
        System.out.println(list);
    }

}

package com.wzb.dao;

import com.wzb.entity.student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface studentdao {
    List<student> getAll();

    @Select("select * from student where sid=#{sid}")
    student getBysid(Integer sid);

    @Insert("Insert into student(sname,sage,sex,phone) value(#{sname},#{sage},#{sex},#{phone})")
    Integer addStudent(student stu);

    @Update("update student set sname=#{sname},sage=#{sage},sex=#{sex},phone=#{phone} where sid=#{sid}")
    Integer updateStudent(student stu);

    @Delete("delete from student where sid=#{sid}")
    Integer deletestuById(Integer sid);


}

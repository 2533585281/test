package com.wzb.service;

import com.wzb.entity.student;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface studentService {
    List<student> getAll();

    student getBysid(Integer sid);

    Integer addStudent(student stu);

    Integer updateStudent(student stu);

    Integer deletestuById(Integer sid);
}

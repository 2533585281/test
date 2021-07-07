package com.wzb.impl;

import com.wzb.dao.studentdao;
import com.wzb.entity.student;
import com.wzb.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentServiceImpl implements studentService {

    @Autowired
    studentdao sdao;

    @Override
    public List<student> getAll() {
        return sdao.getAll();
    }

    @Override
    public student getBysid(Integer sid) {
        return sdao.getBysid(sid);
    }

    @Override
    public Integer addStudent(student stu) {
        return sdao.addStudent(stu);
    }

    @Override
    public Integer updateStudent(student stu) {
        return sdao.updateStudent(stu);
    }

    @Override
    public Integer deletestuById(Integer sid) {
        return sdao.deletestuById(sid);
    }
}

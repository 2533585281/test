package com.wzb.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzb.entity.student;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Repository
public interface studentService {
    List<student> getAll();

    student getBysid(Integer sid);

    Integer addStudent(student stu);

    Integer updateStudent(student stu);

    Integer deletestuById(Integer sid);

    List<student> importExcel(MultipartFile file) throws IOException;

    List<student> getAllUsePaging(Integer page, Integer limit);

    IPage<student> selectPageVo(Page<student> page, Integer state);

}

package com.wzb.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.wzb.dao.studentdao;
import com.wzb.entity.student;
import com.wzb.service.studentService;
import com.wzb.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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
    public List<student> getAllUsePaging(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<student> stuInfo=sdao.getAllUsePaging(page,limit);
        return stuInfo;
    }

    @Override
    public IPage<student> selectPageVo(Page<student> page, Integer state) {
        page.setCurrent((page.getCurrent()-1)*page.getSize());
        return sdao.selectPageVo(page, state);
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

    @Override
    public List<student> importExcel(MultipartFile file) throws IOException {
        //通过工具类，读取excel,得到集合
        List<ArrayList<String>> list = ExcelUtils.readExcel(file);
        List<student> result=new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            student s=new student();
            s.setSid(Integer.valueOf(list.get(i).get(0)));
            s.setSname(list.get(i).get(1));
            s.setSage(list.get(i).get(1));
            s.setSex(list.get(i).get(1));
            s.setPhone(list.get(i).get(1));
            result.add(s);
        }
        //可以保存数据库，这里不保存直接返回结果
        System.out.println(result);
        return result;
    }
}

package com.wzb.controller;

import com.wzb.entity.student;
import com.wzb.service.studentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value="学生controller",tags={"学生操作接口"})
@Controller
public class studentController {
    @Autowired
    studentService studentService;

    @ResponseBody
    //@RequestMapping("/getAll")
    @GetMapping("/getAll")
    public List<student> getAll(){
        return studentService.getAll();
    }

    @ResponseBody
    @ApiImplicitParam(name = "sid", value = "学生id", required = true, dataType = "String", paramType = "path")
    @GetMapping("/getBysid/{sid}")
    public student getBysid(@PathVariable("sid") String sid){
        return studentService.getBysid(Integer.valueOf(sid));
    }

    @ResponseBody
    @PostMapping("/addstu")
    public Integer addstu(@RequestBody student stu){
        return studentService.addStudent(stu);
    }

    @ResponseBody
    @PostMapping("/updatestu")
    public Integer updatestu(@RequestBody student stu){
        return studentService.updateStudent(stu);
    }

    @ResponseBody
    @DeleteMapping("/delstu")
    public Integer deletestu(@RequestBody Integer sid){
        return studentService.deletestuById(sid);
    }



}

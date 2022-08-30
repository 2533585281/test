package com.wzb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wzb.entity.Person;
import com.wzb.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WangZhiBo
 * @since 2022-08-18
 */
@Api(value="人员controller",tags={"人员操作接口"})
@RestController
@RequestMapping("/person")
public class PersonController {

    @Resource
    PersonService personService;

    @GetMapping("/getAll")
    @ApiOperation("查询所有人员")
    public List<Person> getByAll(){

        return personService.list();
    }

    @GetMapping("/getById/{pId}")
    @ApiOperation("查询一个人员根据人员id")
    public Person getById(@PathVariable("pId") Integer pId){

        return personService.getById(pId);
    }

    @PostMapping("/getPerson")
    @ApiOperation("查询一个人员")
    public Person getPerson(@Validated @RequestBody Person person){
        // 查询条件构造器
        QueryWrapper<Person> qp = new QueryWrapper<>();
        // eq("pId","1") ---> pId = '1'
        qp.eq("pId",person.getPId());
        // ne("pName","小张") ---> name != '小张'
        qp.ne("pName","小张");
        // ge("pAge","20") ---> pAge > 20
        qp.ge("pAge",0);
        // like("pPhone","182") ---> pPhone like '%182%'
        qp.like("pPhone",person.getPPhone());

        return personService.getOne(qp);
    }

    @PostMapping("/savePerson")
    @ApiOperation("保存一个人员")
    public Boolean savePerson(@Validated @RequestBody Person person){

        return personService.save(person);
    }

    @PostMapping("/updatePerson")
    @ApiOperation("根据人员id修改人员信息")
    public Boolean updatePerson(@Validated @RequestBody Person person){
        // 修改条件构造器
        UpdateWrapper<Person> up = new UpdateWrapper<>();
        // set("列","值") ---> 列='值'
        up.set("pName",person.getPName());
        up.set("pPhone",person.getPPhone());
        up.set("pAge",person.getPAge());
        // eq("pId","1") ---> pId = '1'
        up.eq("pId",person.getPId());

        return personService.update(up);
    }

    @GetMapping("/delById/{pId}")
    @ApiOperation("根据人员id删除人员信息")
    public Boolean delById(@PathVariable("pId") Integer pId){

        return personService.removeById(pId);
    }


}

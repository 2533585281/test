package com.wzb.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public List<Person> getAll(){

        return personService.getAll();
    }

    @GetMapping("/getById/{pId}")
    @ApiOperation("查询一个人员根据人员id")
    public Person getById(@PathVariable("pId") Integer pId){

        return personService.getBypId(pId);
    }

    @PostMapping("/getAllByPerson")
    @ApiOperation("查询符合条件的人员")
    public List<Person> getAllByPerson(@Validated @RequestBody Person person){

        return personService.getAllByPerson(person);
    }

    @PostMapping("/getAllByPersonPage")
    @ApiOperation("查询人员-分页")
    public IPage<Person> getAllByPersonPage(
                                            @RequestParam(name="current", defaultValue="1") Integer current,
                                            @RequestParam(name="size", defaultValue="10") Integer size){
        Page<Person> personPage = new Page<>(current,size);

        return personService.getAllByPersonPage(personPage);
    }

    @PostMapping("/savePerson")
    @ApiOperation("保存一个人员")
    public Person savePerson(@Validated @RequestBody Person person){

        return personService.savePerSon(person);
    }

    @PostMapping("/updatePerson")
    @ApiOperation("根据人员id修改人员信息")
    public Person updatePerson(@Validated @RequestBody Person person){


        return personService.updatePerson(person);
    }

    @GetMapping("/delById/{pId}")
    @ApiOperation("根据人员id删除人员信息")
    public Integer delById(@PathVariable("pId") Integer pId){

        return personService.delById(pId);
    }


}

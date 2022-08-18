package com.wzb.controller;


import com.wzb.entity.Person;
import com.wzb.service.PersonService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WangZhiBo
 * @since 2022-08-18
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Resource
    PersonService personService;

    @RequestMapping("/getById")
    public Person getById(@Param("pId")Integer pId){

        return personService.getById(pId);
    }


}

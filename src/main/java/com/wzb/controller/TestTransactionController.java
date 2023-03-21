package com.wzb.controller;

import com.wzb.entity.Person;
import com.wzb.service.TestTransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Administrator
 * @Date 2022/10/28 0028 11:32
 *
 * 测试事务
 */
@Api(value="测试事务controller",tags={"测试事务操作"})
@RestController
@RequestMapping("/transaction")
public class TestTransactionController {

    @Resource
    TestTransactionService testTransactionService;


    @PostMapping("/transactionCallNoTransaction")
    @ApiOperation("根据人员id修改人员信息-事务方法调用非事务方法")
    public Person transactionCallNoTransaction(@Validated @RequestBody Person person){

        return testTransactionService.transactionCallNoTransaction(person);
    }

    @PostMapping("/transactionCallTransaction")
    @ApiOperation("根据人员id修改人员信息-事务方法调用事务方法")
    public Person transactionCallTransaction(@Validated @RequestBody Person person){

        return testTransactionService.transactionByNoTransaction(person);
    }

    @PostMapping("/putUpTransaction")
    @ApiOperation("根据人员id修改人员信息-挂起事务非事务修改")
    public Person putUpTransaction(@Validated @RequestBody Person person){

        return testTransactionService.putUpTransaction(person);
    }

    @PostMapping("/creatingNewTransaction")
    @ApiOperation("根据人员id修改人员信息-无事务调用创建新事务修改")
    public Person creatingNewTransaction(@Validated @RequestBody Person person){

        return testTransactionService.creatingNewTransaction(person);
    }
}

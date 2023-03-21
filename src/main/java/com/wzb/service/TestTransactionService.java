package com.wzb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzb.entity.Person;

/**
 * @Author Administrator
 * @Date 2022/10/28 0028 11:47
 */
public interface TestTransactionService extends IService<Person> {
    Person transactionCallNoTransaction(Person person);

    Person transactionByNoTransaction(Person person);

    Person putUpTransaction(Person person);

    Person creatingNewTransaction(Person person);
}

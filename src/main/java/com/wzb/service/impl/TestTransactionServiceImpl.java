package com.wzb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzb.dao.PersonMapper;
import com.wzb.entity.Person;
import com.wzb.service.PersonService;
import com.wzb.service.TestTransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @Author Administrator
 * @Date 2022/10/28 0028 11:47
 */
@Service
public class TestTransactionServiceImpl extends ServiceImpl<PersonMapper, Person> implements TestTransactionService {

    @Override
    @Transactional
    public Person transactionCallNoTransaction(Person person) {
        try{
            Person p = transactionCallNoTransaction2(person);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        int a = 1/0;

        return baseMapper.selectById(person.getPId());
    }

    private Person transactionCallNoTransaction2(Person person) {
        int update = baseMapper.updateById(person);
        return person;
    }


    @Override
    @Transactional
    public Person transactionByNoTransaction(Person person) {
        try{
            Person p = transactionCallTransaction2(person);
            int a = 1/0;

        }catch (Exception e){

            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return baseMapper.selectById(person.getPId());
    }

    @Transactional
    public Person transactionCallTransaction2(Person person) {
        int update = baseMapper.updateById(person);
        return person;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Person putUpTransaction(Person person) {
        try{
            Person p = putUpTransaction2(person);
//            int a = 1/0;

        }catch (Exception e){

            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return baseMapper.selectById(person.getPId());
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Person putUpTransaction2(Person person) {
        int update = baseMapper.updateById(person);
        int a = 1/0;
        return person;
    }


    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
    public Person creatingNewTransaction(Person person) {
        try{
            Person p = creatingNewTransaction2(person);
//            int a = 1/0;

        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return baseMapper.selectById(person.getPId());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Person creatingNewTransaction2(Person person) {
        try{
            int update = baseMapper.updateById(person);
//            int a = 1/0;
        }catch (Exception e){

        }

        return person;
    }

}

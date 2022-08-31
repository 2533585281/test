package com.wzb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzb.dao.PersonMapper;
import com.wzb.entity.Person;
import com.wzb.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WangZhiBo
 * @since 2022-08-18
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

    @Override
    public List<Person> getAll() {
        return this.list();
    }

    @Override
    public Person getBypId(Integer pId) {
        return this.getById(pId);
    }

    @Override
    public List<Person> getAllByPerson(Person person) {
        // 查询条件构造器
        QueryWrapper<Person> qw = new QueryWrapper<>();

        // ne("pName","小张") ---> name != '小张'
        qw.ne("pName","小张");
        // ge("pAge","20") ---> pAge >= 20
        qw.ge("pAge",person.getPAge());
        // like("pPhone","182") ---> pPhone like '%182%'
        qw.like("pPhone",person.getPPhone());
        return baseMapper.selectList(qw);
    }

    @Override
    public Person savePerSon(Person person) {
        int b = baseMapper.insert(person);

        if (b==1){
            return person;
        }
        return new Person();
    }

    @Override
    public Person updatePerson(Person person) {
        // 修改条件构造器
        UpdateWrapper<Person> uw = new UpdateWrapper<>();
        // set("列","值") ---> 列='值'
        uw.set("pName",person.getPName());
        uw.set("pPhone",person.getPPhone());
        uw.set("pAge",person.getPAge());
        // eq("pId","1") ---> pId = '1'
        uw.eq("pId",person.getPId());
        int b = baseMapper.update(person,uw);
        if(b==1){
            return person;
        }
        return new Person();
    }

    @Override
    public Integer delById(Integer pId) {
        int b = baseMapper.deleteById(pId);
        if(b==1){
            return 1;
        }
        return 0;
    }

    @Override
    public IPage<Person> getAllByPersonPage(Page<Person> personPage) {
        // 查询条件构造器
        QueryWrapper<Person> qw = new QueryWrapper<>();
        qw.ge("pAge",18);

        return baseMapper.selectPage(personPage, qw);
    }


}

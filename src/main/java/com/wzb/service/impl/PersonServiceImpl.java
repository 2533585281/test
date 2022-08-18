package com.wzb.service.impl;

import com.wzb.entity.Person;
import com.wzb.dao.PersonMapper;
import com.wzb.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    PersonMapper personMapper;

}

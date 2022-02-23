package com.wzb.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author Administrator
 * @Date 2022/1/24 0024 17:27
 */
@Repository
@Mapper
public interface CronMapper {

    @Select("select cron from test.cron limit 1")
    String getCron();
}

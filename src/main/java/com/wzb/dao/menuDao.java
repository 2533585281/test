package com.wzb.dao;

import com.wzb.entity.menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/12/7 0007
 */
@Repository
@Mapper
public interface menuDao {

    @Select("select * from menu")
    List<menu> getAll();
}

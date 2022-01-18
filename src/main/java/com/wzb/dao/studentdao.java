package com.wzb.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzb.entity.student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface studentdao {
    List<student> getAll();

    @Select("select * from student where sid=#{sid}")
    student getBysid(Integer sid);

    @Insert("Insert into student(sname,sage,sex,phone) value(#{sname},#{sage},#{sex},#{phone})")
    Integer addStudent(student stu);

    @Update("update student set sname=#{sname},sage=#{sage},sex=#{sex},phone=#{phone} where sid=#{sid}")
    Integer updateStudent(student stu);

    @Delete("delete from student where sid=#{sid}")
    Integer deletestuById(Integer sid);

    /**
     * <p>
     * 查询 : 根据state状态查询用户列表，分页显示
     * </p>
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param state 状态
     * @return 分页对象
     */
    Page<student> selectPageVo(Page<student> page, Integer state);

    List<student> getAllUsePaging(Integer page, Integer limit);


}

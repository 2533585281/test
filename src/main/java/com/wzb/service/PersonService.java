package com.wzb.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzb.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WangZhiBo
 * @since 2022-08-18
 */
public interface PersonService extends IService<Person> {

    /**
     * 查询所有人员，无条件
     * @return
     */
    List<Person> getAll();

    /**
     * 根据ID查询一个人员
     * @param pId
     * @return
     */
    Person getBypId(Integer pId);

    /**
     * 根据人员实体查询一个人员对象
     * @param person
     * @return
     */
    List<Person> getAllByPerson(Person person);

    /**
     * 保存一个人员，成功返回保存的人员对象，失败返回空对象
     * @param person
     * @return
     */
    Person savePerSon(Person person);

    /**
     * 修改一个对象。成功返回修改后的人员对象，失败返回空对象
     * @param person
     * @return
     */
    Person updatePerson(Person person);

    /**
     * 根据ID删除一个人员对象
     * @param pId
     * @return
     */
    Integer delById(Integer pId);

    /**
     * 分页查询
     * @return
     */
    IPage<Person> getAllByPersonPage(Page<Person> personPage);
}

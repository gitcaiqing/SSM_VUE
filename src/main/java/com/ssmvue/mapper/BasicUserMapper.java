package com.ssmvue.mapper;

import com.ssmvue.common.VuePager;
import com.ssmvue.entity.BasicUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasicUserMapper {
    /**
     *
     * @mbggenerated 2018-07-18
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-07-18
     */
    int insert(BasicUser record);

    /**
     *
     * @mbggenerated 2018-07-18
     */
    int insertSelective(BasicUser record);

    /**
     *
     * @mbggenerated 2018-07-18
     */
    BasicUser selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-07-18
     */
    int updateByPrimaryKeySelective(BasicUser record);

    /**
     *
     * @mbggenerated 2018-07-18
     */
    int updateByPrimaryKey(BasicUser record);

    /**
     * 获取总数
     * @return
     */
    int countBasicUser(@Param("basicUser")BasicUser basicUser);

    /**
     * 获取列表数据
     * @param page
     * @return
     */
    List<BasicUser> listBasicUser(@Param("page") VuePager<BasicUser> page, @Param("basicUser")BasicUser basicUser);
}
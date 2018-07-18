package com.ssmvue.mapper;

import com.ssmvue.entity.BasicUser;

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
}
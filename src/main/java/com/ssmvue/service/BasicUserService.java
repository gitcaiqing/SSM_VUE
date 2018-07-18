/**
 * auth:CQ
 * date:2018/7/18 9:27
 **/
package com.ssmvue.service;

import com.ssmvue.common.VuePager;
import com.ssmvue.entity.BasicUser;

/**
 * Created by CQ on 2018/7/18.
 */
public interface BasicUserService {

    public Integer add();

    //获取列表数据
    VuePager<BasicUser> listPage(VuePager<BasicUser> page, BasicUser basicUser);
}
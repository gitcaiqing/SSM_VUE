/**
 * auth:CQ
 * date:2018/7/18 9:27
 **/
package com.ssmvue.service;

import com.ssmvue.common.JSONResult;
import com.ssmvue.common.VuePager;
import com.ssmvue.entity.BasicUser;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by CQ on 2018/7/18.
 */
public interface BasicUserService {

    //获取列表数据
    VuePager<BasicUser> listPage(VuePager<BasicUser> page, BasicUser basicUser);

    //根据id获取用户信息
    BasicUser findBasicUserById(Integer id);

    //根据id删除用户信息
    JSONResult deleteBasicUserById(Integer id);

    //新增用户
    JSONResult addBasicUser(BasicUser basicUser);

    //更新用户
    JSONResult updateBasicUser(BasicUser basicUser);

    //上传文件
    JSONResult uploadfile(MultipartFile file, HttpServletRequest request);
}
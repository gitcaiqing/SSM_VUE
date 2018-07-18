/**
 * auth:CQ
 * date:2018/7/18 10:13
 **/
package com.ssmvue.controller;

import com.ssmvue.common.VuePager;
import com.ssmvue.entity.BasicUser;
import com.ssmvue.service.BasicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户管理控制器
 * Created by CQ on 2018/7/18.
 */
@Controller
@RequestMapping(value = "/a/user")
public class BasicUserController {

    @Autowired
    private BasicUserService basicUserService;

    /**
     * 进入用户管理列表页
     * @return
     */
    @RequestMapping(value = "/tolist")
    public String toListPage(){
        return "/basicUser/basicUserList";
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public Integer add(){
        return basicUserService.add();
    }

    /**
     * 获取列表数据
     * @param page
     * @param basicUser
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public VuePager<BasicUser> listBasicUsers(VuePager<BasicUser> page, BasicUser basicUser){
        return basicUserService.listPage(page, basicUser);
    }
}
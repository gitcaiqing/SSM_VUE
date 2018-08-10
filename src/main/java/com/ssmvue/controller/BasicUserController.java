/**
 * auth:CQ
 * date:2018/7/18 10:13
 **/
package com.ssmvue.controller;

import com.ssmvue.common.JSONResult;
import com.ssmvue.common.VuePager;
import com.ssmvue.entity.BasicUser;
import com.ssmvue.service.BasicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户管理控制器
 * Created by CQ on 2018/7/18.
 */
@Controller
@RequestMapping(value = "/a")
public class BasicUserController {

    @Autowired
    private BasicUserService basicUserService;


    /**
     * 进入用户管理列表页
     * @return
     */
    @RequestMapping(value = "/home")
    public String home(){
        return "/home";
    }

    /**
     * 进入用户管理列表页
     * @return
     */
    @RequestMapping(value = "/user/tolist")
    public String toListPage(){
        return "/basicUser/basicUserList";
    }

    /**
     * 获取列表数据
     * @param page
     * @param basicUser
     * @return
     */
    @RequestMapping(value = "/user/users", method = RequestMethod.GET)
    @ResponseBody
    public VuePager<BasicUser> listBasicUsers(VuePager<BasicUser> page, BasicUser basicUser){
        return basicUserService.listPage(page, basicUser);
    }

    /**
     * 新增用户
     * @return
     */
    @RequestMapping(value="/user", method = RequestMethod.PUT)
    @ResponseBody
    public JSONResult addBasicUser(BasicUser basicUser){
        return basicUserService.addBasicUser(basicUser);
    }

    /**
     * 更新用户
     * @return
     */
    @RequestMapping(value="/user", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult updateBasicUser(BasicUser basicUser){
        return basicUserService.updateBasicUser(basicUser);
    }

    /**
     * 获取用户详详细
     * @param id
     * @return
     */
    @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BasicUser findBasicUserById(@PathVariable(value = "id") Integer id){
        return basicUserService.findBasicUserById(id);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value="/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JSONResult deleteBasicUserById(@PathVariable(value = "id") Integer id){
        return basicUserService.deleteBasicUserById(id);
    }

    /**
     * 文件上传  file.transferTo
     * 在spring-mvc servlet 配置文件配置  multipartResolver, 详情servlet/spring-mvc.xml
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/user/upload")
    @ResponseBody
    public JSONResult uploadfile(MultipartFile file, HttpServletRequest request){
        try {
            return basicUserService.uploadfile(file, request);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult(false, e.getMessage());
        }
    }
}
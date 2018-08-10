/**
 * auth:CQ
 * date:2018/8/3 9:52
 **/
package com.ssmvue.RestApi.Controller;

import com.ssmvue.entity.BasicUser;
import com.ssmvue.service.BasicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class BasicUserRest {

    @Autowired
    private BasicUserService basicUserService;

    @RequestMapping("/user/users")
    public List<BasicUser> listBasicUsers(){
        return basicUserService.listBasicUsers();
    }
}
/**
 * auth:CQ
 * date:2018/7/18 10:13
 **/
package com.ssmvue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by CQ on 2018/7/18.
 */
@Controller
@RequestMapping(value = "/a/user")
public class BasicUserController {

    @RequestMapping(value = "/list")
    public String listBasicUser(){


        return "/basicUser/basicUserList";
    }
}
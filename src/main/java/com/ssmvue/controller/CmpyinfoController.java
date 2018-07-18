package com.ssmvue.controller;

import com.ssmvue.service.BasicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/a")
public class CmpyinfoController {

	@Autowired
	private BasicUserService basicUserService;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "部署成功了";
    }
	
	@RequestMapping("/cmpy/list")
	public String getCmpyinfo() {
		return "/cmpyinfo/list";
	}

    @RequestMapping("/home")
    public String home() {
        return "/home";
    }
	
	@RequestMapping(value = "adduser" )
	@ResponseBody
	public Integer adduser() {
		return basicUserService.add();
	}
	
}

package com.ssmvue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

import com.ssmvue.entity.Adminuser;
import com.ssmvue.entity.Cmpyinfo;
import com.ssmvue.service.AdminuserService;
import com.ssmvue.service.CmpyinfoService;

@Controller
@RequestMapping("/a")
public class CmpyinfoController {


	
	@Autowired
	private AdminuserService adminuserService;

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
	
	@RequestMapping("/cmpy/{id}")
	@ResponseBody
	public Adminuser getCmpyinfo(@PathVariable("id")Integer id) {
		//mybatis
		//Cmpyinfo cmpyinfo = cmpyinfoServicce.getCmpyinfo(id);
		//System.out.println("cmpyinfo:"+cmpyinfo);
		//JAP
		Adminuser adminuser = adminuserService.getOne(id);
		System.out.println("adminuser:"+adminuser);

/*		adminuser = adminuserService.findByUsernameAndPassword("admin","123456");
		
		adminuser = adminuserService.findByRealname("%管理%");
		
		List<Adminuser> adminusers = adminuserService.listByUsername("admin");
		System.out.println("adminusers:"+adminusers);
		
		//事务测试
		int eff = adminuserService.trans();*/
		
		return adminuser;
	}
	
}

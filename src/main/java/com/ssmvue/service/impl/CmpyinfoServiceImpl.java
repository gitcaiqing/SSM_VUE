package com.ssmvue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssmvue.dao.AdminuserDao;
import com.ssmvue.dao.CmpyinfoDao;
import com.ssmvue.entity.Adminuser;
import com.ssmvue.entity.Cmpyinfo;
import com.ssmvue.service.CmpyinfoService;

@Service
public class CmpyinfoServiceImpl implements CmpyinfoService{
	
	@Autowired
	private CmpyinfoDao cmpyinfoDao;
	
	@Autowired
	private AdminuserDao adminuserDao;
	
	@Transactional
	public Integer insertCmpyAndUser() {
		
		//插入
		Adminuser adminuser = new Adminuser();
		adminuser.setUsername("xxxxxx");
		adminuser.setRealname("77777");
		adminuserDao.save(adminuser);
		
		//触发器执行... （更加cmpyinfo插入 触发 tb_basic_cmpyinfo_trigger 插入一条对应的记录）
		
		Cmpyinfo cmpyinfo = new Cmpyinfo();
		cmpyinfo.setQydm("77777");
		cmpyinfo.setCmpname("测试xxxxxx哈哈");
		cmpyinfo.setGname("gname");
		cmpyinfoDao.save(cmpyinfo);
		System.out.println("*********************************************");
		return 1;
	}

}

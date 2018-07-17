package com.ssmvue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssmvue.dao.AdminuserDao;
import com.ssmvue.dao.CmpyinfoDao;
import com.ssmvue.entity.Adminuser;
import com.ssmvue.entity.Cmpyinfo;
import com.ssmvue.service.AdminuserService;
import com.ssmvue.service.CmpyinfoService;

@Service
public class AdminuserServiceImpl implements AdminuserService{

	@Autowired
	private AdminuserDao adminuserDao;

	@Autowired
	private CmpyinfoDao cmpyinfoDao;

	@Autowired
	private CmpyinfoService cmpyinfoService;

	@Override
	public Adminuser getOne(Integer id) {
		// TODO Auto-generated method stub
		return adminuserDao.findOne(1);
	}

	@Override
	public List<Adminuser> listByUsername(String username) {
		// TODO Auto-generated method stub
		return adminuserDao.listByUsername(username);
	}

	@Override
	public Adminuser findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return adminuserDao.findByUsernameAndPassword(username, password);
	}

	@Override
	public Adminuser findByRealname(String realname) {
		// TODO Auto-generated method stub
		return adminuserDao.findByRealnameIsLike(realname);
	}

	@Override
	@Transactional
	public int trans() {

		//嵌套事务
		cmpyinfoService.insertCmpyAndUser();

		//插入
		Adminuser adminuser = new Adminuser();
		adminuser.setUsername("hahaha5");
		adminuser.setRealname("66666");
		adminuserDao.save(adminuser);

		//触发器执行... （更加cmpyinfo插入 触发 tb_basic_cmpyinfo_trigger 插入一条对应的记录）

		Cmpyinfo cmpyinfo = new Cmpyinfo();
		cmpyinfo.setQydm("66666");
		cmpyinfo.setCmpname("测试企业哈哈");
		cmpyinfo.setGname("gname");
		cmpyinfoDao.save(cmpyinfo);


		List<Adminuser> adminuser2 = adminuserDao.listByUsername("hahaha5");
		System.out.println("adminuser2:"+adminuser2);
		System.out.println("*********************************************");
		throw new RuntimeException();
	}

}

package com.ssmvue.service.impl;

import com.ssmvue.entity.BasicUser;
import com.ssmvue.mapper.BasicUserMapper;
import com.ssmvue.service.BasicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicuserServiceImpl implements BasicUserService{

	@Autowired
	private BasicUserMapper basicUserMapper;

	@Override
	public Integer add() {
		BasicUser basicUser = new BasicUser();
		basicUser.setUsername("蔡清");
		basicUser.setAge(18);
		basicUser.setMobile("18779681526");
		basicUser.setEmail("380120634@qq.com");
		basicUser.setRealname("蔡清");
		return basicUserMapper.insertSelective(basicUser);
	}

}

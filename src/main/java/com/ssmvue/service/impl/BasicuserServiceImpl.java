package com.ssmvue.service.impl;

import com.ssmvue.common.VuePager;
import com.ssmvue.entity.BasicUser;
import com.ssmvue.mapper.BasicUserMapper;
import com.ssmvue.service.BasicUserService;
import com.ssmvue.util.MD5Util;
import com.ssmvue.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BasicuserServiceImpl implements BasicUserService{

	private static final Logger log = LoggerFactory.getLogger(BasicuserServiceImpl.class);

	@Autowired
	private BasicUserMapper basicUserMapper;

	@Override
	public Integer add() {
		BasicUser basicUser = new BasicUser();
		basicUser.setUserid(UUIDUtil.getUUUID());
		basicUser.setUsername("hongchenxue");
		basicUser.setPassword(MD5Util.MD5("123456"));
		basicUser.setAge(18);
		basicUser.setMobile("18779681526");
		basicUser.setEmail("380120634@qq.com");
		basicUser.setRealname("红尘雪");
		basicUser.setMemo("红尘雪红尘雪红尘雪红尘雪");
		basicUser.setCredate(new Date());
		basicUser.setStatus(1);
		basicUser.setSex(0);
		return basicUserMapper.insertSelective(basicUser);
	}

	@Override
	public VuePager<BasicUser> listPage(VuePager<BasicUser> page, BasicUser basicUser) {
		int count = basicUserMapper.countBasicUser(basicUser);
		log.info("用户管理列表数据总数："+count);
		if(count == 0){
			return null;
		}
		page.setTotalRows(count);
		page.setSort("id");
		page.setDirection("desc");
		List<BasicUser> basicUserList = basicUserMapper.listBasicUser(page, basicUser);
		page.setList(basicUserList);
		log.info("用户管理列表数据："+page);
		return page;
	}

}

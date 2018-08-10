package com.ssmvue.service.impl;

import com.ssmvue.common.JSONResult;
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
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class BasicuserServiceImpl implements BasicUserService{

	private static final Logger log = LoggerFactory.getLogger(BasicuserServiceImpl.class);

	@Autowired
	private BasicUserMapper basicUserMapper;

	/**
	 * 列表数据
	 * @param page
	 * @param basicUser
	 * @return
	 */
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

	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return
	 */
    @Override
    public BasicUser findBasicUserById(Integer id) {
        return basicUserMapper.selectByPrimaryKey(id);
    }

	/**
	 *  根据id删除用户信息
	 * @param id
	 * @return
	 */
	@Override
	public JSONResult deleteBasicUserById(Integer id) {
		int effrow = basicUserMapper.deleteByPrimaryKey(id);
		if(effrow > 0){
			return new JSONResult(true, "删除成功");
		}
		return new JSONResult(false, "删除失败");
	}

	/**
	 * 新增用户
	 * @param basicUser
	 * @return
	 */
	@Override
	public JSONResult addBasicUser(BasicUser basicUser) {
		basicUser.setUserid(UUIDUtil.getUUUID());
		basicUser.setPassword(MD5Util.MD5(basicUser.getPassword()));
		Date now = new Date();
		basicUser.setCredate(now);
		basicUser.setUpddate(now);
		int effrow = basicUserMapper.insertSelective(basicUser);
		if(effrow > 0){
			return new JSONResult(true, "新增成功");
		}
		return new JSONResult(false, "新增失败");
	}

	/**
	 * 更新用户
	 * @param basicUser
	 * @return
	 */
	@Override
	public JSONResult updateBasicUser(BasicUser basicUser) {
		if(!StringUtils.isEmpty(basicUser.getPassword())) {
			basicUser.setPassword(MD5Util.MD5(basicUser.getPassword()));
		}
		basicUser.setUpddate(new Date());
		int effrow = basicUserMapper.updateByPrimaryKeySelective(basicUser);
		if(effrow > 0){
			return new JSONResult(true, "更新成功");
		}
		return new JSONResult(false, "更新失败");
	}

    /**
	 * 上传文件
	 * @param file
	 * @return
	 */
    @Override
    public JSONResult uploadfile(MultipartFile file, HttpServletRequest request) {
        String realpath = "/static/img/";
		String filename = "";
		if(file!=null){
		    String uploadfile = request.getServletContext().getRealPath(realpath);
            long time = new Date().getTime();
			filename = time+"_"+file.getOriginalFilename();
			uploadfile= uploadfile+"/"+ filename;
            try {
            	//上传
                file.transferTo(new File(uploadfile));
				int a = 1/0;
            } catch (Exception e) {
            	log.error("上传文件异常："+e.getMessage());
                e.printStackTrace();
				throw new RuntimeException("上传失败，请重试！");
            }
        }
        return new JSONResult(true,"上传成功", realpath+filename);
    }

	@Override
	public List<BasicUser> listBasicUsers() {
		return basicUserMapper.listBasicUser(new VuePager<BasicUser>(), new BasicUser());
	}

}

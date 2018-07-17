package com.ssmvue.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ssmvue.entity.Adminuser;
public interface AdminuserDao extends JpaRepository<Adminuser, Integer>{

	@Query("select a from Adminuser a where username = :username")
	public List<Adminuser> listByUsername(@Param("username") String username);
	
	Adminuser findByUsernameAndPassword(String username, String password);
	
	Adminuser findByRealnameIsLike(String realname);
	
	Adminuser findByUsername(String username);
}

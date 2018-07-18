package com.ssmvue.entity;

import java.util.Date;

public class BasicUser {
    /**
     * 主键自增
     */
    private Integer id;

    /**
     * 
     */
    private String userid;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private String headimg;

    /**
     * 
     */
    private String realname;

    /**
     * 
     */
    private Integer sex;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private String mobile;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String memo;

    /**
     * 
     */
    private Date credate;

    /**
     * 
     */
    private Date upddate;

    /**
     * 主键自增
     * @return id 主键自增
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键自增
     * @param id 主键自增
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return userId 
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 
     * @param userid 
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * 
     * @return username 
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 
     * @return password 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 
     * @return status 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * @return headimg 
     */
    public String getHeadimg() {
        return headimg;
    }

    /**
     * 
     * @param headimg 
     */
    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    /**
     * 
     * @return realname 
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 
     * @param realname 
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * 
     * @return sex 
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 
     * @param sex 
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 
     * @return age 
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 
     * @param age 
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 
     * @return mobile 
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 
     * @param mobile 
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 
     * @return email 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 
     * @return memo 
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 
     * @param memo 
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 
     * @return credate 
     */
    public Date getCredate() {
        return credate;
    }

    /**
     * 
     * @param credate 
     */
    public void setCredate(Date credate) {
        this.credate = credate;
    }

    /**
     * 
     * @return upddate 
     */
    public Date getUpddate() {
        return upddate;
    }

    /**
     * 
     * @param upddate 
     */
    public void setUpddate(Date upddate) {
        this.upddate = upddate;
    }
}
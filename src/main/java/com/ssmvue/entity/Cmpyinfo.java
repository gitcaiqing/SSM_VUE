package com.ssmvue.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name="tb_basic_cmpyinfo")
@Entity
public class Cmpyinfo implements Serializable {
	private static final long serialVersionUID = 4516616077930481204L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;

	private String qydm;

	private String jgdm;

	private String wxid;

	private Integer type;

	private String jtname;

	private String cmpname;

	private String cmpalias;

	private String orgcode;

	private String logoimg;

	private String sysname;

	private String linkman;

	private String tel;

	private String email;

	private String province;

	private String city;

	private String county;

	private String addr;

	private Integer status;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date validdate;

	private String memo;

	private Date credate;

	private Date upddate;

	private String userid;

	private String username;

	private Integer addrconfig;

	private Integer wxconfig;

	private Integer userWorkSet;

	private Integer jobcUserSet;

	private Integer jobcSchemeSet;

	// 运维端奖品设置字段
	private String prizeSet;

	private String deftype;

	private Integer cmpySet;

	private Integer netstatus; // 查询配置 Int(1)

	private Integer netcount; // 查询次数 int(11)

	private String netcontent; // 正确查询内容 varchar(200)

	private String enetcontent; // 错误查询内容 varchar(200)

	private Integer secstatus;// 第二语言配置开关 0 关闭 1开启

	private String secnetcontent;// 第二语言正确内容

	private String secenetcontent;// 第二语言错误内容

	private Integer msgnum;

	private Integer spmsgnum;

	private String jglogoimg;

	private String jgsysname;

	private String kfqq;

	private String kftel;

	private String kfwx;

	private String kfwximg;

	private String supname;

	private String supurl;

	private Integer reviewway; // 审核方式0自动审核 1手动审核

	private Integer sigstatus; // 商品举报服务开启1关闭0

	private Integer signum; // 单个标签举报次数

	private Integer remarkstatus; // 商品评分服务开启1关闭0

	private String personalIndex;// 个性化首页（查询首页，密码首页），JSON存储

	private Integer psindexSet; // 个性化查询首页设置 0不开启（默认）；1开启

	private Integer pspwdSet; // 个性化验证页设置 0不开启（默认）；1开启

	private Integer minbonus; // 鼓励金提现门槛

	private Integer maxbonus;

	private String somequestion;// 常见问题

	// 微信支付信息配置
	private String secret;// 微信密钥
	private String appid;// APPID
	private String mchid;// 商户号
	private String appsecretBusiness;// 商户密钥

	private String trace_url;
	private String tempname;

	// 分组
	private String gnum; // 分组序号
	private String gname; // 分组名称
	
	private Integer isexplain;//是否开启引导页文字 0不开启 1开启
	private Integer isprei;//是否开启运维预定义
	
	// 系统类型
	private Integer systype; // 0 溯源 1 认购

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQydm() {
		return qydm;
	}

	public void setQydm(String qydm) {
		this.qydm = qydm == null ? null : qydm.trim();
	}

	public String getJgdm() {
		return jgdm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm == null ? null : jgdm.trim();
	}

	public String getWxid() {
		return wxid;
	}

	public void setWxid(String wxid) {
		this.wxid = wxid == null ? null : wxid.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getJtname() {
		return jtname;
	}

	public void setJtname(String jtname) {
		this.jtname = jtname;
	}

	public String getCmpname() {
		return cmpname;
	}

	public void setCmpname(String cmpname) {
		this.cmpname = cmpname == null ? null : cmpname.trim();
	}

	public String getCmpalias() {
		return cmpalias;
	}

	public void setCmpalias(String cmpalias) {
		this.cmpalias = cmpalias == null ? null : cmpalias.trim();
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode == null ? null : orgcode.trim();
	}

	public String getLogoimg() {
		return logoimg;
	}

	public void setLogoimg(String logoimg) {
		this.logoimg = logoimg;
	}

	public String getSysname() {
		return sysname;
	}

	public void setSysname(String sysname) {
		this.sysname = sysname;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman == null ? null : linkman.trim();
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county == null ? null : county.trim();
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr == null ? null : addr.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getValiddate() {
		return validdate;
	}

	public void setValiddate(Date validdate) {
		this.validdate = validdate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}

	public Date getCredate() {
		return credate;
	}

	public void setCredate(Date credate) {
		this.credate = credate;
	}

	public Date getUpddate() {
		return upddate;
	}

	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * @return the userWorkSet
	 */
	public Integer getUserWorkSet() {
		return userWorkSet;
	}

	/**
	 * @param userWorkSet
	 *            the userWorkSet to set
	 */
	public void setUserWorkSet(Integer userWorkSet) {
		this.userWorkSet = userWorkSet;
	}

	public Integer getJobcUserSet() {
		return jobcUserSet;
	}

	public void setJobcUserSet(Integer jobcUserSet) {
		this.jobcUserSet = jobcUserSet;
	}

	public Integer getJobcSchemeSet() {
		return jobcSchemeSet;
	}

	public void setJobcSchemeSet(Integer jobcSchemeSet) {
		this.jobcSchemeSet = jobcSchemeSet;
	}

	public String getDeftype() {
		return deftype;
	}

	public void setDeftype(String deftype) {
		this.deftype = deftype;
	}

	public Integer getCmpySet() {
		return cmpySet;
	}

	public void setCmpySet(Integer cmpySet) {
		this.cmpySet = cmpySet;
	}

	public Integer getNetstatus() {
		return netstatus;
	}

	public void setNetstatus(Integer netstatus) {
		this.netstatus = netstatus;
	}

	public Integer getNetcount() {
		return netcount;
	}

	public void setNetcount(Integer netcount) {
		this.netcount = netcount;
	}

	public String getNetcontent() {
		return netcontent;
	}

	public void setNetcontent(String netcontent) {
		this.netcontent = netcontent;
	}

	public String getEnetcontent() {
		return enetcontent;
	}

	public void setEnetcontent(String enetcontent) {
		this.enetcontent = enetcontent;
	}

	public Integer getSecstatus() {
		return secstatus;
	}

	public void setSecstatus(Integer secstatus) {
		this.secstatus = secstatus;
	}

	public String getSecnetcontent() {
		return secnetcontent;
	}

	public void setSecnetcontent(String secnetcontent) {
		this.secnetcontent = secnetcontent;
	}

	public String getSecenetcontent() {
		return secenetcontent;
	}

	public void setSecenetcontent(String secenetcontent) {
		this.secenetcontent = secenetcontent;
	}

	public String getJglogoimg() {
		return jglogoimg;
	}

	public void setJglogoimg(String jglogoimg) {
		this.jglogoimg = jglogoimg;
	}

	public String getJgsysname() {
		return jgsysname;
	}

	public void setJgsysname(String jgsysname) {
		this.jgsysname = jgsysname;
	}

	public String getKfqq() {
		return kfqq;
	}

	public void setKfqq(String kfqq) {
		this.kfqq = kfqq;
	}

	public String getKftel() {
		return kftel;
	}

	public void setKftel(String kftel) {
		this.kftel = kftel;
	}

	public String getKfwx() {
		return kfwx;
	}

	public void setKfwx(String kfwx) {
		this.kfwx = kfwx;
	}

	public String getKfwximg() {
		return kfwximg;
	}

	public void setKfwximg(String kfwximg) {
		this.kfwximg = kfwximg;
	}

	public String getSupname() {
		return supname;
	}

	public void setSupname(String supname) {
		this.supname = supname;
	}

	public String getSupurl() {
		return supurl;
	}

	public void setSupurl(String supurl) {
		this.supurl = supurl;
	}

	public Integer getReviewway() {
		return reviewway;
	}

	public void setReviewway(Integer reviewway) {
		this.reviewway = reviewway;
	}

	public Integer getSigstatus() {
		return sigstatus;
	}

	public void setSigstatus(Integer sigstatus) {
		this.sigstatus = sigstatus;
	}

	public Integer getSignum() {
		return signum;
	}

	public void setSignum(Integer signum) {
		this.signum = signum;
	}

	public Integer getRemarkstatus() {
		return remarkstatus;
	}

	public void setRemarkstatus(Integer remarkstatus) {
		this.remarkstatus = remarkstatus;
	}

	public Integer getMsgnum() {
		return msgnum;
	}

	public void setMsgnum(Integer msgnum) {
		this.msgnum = msgnum;
	}

	public Integer getSpmsgnum() {
		return spmsgnum;
	}

	public void setSpmsgnum(Integer spmsgnum) {
		this.spmsgnum = spmsgnum;
	}

	public Integer getAddrconfig() {
		return addrconfig;
	}

	public void setAddrconfig(Integer addrconfig) {
		this.addrconfig = addrconfig;
	}

	public Integer getWxconfig() {
		return wxconfig;
	}

	public void setWxconfig(Integer wxconfig) {
		this.wxconfig = wxconfig;
	}

	/**
	 * @return the personalIndex
	 */
	public String getPersonalIndex() {
		return personalIndex;
	}

	/**
	 * @param personalIndex
	 *            the personalIndex to set
	 */
	public void setPersonalIndex(String personalIndex) {
		this.personalIndex = personalIndex;
	}

	/**
	 * @return the psindexSet
	 */
	public Integer getPsindexSet() {
		return psindexSet;
	}

	/**
	 * @param psindexSet
	 *            the psindexSet to set
	 */
	public void setPsindexSet(Integer psindexSet) {
		this.psindexSet = psindexSet;
	}

	/**
	 * @return the pspwdSet
	 */
	public Integer getPspwdSet() {
		return pspwdSet;
	}

	/**
	 * @param pspwdSet
	 *            the pspwdSet to set
	 */
	public void setPspwdSet(Integer pspwdSet) {
		this.pspwdSet = pspwdSet;
	}

	public Integer getMinbonus() {
		return minbonus;
	}

	public void setMinbonus(Integer minbonus) {
		this.minbonus = minbonus;
	}

	public Integer getMaxbonus() {
		return maxbonus;
	}

	public void setMaxbonus(Integer maxbonus) {
		this.maxbonus = maxbonus;
	}

	public String getSomequestion() {
		return somequestion;
	}

	public void setSomequestion(String somequestion) {
		this.somequestion = somequestion;
	}

	public String getPrizeSet() {
		return prizeSet;
	}

	public void setPrizeSet(String prizeSet) {
		this.prizeSet = prizeSet;
	}

	public String getTrace_url() {
		return trace_url;
	}

	public void setTrace_url(String trace_url) {
		this.trace_url = trace_url;
	}

	public String getTempname() {
		return tempname;
	}

	public void setTempname(String tempname) {
		this.tempname = tempname;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getAppsecretBusiness() {
		return appsecretBusiness;
	}

	public void setAppsecretBusiness(String appsecretBusiness) {
		this.appsecretBusiness = appsecretBusiness;
	}

	public String getGnum() {
		return gnum;
	}

	public void setGnum(String gnum) {
		this.gnum = gnum;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Integer getIsexplain() {
		return isexplain;
	}

	public void setIsexplain(Integer isexplain) {
		this.isexplain = isexplain;
	}

	public Integer getIsprei() {
		return isprei;
	}

	public void setIsprei(Integer isprei) {
		this.isprei = isprei;
	}

	public Integer getSystype() {
		return systype;
	}

	public void setSystype(Integer systype) {
		this.systype = systype;
	}

	@Override
	public String toString() {
		return "Cmpyinfo [id=" + id + ", qydm=" + qydm + ", jgdm=" + jgdm + ", wxid=" + wxid + ", type=" + type
				+ ", jtname=" + jtname + ", cmpname=" + cmpname + ", cmpalias=" + cmpalias + ", orgcode=" + orgcode
				+ ", logoimg=" + logoimg + ", sysname=" + sysname + ", linkman=" + linkman + ", tel=" + tel + ", email="
				+ email + ", province=" + province + ", city=" + city + ", county=" + county + ", addr=" + addr
				+ ", status=" + status + ", validdate=" + validdate + ", memo=" + memo + ", credate=" + credate
				+ ", upddate=" + upddate + ", userid=" + userid + ", username=" + username + ", addrconfig="
				+ addrconfig + ", wxconfig=" + wxconfig + ", userWorkSet=" + userWorkSet + ", jobcUserSet="
				+ jobcUserSet + ", jobcSchemeSet=" + jobcSchemeSet + ", prizeSet=" + prizeSet + ", deftype=" + deftype
				+ ", cmpySet=" + cmpySet + ", netstatus=" + netstatus + ", netcount=" + netcount + ", netcontent="
				+ netcontent + ", enetcontent=" + enetcontent + ", secstatus=" + secstatus + ", secnetcontent="
				+ secnetcontent + ", secenetcontent=" + secenetcontent + ", msgnum=" + msgnum + ", spmsgnum=" + spmsgnum
				+ ", jglogoimg=" + jglogoimg + ", jgsysname=" + jgsysname + ", kfqq=" + kfqq + ", kftel=" + kftel
				+ ", kfwx=" + kfwx + ", kfwximg=" + kfwximg + ", supname=" + supname + ", supurl=" + supurl
				+ ", reviewway=" + reviewway + ", sigstatus=" + sigstatus + ", signum=" + signum + ", remarkstatus="
				+ remarkstatus + ", personalIndex=" + personalIndex + ", psindexSet=" + psindexSet + ", pspwdSet="
				+ pspwdSet + ", minbonus=" + minbonus + ", maxbonus=" + maxbonus + ", somequestion=" + somequestion
				+ ", secret=" + secret + ", appid=" + appid + ", mchid=" + mchid + ", appsecretBusiness="
				+ appsecretBusiness + ", trace_url=" + trace_url + ", tempname=" + tempname + ", gnum=" + gnum
				+ ", gname=" + gname + ", isexplain=" + isexplain + ", isprei=" + isprei + ", systype=" + systype + "]";
	}
	

}
package com.ssmvue.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tb_basic_cmpy_module")
@Entity
public class ModuleCmpy {
	@GeneratedValue
	@Id
    private Integer id;

    private String qydm;

    private String moduleid;

    private Date credate;
    
    private String modulename;
    
    private String guide;
    
    private String finish;

    private String userid;

    private String username;
    
    private String moduleicon;
    
    private Integer userange;
    

    public String getModuleicon() {
		return moduleicon;
	}

	public void setModuleicon(String moduleicon) {
		this.moduleicon = moduleicon;
	}

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

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid == null ? null : moduleid.trim();
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
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

	public String getModulename() {
		return modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	public Integer getUserange() {
		return userange;
	}

	public void setUserange(Integer userange) {
		this.userange = userange;
	}

	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}
	
	
    
}
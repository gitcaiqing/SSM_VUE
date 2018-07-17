package com.ssmvue.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tb_module")
@Entity
public class Module implements Serializable{
	
	
	private static final long serialVersionUID = -7805256742540048030L;
	@GeneratedValue
	@Id
	private Integer id;

    private String modmark;

    private String moduleid;

    private String modulename;
    
    private String secmodulename;

    private Integer apptype;
    
    private Integer moduletype;
    
    private Integer infotype;

    private Integer showtype;

    private String eleinfo;

    private String memo;

    private Integer status;

    private Integer seqnum;

    private Date credate;

    private Date upddate;
    
    private String userId;
    
    private String username;
    
    private String moduleicon; 
    
    private String cusname;
    
    private Integer userange;

    private String guide; 
    private String finish; 
    
    private Integer usetype;
    private Integer dispos;
    
    
    private Integer cminfotype;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModmark() {
        return modmark;
    }

    public void setModmark(String modmark) {
        this.modmark = modmark == null ? null : modmark.trim();
    }

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid == null ? null : moduleid.trim();
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }

    public String getSecmodulename() {
		return secmodulename;
	}

	public void setSecmodulename(String secmodulename) {
		this.secmodulename = secmodulename;
	}

	public Integer getApptype() {
		return apptype;
	}

	public void setApptype(Integer apptype) {
		this.apptype = apptype;
	}

	public Integer getModuletype() {
        return moduletype;
    }

    public void setModuletype(Integer moduletype) {
        this.moduletype = moduletype;
    }

    
    public Integer getInfotype() {
		return infotype;
	}

	public void setInfotype(Integer infotype) {
		this.infotype = infotype;
	}

	public Integer getShowtype() {
        return showtype;
    }

    public void setShowtype(Integer showtype) {
        this.showtype = showtype;
    }

    public String getEleinfo() {
        return eleinfo;
    }

    public void setEleinfo(String eleinfo) {
        this.eleinfo = eleinfo == null ? null : eleinfo.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSeqnum() {
        return seqnum;
    }

    public void setSeqnum(Integer seqnum) {
        this.seqnum = seqnum;
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
    
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getModuleicon() {
		return moduleicon;
	}

	public void setModuleicon(String moduleicon) {
		this.moduleicon = moduleicon;
	}

	public String getCusname() {
		return cusname;
	}

	public void setCusname(String cusname) {
		this.cusname = cusname;
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

	public Integer getUsetype() {
		return usetype;
	}

	public void setUsetype(Integer usetype) {
		this.usetype = usetype;
	}

	public Integer getDispos() {
		return dispos;
	}

	public void setDispos(Integer dispos) {
		this.dispos = dispos;
	}

	public Integer getCminfotype() {
		return cminfotype;
	}

	public void setCminfotype(Integer cminfotype) {
		this.cminfotype = cminfotype;
	}

}
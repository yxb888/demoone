package com.xb.domain;

import java.util.Date;

//出差表
public class WorkEvection {
//	出差id
    private String evectionid;
//出差地点
    private String evectionsite;
//出差事由
    private String applycause;
//出差开始时间
    private Date evectionstartdate;
//出差结束时间
    private Date enddate;
//申请时间
    private Date applydate;
//申请状态
    private Integer applystate;
//出差人员
    private String evectionname;

//    业务字段-----------------------------------------------------------
//    开始时间
    private String starttime;
//    结束时间
    private String endtime;
//    申请时间
    private String applytime;
//    员工表
    private User user;
    
// --------------------------------------------------------------------   
    
    public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getApplytime() {
		return applytime;
	}

	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getApplycause() {
		return applycause;
	}

	public void setApplycause(String applycause) {
		this.applycause = applycause;
	}

	public String getEvectionid() {
        return evectionid;
    }

    public void setEvectionid(String evectionid) {
        this.evectionid = evectionid == null ? null : evectionid.trim();
    }

    public String getEvectionsite() {
        return evectionsite;
    }

    public void setEvectionsite(String evectionsite) {
        this.evectionsite = evectionsite == null ? null : evectionsite.trim();
    }

    public Date getEvectionstartdate() {
        return evectionstartdate;
    }

    public void setEvectionstartdate(Date evectionstartdate) {
        this.evectionstartdate = evectionstartdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public Integer getApplystate() {
        return applystate;
    }

    public void setApplystate(Integer applystate) {
        this.applystate = applystate;
    }

    public String getEvectionname() {
        return evectionname;
    }

    public void setEvectionname(String evectionname) {
        this.evectionname = evectionname == null ? null : evectionname.trim();
    }
}
package com.xb.domain;

import java.util.Date;

//请假表
public class WorkObj {
	
//	假条ID
    private String workid;
//    申请时间
    private Date applydate;
//开始时间
    private Date leavestartdate;
//结束时间
    private Date leaveenddate;
//    请假事由
    private String leavecause;
//申请状态
//    1	处理中
//    2	批准
//    3	驳回
    private Integer applystate;
//请假类型
//    1	事假
//    2	病假
//    3	产假
//    4	婚假
//    5	年假
    private Integer leavetype;
//申请人
    private String applyid;
    
    
//    业务字段
//    开始时间
    private String startdate;
//    结束时间
    private String enddate;
//    申请时间
    private String applytime;
    
    
//    用户表
    private User user;
    
    

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getApplytime() {
		return applytime;
	}

	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}

	public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid == null ? null : workid.trim();
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public Date getLeavestartdate() {
        return leavestartdate;
    }

    public void setLeavestartdate(Date leavestartdate) {
        this.leavestartdate = leavestartdate;
    }

    public Date getLeaveenddate() {
        return leaveenddate;
    }

    public void setLeaveenddate(Date leaveenddate) {
        this.leaveenddate = leaveenddate;
    }

    public String getLeavecause() {
        return leavecause;
    }

    public void setLeavecause(String leavecause) {
        this.leavecause = leavecause == null ? null : leavecause.trim();
    }

    public Integer getApplystate() {
        return applystate;
    }

    public void setApplystate(Integer applystate) {
        this.applystate = applystate;
    }

    public Integer getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(Integer leavetype) {
        this.leavetype = leavetype;
    }

    public String getApplyid() {
        return applyid;
    }

    public void setApplyid(String applyid) {
        this.applyid = applyid == null ? null : applyid.trim();
    }
}
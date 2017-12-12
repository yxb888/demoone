package com.xb.domain;

import java.util.Date;

public class WorkJobObj {
//	工作ID
    private String workid;
//工作文号
    private String workuuid;
//工作名称
    private String workname;
//开始时间
    private Date workstartdate;
//结束时间
    private Date workenddate;
//负责人
    private String principal;
//处理结果
//     1	处理中
//     2	处理完成
//     3	未开始
    private Integer workresult;
//流水号
    private String workserial;
//流程类型
//    1 开发
//    2 测试
    private Integer workserialtype;
//发起人
    private String initiator;
//    代办/已办
    private Integer workOKNO;
    
//  业务字段
//  开始时间
  private String startdate;
//  结束时间
  private String enddate;
//  User表
  private User user;

public Integer getWorkOKNO() {
		return workOKNO;
	}

	public void setWorkOKNO(Integer workOKNO) {
		this.workOKNO = workOKNO;
	}


    
    
    
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

	public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid == null ? null : workid.trim();
    }

    public String getWorkuuid() {
        return workuuid;
    }

    public void setWorkuuid(String workuuid) {
        this.workuuid = workuuid == null ? null : workuuid.trim();
    }

    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname == null ? null : workname.trim();
    }

    public Date getWorkstartdate() {
        return workstartdate;
    }

    public void setWorkstartdate(Date workstartdate) {
        this.workstartdate = workstartdate;
    }

    public Date getWorkenddate() {
        return workenddate;
    }

    public void setWorkenddate(Date workenddate) {
        this.workenddate = workenddate;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    public Integer getWorkresult() {
        return workresult;
    }

    public void setWorkresult(Integer workresult) {
        this.workresult = workresult;
    }

    public String getWorkserial() {
        return workserial;
    }

    public void setWorkserial(String workserial) {
        this.workserial = workserial == null ? null : workserial.trim();
    }



    public Integer getWorkserialtype() {
		return workserialtype;
	}

	public void setWorkserialtype(Integer workserialtype) {
		this.workserialtype = workserialtype;
	}

	public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator == null ? null : initiator.trim();
    }
}
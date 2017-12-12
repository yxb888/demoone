package com.xb.domain;

import java.util.Date;

public class Table {
    private Integer tableid;

    private String tablename;

    private Integer typeid;

    private String creater;

    private Date createtime;
    private String tablestate;

    private String adjunct;
    
    private Integer adjunctCount;
    
    private TableType tabletype;
    
    private String createtimeStr;
    
    private String strattime;
    
    private String endtime;
    


	

	public String getStrattime() {
		return strattime;
	}

	public void setStrattime(String strattime) {
		this.strattime = strattime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getCreatetimeStr() {
		return createtimeStr;
	}

	public void setCreatetimeStr(String createtimeStr) {
		this.createtimeStr = createtimeStr;
	}

	public TableType getTabletype() {
		return tabletype;
	}

	public void setTabletype(TableType tabletype) {
		this.tabletype = tabletype;
	}

	public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getAdjunct() {
        return adjunct;
    }

    public void setAdjunct(String adjunct) {
        this.adjunct = adjunct == null ? null : adjunct.trim();
    }

	public Integer getAdjunctCount() {
		return adjunctCount;
	}

	public void setAdjunctCount(Integer adjunctCount) {
		this.adjunctCount = adjunctCount;
	}

	public String getTablestate() {
		return tablestate;
	}

	public void setTablestate(String tablestate) {
		this.tablestate = tablestate;
	}
	
    
}
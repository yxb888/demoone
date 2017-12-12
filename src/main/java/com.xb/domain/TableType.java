package com.xb.domain;

public class TableType {
    private Integer tabletypeid;

    private String tabletypename;

    private String tablequeryname;

    private String typestate;
    private Integer tablecount;
    
    

    public Integer getTablecount() {
		return tablecount;
	}

	public void setTablecount(Integer tablecount) {
		this.tablecount = tablecount;
	}

	public Integer getTabletypeid() {
        return tabletypeid;
    }

    public void setTabletypeid(Integer tabletypeid) {
        this.tabletypeid = tabletypeid;
    }

    public String getTabletypename() {
        return tabletypename;
    }

    public void setTabletypename(String tabletypename) {
        this.tabletypename = tabletypename == null ? null : tabletypename.trim();
    }

    public String getTablequeryname() {
        return tablequeryname;
    }

    public void setTablequeryname(String tablequeryname) {
        this.tablequeryname = tablequeryname == null ? null : tablequeryname.trim();
    }

    public String getTypestate() {
        return typestate;
    }

    public void setTypestate(String typestate) {
        this.typestate = typestate == null ? null : typestate.trim();
    }
}
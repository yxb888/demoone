package com.xb.domain;

public class OrgList {
    private String orgid;

    private String orguuid;

    private String orgname;

    private String orgyingyu;

    private String orgboos;

    private String orgupboos;
    
    
    private String orgBM;
    private String orgMC;
    private String orgYYMC;
    
    

    public String getOrgBM() {
		return orgBM;
	}

	public void setOrgBM(String orgBM) {
		this.orgBM = orgBM;
	}

	public String getOrgMC() {
		return orgMC;
	}

	public void setOrgMC(String orgMC) {
		this.orgMC = orgMC;
	}

	public String getOrgYYMC() {
		return orgYYMC;
	}

	public void setOrgYYMC(String orgYYMC) {
		this.orgYYMC = orgYYMC;
	}

	public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public String getOrguuid() {
        return orguuid;
    }

    public void setOrguuid(String orguuid) {
        this.orguuid = orguuid == null ? null : orguuid.trim();
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public String getOrgyingyu() {
        return orgyingyu;
    }

    public void setOrgyingyu(String orgyingyu) {
        this.orgyingyu = orgyingyu == null ? null : orgyingyu.trim();
    }

    public String getOrgboos() {
        return orgboos;
    }

    public void setOrgboos(String orgboos) {
        this.orgboos = orgboos == null ? null : orgboos.trim();
    }

    public String getOrgupboos() {
        return orgupboos;
    }

    public void setOrgupboos(String orgupboos) {
        this.orgupboos = orgupboos == null ? null : orgupboos.trim();
    }

	@Override
	public String toString() {
		return "OrgList [orgid=" + orgid + ", orguuid=" + orguuid + ", orgname=" + orgname + ", orgyingyu=" + orgyingyu
				+ ", orgboos=" + orgboos + ", orgupboos=" + orgupboos + ", orgBM=" + orgBM + ", orgMC=" + orgMC
				+ ", orgYYMC=" + orgYYMC + "]";
	}
    
}
package com.xb.domain;

import java.io.Serializable;

public class Picture implements Serializable{
    private static final long serialVersionUID = -6029819821254737716L;

	private Integer pId;

    private String pName;

    private String pUrl;

    private String pLastname;
    
    private String pOldname;

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpUrl() {
		return pUrl;
	}

	public void setpUrl(String pUrl) {
		this.pUrl = pUrl;
	}

	public String getpLastname() {
		return pLastname;
	}

	public void setpLastname(String pLastname) {
		this.pLastname = pLastname;
	}

	public String getpOldname() {
		return pOldname;
	}

	public void setpOldname(String pOldname) {
		this.pOldname = pOldname;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pId == null) ? 0 : pId.hashCode());
		result = prime * result + ((pLastname == null) ? 0 : pLastname.hashCode());
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		result = prime * result + ((pOldname == null) ? 0 : pOldname.hashCode());
		result = prime * result + ((pUrl == null) ? 0 : pUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Picture other = (Picture) obj;
		if (pId == null) {
			if (other.pId != null)
				return false;
		} else if (!pId.equals(other.pId))
			return false;
		if (pLastname == null) {
			if (other.pLastname != null)
				return false;
		} else if (!pLastname.equals(other.pLastname))
			return false;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		if (pOldname == null) {
			if (other.pOldname != null)
				return false;
		} else if (!pOldname.equals(other.pOldname))
			return false;
		if (pUrl == null) {
			if (other.pUrl != null)
				return false;
		} else if (!pUrl.equals(other.pUrl))
			return false;
		return true;
	}


}
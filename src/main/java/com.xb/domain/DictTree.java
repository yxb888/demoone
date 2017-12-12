package com.xb.domain;

import java.io.Serializable;

public class DictTree implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	private String tDictId;

    private String tDictName;

    private String tDictText;

    private String tDictUrl;

    private String tDictPid;

    private String tDictLeaf;

    private String tDictCode;

    private String tDictEnname;

    private String tText;

    public String gettDictId() {
        return tDictId;
    }

    public void settDictId(String tDictId) {
        this.tDictId = tDictId == null ? null : tDictId.trim();
    }

    public String gettDictName() {
        return tDictName;
    }

    public void settDictName(String tDictName) {
        this.tDictName = tDictName == null ? null : tDictName.trim();
    }

    public String gettDictText() {
        return tDictText;
    }

    public void settDictText(String tDictText) {
        this.tDictText = tDictText == null ? null : tDictText.trim();
    }

    public String gettDictUrl() {
        return tDictUrl;
    }

    public void settDictUrl(String tDictUrl) {
        this.tDictUrl = tDictUrl == null ? null : tDictUrl.trim();
    }

    public String gettDictPid() {
        return tDictPid;
    }

    public void settDictPid(String tDictPid) {
        this.tDictPid = tDictPid == null ? null : tDictPid.trim();
    }

    public String gettDictLeaf() {
        return tDictLeaf;
    }

    public void settDictLeaf(String tDictLeaf) {
        this.tDictLeaf = tDictLeaf == null ? null : tDictLeaf.trim();
    }

    public String gettDictCode() {
        return tDictCode;
    }

    public void settDictCode(String tDictCode) {
        this.tDictCode = tDictCode == null ? null : tDictCode.trim();
    }

    public String gettDictEnname() {
        return tDictEnname;
    }

    public void settDictEnname(String tDictEnname) {
        this.tDictEnname = tDictEnname == null ? null : tDictEnname.trim();
    }

    public String gettText() {
        return tText;
    }

    public void settText(String tText) {
        this.tText = tText == null ? null : tText.trim();
    }

	@Override
	public String toString() {
		return "DictTree [tDictId=" + tDictId + ", tDictName=" + tDictName + ", tDictText=" + tDictText + ", tDictUrl="
				+ tDictUrl + ", tDictPid=" + tDictPid + ", tDictLeaf=" + tDictLeaf + ", tDictCode=" + tDictCode
				+ ", tDictEnname=" + tDictEnname + ", tText=" + tText + "]";
	}

	public DictTree() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tDictId == null) ? 0 : tDictId.hashCode());
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
		DictTree other = (DictTree) obj;
		if (tDictId == null) {
			if (other.tDictId != null)
				return false;
		} else if (!tDictId.equals(other.tDictId))
			return false;
		return true;
	}
    
}
package com.xb.domain;



public class GangWei{
    private String tGwId;

    private String tGwName;

    private String tGwEgname;

    private String tGwSjgw;

    private String tGwInfo;

    private String tGwFzr;

    @Override
	public String toString() {
		return "GangWei [tGwId=" + tGwId + ", tGwName=" + tGwName + ", tGwEgname=" + tGwEgname + ", tGwSjgw=" + tGwSjgw
				+ ", tGwInfo=" + tGwInfo + ", tGwFzr=" + tGwFzr + "]";
	}

	public String gettGwId() {
        return tGwId;
    }

    public void settGwId(String tGwId) {
        this.tGwId = tGwId == null ? null : tGwId.trim();
    }

    public String gettGwName() {
        return tGwName;
    }

    public void settGwName(String tGwName) {
        this.tGwName = tGwName == null ? null : tGwName.trim();
    }

    public String gettGwEgname() {
        return tGwEgname;
    }

    public void settGwEgname(String tGwEgname) {
        this.tGwEgname = tGwEgname == null ? null : tGwEgname.trim();
    }

    public String gettGwSjgw() {
        return tGwSjgw;
    }

    public void settGwSjgw(String tGwSjgw) {
        this.tGwSjgw = tGwSjgw == null ? null : tGwSjgw.trim();
    }

    public String gettGwInfo() {
        return tGwInfo;
    }

    public void settGwInfo(String tGwInfo) {
        this.tGwInfo = tGwInfo == null ? null : tGwInfo.trim();
    }

    public String gettGwFzr() {
        return tGwFzr;
    }

    public void settGwFzr(String tGwFzr) {
        this.tGwFzr = tGwFzr == null ? null : tGwFzr.trim();
    }
}
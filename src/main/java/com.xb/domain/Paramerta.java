package com.xb.domain;

import java.io.Serializable;

public class Paramerta implements Serializable{

	private static final long serialVersionUID = 1L;

	private String pId;

    private String pTimege;

    private String pCspwd;

    private String pCsline;

    private String pXq;

    private String pDisk;

    private String pLostline;

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpTimege() {
		return pTimege;
	}

	public void setpTimege(String pTimege) {
		this.pTimege = pTimege;
	}

	public String getpCspwd() {
		return pCspwd;
	}

	public void setpCspwd(String pCspwd) {
		this.pCspwd = pCspwd;
	}

	public String getpCsline() {
		return pCsline;
	}

	public void setpCsline(String pCsline) {
		this.pCsline = pCsline;
	}

	public String getpXq() {
		return pXq;
	}

	public void setpXq(String pXq) {
		this.pXq = pXq;
	}

	public String getpDisk() {
		return pDisk;
	}

	public void setpDisk(String pDisk) {
		this.pDisk = pDisk;
	}

	public String getpLostline() {
		return pLostline;
	}

	public void setpLostline(String pLostline) {
		this.pLostline = pLostline;
	}

	@Override
	public String toString() {
		return "Paramerta [pId=" + pId + ", pTimege=" + pTimege + ", pCspwd=" + pCspwd + ", pCsline=" + pCsline
				+ ", pXq=" + pXq + ", pDisk=" + pDisk + ", pLostline=" + pLostline + "]";
	}

  

   
}
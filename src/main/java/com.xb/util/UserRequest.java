package com.xb.util;

import com.xb.domain.User;

public class UserRequest extends User {

	private String userImgCode;
	
	private String sysImgCode;
	
	private int roleId;

	public String getUserImgCode() {
		return userImgCode;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void setUserImgCode(String userImgCode) {
		this.userImgCode = userImgCode;
	}

	public String getSysImgCode() {
		return sysImgCode;
	}

	public void setSysImgCode(String sysImgCode) {
		this.sysImgCode = sysImgCode;
	}
	

}

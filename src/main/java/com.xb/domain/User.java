package com.xb.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//**
//* 用户信息
//*/
public class User {
   // 成员变量
   private String userid;
   private String username;
   private String userpwd;
   private String usermobile;
   private String userImgCode;
   private String lift;
	//   用户状态
	//   1 正常
	//   2 锁定
	   private Integer userlock;
//	密保答案
//	   生日
	   private Date keyone;
//	   姓名
	   private String keytow;
//	   配偶
	   private String keytrhree;
	   private String keyoneStr;
	   private String checkImg;

   private Set<String> resources =new HashSet<String>();
   
   private Set<Role> roles =new HashSet<Role>();
   

public Integer getUserlock() {
	return userlock;
}
public void setUserlock(Integer userlock) {
	this.userlock = userlock;
}
public Date getKeyone() {
	return keyone;
}
public void setKeyone(Date keyone) {
	this.keyone = keyone;
}
public String getKeytow() {
	return keytow;
}
public void setKeytow(String keytow) {
	this.keytow = keytow;
}
public String getKeytrhree() {
	return keytrhree;
}
public void setKeytrhree(String keytrhree) {
	this.keytrhree = keytrhree;
}
public String getKeyoneStr() {
	return keyoneStr;
}
public void setKeyoneStr(String keyoneStr) {
	this.keyoneStr = keyoneStr;
}
public String getCheckImg() {
	return checkImg;
}
public void setCheckImg(String checkImg) {
	this.checkImg = checkImg;
}
public String getLift() {
	return lift;
}
public void setLift(String lift) {
	this.lift = lift;
}
public String getUserImgCode() {
	return userImgCode;
}
public void setUserImgCode(String userImgCode) {
	this.userImgCode = userImgCode;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserpwd() {
	return userpwd;
}
public void setUserpwd(String userpwd) {
	this.userpwd = userpwd;
}
public String getUsermobile() {
	return usermobile;
}
public void setUsermobile(String usermobile) {
	this.usermobile = usermobile;
}
public User(String userid, String username, String userpwd, String usermobile) {
	super();
	this.userid = userid;
	this.username = username;
	this.userpwd = userpwd;
	this.usermobile = usermobile;
}
public User() {
	super();
}
public Set<String> getResources() {
	return resources;
}
public void setResources(Set<String> resources) {
	this.resources = resources;
}
public Set<Role> getRoles() {
	return roles;
}
public void setRoles(Set<Role> roles) {
	this.roles = roles;
}
	
 	
}
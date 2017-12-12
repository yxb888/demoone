/** 
 * <pre>项目名称:ssm-ztree 
 * 文件名称:RolesList.java 
 * 包名:com.jk.model 
 * 创建日期:2017年11月28日下午4:01:40 
 * Copyright (c) 2017,yangpei310@163.com All Rights Reserved.</pre> 
 */  
package com.xb.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
 * <pre>项目名称：ssm-ztree    
 * 类名称：RolesList    
 * 类描述：    
 * 创建人：朱义龙    
 * 创建时间：2017年11月28日 下午4:01:40    
 * 修改人：朱义龙    
 * 修改时间：2017年11月28日 下午4:01:40    
 * 修改备注：       
 * @version </pre>    
 */
public class RolesList {

	
	private List<Role> list =new ArrayList<Role>(); 
	
	
	private Set<Role> roles =new HashSet<Role>();


	public List<Role> getList() {
		return list;
	}


	public void setList(List<Role> list) {
		this.list = list;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
}

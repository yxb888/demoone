/** 
 * <pre>项目名称:ssm-ztree 
 * 文件名称:RolesList.java 
 * 包名:com.jk.model 
 * 创建日期:2017年11月28日下午4:01:40 
 * Copyright (c) 2017,yangpei310@163.com All Rights Reserved.</pre> 
 */  
package com.xb.domain;

import java.util.*;

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
public class TreeList {

	
	private List<Map<String, Object>> list =new ArrayList<Map<String, Object>>(); 
	
	
	private Set<Permission> roles =new HashSet<Permission>();


	public List<Map<String, Object>> getList() {
		return list;
	}


	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}


	public Set<Permission> getRoles() {
		return roles;
	}


	public void setRoles(Set<Permission> roles) {
		this.roles = roles;
	}


	

	
	
}

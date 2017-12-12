/** 
 * <pre>项目名称:ssm-oa 
 * 文件名称:RoleServiceImpl.java 
 * 包名:com.xb.service.role.Impl 
 * 创建日期:2017年11月28日下午9:31:51 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.xb.service.role.Impl;

import com.xb.dao.role.RoleMapper;
import com.xb.domain.Role;
import com.xb.service.role.RoleService;
import com.xb.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * <pre>项目名称：ssm-oa    
 * 类名称：RoleServiceImpl    
 * 类描述：    
 * 创建人：杨兴北  
 * 创建时间：2017年11月28日 下午9:31:51    
 * 修改人：杨兴北  
 * 修改时间：2017年11月28日 下午9:31:51    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;

	/* (non-Javadoc)    
	 * @see com.xb.service.role.RoleService#selectRoleList()    
	 */
	@Override
	public List<Role> selectRoleList() {
		// TODO Auto-generated method stub
		return roleMapper.selectRoleList();
	}

	/* (non-Javadoc)    
	 * @see com.xb.service.role.RoleService#addUserRoleRelatio(java.lang.String, java.lang.String)    
	 */
	@Override
	public void addUserRoleRelatio(String s, String userid) {
		// TODO Auto-generated method stub
		roleMapper.deleteUserRoleRelation(userid);
		if(s!=null && !"".equals(s)){
			String[] ids =s.split(",");
			List<Map<String,String>> list =new ArrayList<Map<String,String>>();
			for (int i = 0; i < ids.length; i++) {
				Map<String,String> map =new HashMap<String,String>();
				map.put("userId", userid);
				map.put("roleId", ids[i].trim().toString());
				list.add(map);
			}
			roleMapper.addUserRoleRelation(list);
		}
	}

	/* (non-Javadoc)    
	 * @see com.xb.service.role.RoleService#queryRole(int, int)    
	 */
	@Override
	public Map<String, Object> queryRole(int page, int rows) {
//		总条数
		long total = roleMapper.queryTotal();
		 PageUtil<Role> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<Role> teas = roleMapper.PageList(pages.getStart(), pages.getEnd());
		
		 Map<String, Object> map = new HashMap<>();
		 
		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}
}

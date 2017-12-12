/** 
 * <pre>项目名称:ssm-oa 
 * 文件名称:RoleService.java 
 * 包名:com.xb.service.role 
 * 创建日期:2017年11月28日下午9:31:14 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.xb.service.role;

import com.xb.domain.Role;

import java.util.List;
import java.util.Map;

/** 
 * <pre>项目名称：ssm-oa    
 * 类名称：RoleService    
 * 类描述：    
 * 创建人：杨兴北  
 * 创建时间：2017年11月28日 下午9:31:14    
 * 修改人：杨兴北  
 * 修改时间：2017年11月28日 下午9:31:14    
 * 修改备注：       
 * @version </pre>    
 */
public interface RoleService {

	/** <pre>selectRoleList(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月28日 下午9:39:08    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月28日 下午9:39:08    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Role> selectRoleList();

	/** <pre>addUserRoleRelatio(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月29日 上午11:18:20    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月29日 上午11:18:20    
	 * 修改备注： 
	 * @param s
	 * @param id</pre>    
	 */
	void addUserRoleRelatio(String s, String id);

	/** <pre>queryRole(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月29日 下午2:31:21    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月29日 下午2:31:21    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @return</pre>    
	 */
	Map<String, Object> queryRole(int page, int rows);

}

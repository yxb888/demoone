package com.xb.service.tree;

import com.xb.domain.Menutree;
import com.xb.domain.Permission;
import com.xb.domain.Role;
import com.xb.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface TreeService {

	List<Menutree> queryTree();

	Role selectMenuList(String username);

	List<Map<String, Object>> selectMenuListDict();

	void deletetree(String idss);

	void updatetree(Permission permission);

	void addtree(Permission permission);

	List<Map<String, Object>> selectMenuLists(String parameter);

	/** <pre>selectTreeList(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月29日 下午4:56:34    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月29日 下午4:56:34    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Map<String, Object>> selectTreeList();

	/** <pre>findMenuByRoleId(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月29日 下午6:28:28    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月29日 下午6:28:28    
	 * 修改备注： 
	 * @param roleid
	 * @return</pre>    
	 */
	List<Map<String, Object>> findMenuByRoleId(String roleid);

	/** <pre>SaveByRoleId(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月29日 下午7:40:29    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月29日 下午7:40:29    
	 * 修改备注： 
	 * @param menuIds
	 * @param roleid
	 * @return</pre>    
	 */
	void SaveByRoleId(String menuIds, String roleid);

	/** <pre>getCurrenUserNodes(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月29日 下午8:28:16    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月29日 下午8:28:16    
	 * 修改备注： 
	 * @param user 
	 * @param left 
	 * @return</pre>    
	 */
	Set<Map<String, Object>> getCurrenUserNodes(User user, String left);

}

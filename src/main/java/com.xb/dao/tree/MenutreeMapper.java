package com.xb.dao.tree;

import com.xb.domain.Menutree;
import com.xb.domain.Permission;
import com.xb.domain.User;

import java.util.List;
import java.util.Map;


public interface MenutreeMapper {
    int insert(Menutree record);

    int insertSelective(Menutree record);

	List<Menutree> queryTree();

	List<Map<String, Object>> selectMenuList(String roleid);

	List<Map<String, Object>> selectMenuListDict();

	void deletetree(String idss);

	void updatetree(Permission permission);

	void addtree(Permission permission);

	List<Map<String, Object>> selectMenuLists(String parameter);

	/** <pre>selectTreeList(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月29日 下午4:57:21    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月29日 下午4:57:21    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Map<String, Object>> selectTreeList();

	/** <pre>deleteByrole(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月29日 下午7:41:26    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月29日 下午7:41:26    
	 * 修改备注： 
	 * @param roleid</pre>    
	 */
	void deleteByrole(String roleid);

	/** <pre>addRoleTreeRelation(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月29日 下午7:46:29    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月29日 下午7:46:29    
	 * 修改备注： 
	 * @param list</pre>    
	 */
	void addRoleTreeRelation(List<Map<String, String>> list);

	/** <pre>getCurrenUserNodes(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月29日 下午8:29:34    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月29日 下午8:29:34    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
	List<Map<String, Object>> getCurrenUserNodes(User user);
}
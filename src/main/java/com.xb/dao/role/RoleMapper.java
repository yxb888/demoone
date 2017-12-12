package com.xb.dao.role;

import com.xb.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    int deleteByPrimaryKey(String rId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String rId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

	/** <pre>selectRoleList(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月28日 下午9:39:34    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月28日 下午9:39:34    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Role> selectRoleList();

	/** <pre>deleteUserRoleRelation(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月29日 上午11:21:21    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月29日 上午11:21:21    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	void deleteUserRoleRelation(String id);

	/** <pre>addUserRoleRelation(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月29日 上午11:42:31    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月29日 上午11:42:31    
	 * 修改备注： 
	 * @param list</pre>    
	 */
	void addUserRoleRelation(List<Map<String, String>> list);

	/** <pre>queryTotal(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月29日 下午2:33:03    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月29日 下午2:33:03    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public long queryTotal();

	/** <pre>PageList(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月29日 下午2:33:07    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月29日 下午2:33:07    
	 * 修改备注： 
	 * @param start
	 * @param end
	 * @return</pre>    
	 */

	public List<Role> PageList(@Param("start") int start, @Param("end") int end);
}
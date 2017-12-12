package com.xb.dao.dict;

import com.xb.domain.Paramerta;

import java.util.List;
import java.util.Map;

public interface CestDao {

	/** <pre>selectByPrimaryKey(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月23日 上午11:43:16    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月23日 上午11:43:16    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public	List<Paramerta> selectByPrimaryKey();

	/** <pre>updateByPrimaryKeySelective(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月23日 下午2:17:28    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月23日 下午2:17:28    
	 * 修改备注： 
	 * @param paramert</pre>    
	 */
	public void updateByPrimaryKeySelective(Paramerta paramert);

	/** <pre>updateByPrimaryKeySelectivea(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月24日 下午7:20:01    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月24日 下午7:20:01    
	 * 修改备注： </pre>    
	 */
	public void updateByPrimaryKeySelectivea();

	/** <pre>getHeicharts(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年12月8日 下午5:33:15    
	 * 修改人：杨兴北 
	 * 修改时间：2017年12月8日 下午5:33:15    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public List<Map<String, Object>> getHeicharts();

	/** <pre>getHeichartsA(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年12月8日 下午8:18:55    
	 * 修改人：杨兴北 
	 * 修改时间：2017年12月8日 下午8:18:55    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public List<Map<String, Object>> getHeichartsA();

}

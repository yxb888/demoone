package com.xb.service.diqu;

import com.xb.domain.Diqu;

import java.util.List;
import java.util.Map;

public interface DiquService {

	

	void deleteAll(String[] tId);

	void addDiqu(Diqu dq);

	Map<String, Object> queryDiqu(int page, int rows, Diqu dq);

	/** <pre>queryById(这里用一句话描述这个方法的作用)   
	 * 创建人：梁飞
	 * 创建时间：2017年11月20日 下午6:38:57    
	 * 修改人：梁飞   
	 * 修改时间：2017年11月20日 下午6:38:57    
	 * 修改备注： 
	 * @param diqu
	 * @return</pre>    
	 */
	Diqu queryById(Diqu diqu);

	/** <pre>updDQSave(这里用一句话描述这个方法的作用)   
	 * 创建人：梁飞
	 * 创建时间：2017年11月20日 下午7:23:04    
	 * 修改人：梁飞   
	 * 修改时间：2017年11月20日 下午7:23:04    
	 * 修改备注： 
	 * @param diqu</pre>    
	 */
	void updateDQSave(Diqu diqu);

	/** <pre>retriveById(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月30日 下午8:41:27    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月30日 下午8:41:27    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Diqu> retriveById();

	

	

}

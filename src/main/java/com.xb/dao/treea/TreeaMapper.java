package com.xb.dao.treea;

import com.xb.domain.treea.Treea;

import java.util.List;

public interface TreeaMapper {

	/** <pre>queryTree(这里用一句话描述这个方法的作用)   
	 * 创建人：梁飞
	 * 创建时间：2017年11月17日 下午9:16:51    
	 * 修改人：梁飞   
	 * 修改时间：2017年11月17日 下午9:16:51    
	 * 修改备注： 
	 * @param treea
	 * @return</pre>    
	 */
	List<Treea> queryTreea(Treea treea)throws Exception;

	/** <pre>queryTreea2(这里用一句话描述这个方法的作用)   
	 * 创建人：梁飞
	 * 创建时间：2017年11月17日 下午10:25:54    
	 * 修改人：梁飞   
	 * 修改时间：2017年11月17日 下午10:25:54    
	 * 修改备注： 
	 * @param treea
	 * @return</pre>    
	 */
	List<Treea> queryTreea2(Treea treea)throws Exception;

}
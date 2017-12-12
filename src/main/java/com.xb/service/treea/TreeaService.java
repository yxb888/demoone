/** 
 * <pre>项目名称:ssm-oa 
 * 文件名称:TreeaService.java 
 * 包名:com.xb.service.treea 
 * 创建日期:2017年11月17日下午8:57:00 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.xb.service.treea;

import com.xb.domain.treea.Treea;

import java.util.List;

public interface TreeaService {

	

	/** <pre>queryTreea(这里用一句话描述这个方法的作用)   
	 * 创建人：梁飞
	 * 创建时间：2017年11月17日 下午9:58:04    
	 * 修改人：梁飞   
	 * 修改时间：2017年11月17日 下午9:58:04    
	 * 修改备注： 
	 * @param treea
	 * @return</pre>    
	 */
	List<Treea> queryTreea(Treea treea)throws Exception;

	/** <pre>queryTreea2(这里用一句话描述这个方法的作用)   
	 * 创建人：梁飞
	 * 创建时间：2017年11月17日 下午10:20:45    
	 * 修改人：梁飞   
	 * 修改时间：2017年11月17日 下午10:20:45    
	 * 修改备注： 
	 * @param treea
	 * @return</pre>    
	 */
	List<Treea> queryTreea2(Treea treea)throws Exception;



}

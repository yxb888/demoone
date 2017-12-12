/** 
 * <pre>项目名称:ssm-oa 
 * 文件名称:ZhishiService.java 
 * 包名:com.xb.service.ziyuanzhishi 
 * 创建日期:2017年11月23日上午8:37:49 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.xb.service.ziyuanzhishi;

import com.xb.domain.ziyuanzhishi;
import com.xb.domain.ziyuanzhishitype;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/** 
 * <pre>项目名称：ssm-oa    
 * 类名称：ZhishiService    
 * 类描述：    
 * 创建人：梁飞
 * 创建时间：2017年11月23日 上午8:37:49    
 * 修改人：梁飞 
 * 修改时间：2017年11月23日 上午8:37:49    
 * 修改备注：       
 * @version </pre>    
 */
public interface ZhishiService {
	/** <pre>queryaddress(导出)   
    
	 */
	List<ziyuanzhishi> queryaddress(HttpServletResponse response, ziyuanzhishi zs);
	/** <pre>queryZhishi(查询+分页)   
   
	 */
	Map<String, Object> queryZhishi(int page, int rows, ziyuanzhishi zs);

	/** <pre>queryZhishi(类型查询+分页)  */
	Map<String, Object> queryZhishiType(int page, int rows, ziyuanzhishitype zstp);
	/** <pre>addType(这里用一句话描述这个方法的作用)   
	 * 创建人：梁飞
	 * 创建时间：2017年11月30日 下午8:18:53    
	 * 修改人：梁飞   
	 * 修改时间：2017年11月30日 下午8:18:53    
	 * 修改备注： 
	 * @param tp</pre>    
	 */
	void addType(ziyuanzhishitype tp);

}

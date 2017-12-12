/** 
 * <pre>项目名称:ssm-oa 
 * 文件名称:PictureService.java 
 * 包名:com.xb.service.dict 
 * 创建日期:2017年11月24日下午8:37:08 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.xb.service.dict;

import com.xb.domain.Picture;

import java.util.Map;

/** 
 * <pre>项目名称：ssm-oa    
 * 类名称：PictureService    
 * 类描述：    
 * 创建人：杨兴北  
 * 创建时间：2017年11月24日 下午8:37:08    
 * 修改人：杨兴北  
 * 修改时间：2017年11月24日 下午8:37:08    
 * 修改备注：       
 * @version </pre>    
 */
public interface PictureService {

	/** <pre>insertSelective(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月24日 下午8:47:05    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月24日 下午8:47:05    
	 * 修改备注： 
	 * @param p</pre>    
	 */
	void insertSelective(Picture p);

	/** <pre>queryPicture(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年12月1日 下午7:45:50    
	 * 修改人：杨兴北 
	 * 修改时间：2017年12月1日 下午7:45:50    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @return</pre>    
	 */
	Map<String, Object> queryPicture(int page, int rows);

}

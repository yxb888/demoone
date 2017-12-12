/** 
 * <pre>项目名称:ssm-oa 
 * 文件名称:AopTreeService.java 
 * 包名:com.xb.service.aop 
 * 创建日期:2017年11月29日下午7:09:27 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.xb.service.aop;

import com.xb.domain.AopTree;

import java.util.List;

/** 
 * <pre>项目名称：ssm-oa    
 * 类名称：AopTreeService    
 * 类描述：    
 * 创建人：张万利
 * 创建时间：2017年11月29日 下午7:09:27    
 * 修改人： 张万利  
 * 修改时间：2017年11月29日 下午7:09:27    
 * 修改备注：       
 * @version </pre>    
 */
public interface AopTreeService {

	/** <pre>queryTree(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月29日 下午7:10:19    
	 * 修改人：张万利  
	 * 修改时间：2017年11月29日 下午7:10:19    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<AopTree> queryTree();

}

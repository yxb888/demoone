package com.xb.dao.aop;

import com.xb.domain.AopTree;

import java.util.List;

public interface AopTreeMapper {
    int insert(AopTree record);

    int insertSelective(AopTree record);

	/** <pre>queryTree(这里用一句话描述这个方法的作用)   .
	 * 创建人：张万利
	 * 创建时间：2017年11月29日 下午7:20:52    
	 * 修改人：张万利  
	 * 修改时间：2017年11月29日 下午7:20:52    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<AopTree> queryTree();
}
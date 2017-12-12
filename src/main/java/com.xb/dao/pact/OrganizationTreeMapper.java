package com.xb.dao.pact;

import com.xb.domain.OrganizationTree;

import java.util.List;

public interface OrganizationTreeMapper {
    int insert(OrganizationTree record);

    int insertSelective(OrganizationTree record);

	List<OrganizationTree> queryPactTree();

	/** <pre>queryBms(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月24日 下午5:14:01    
	 * 修改人：张万利  
	 * 修改时间：2017年11月24日 下午5:14:01    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<OrganizationTree> queryBms();
}
package com.xb.dao.pact;

import com.xb.domain.Emps;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpsMapper {
    int insert(Emps record);

    int insertSelective(Emps record);

	long queryOrgscount(Emps emps);

	List<Emps> queryOrgsPage(@Param(value = "start") int start, @Param(value = "rows") int rows, @Param(value = "emps") Emps emps);

	/** <pre>queryEmps(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月24日 下午6:42:34    
	 * 修改人：张万利  
	 * 修改时间：2017年11月24日 下午6:42:34    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Emps> queryEmps();


}
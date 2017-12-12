package com.xb.dao.table;

import com.xb.domain.Table;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TableMapper {
    int deleteByPrimaryKey(Integer tableid);

    int insert(Table record);

    int insertSelective(Table record);

    Table selectByPrimaryKey(Integer tableid);

    int updateByPrimaryKeySelective(Table record);

    int updateByPrimaryKey(Table record);

	/** <pre>queryTablescount(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月23日 上午11:01:17    
	 * 修改人：张万利  
	 * 修改时间：2017年11月23日 上午11:01:17    
	 * 修改备注： 
	 * @param tables
	 * @return</pre>    
	 */
	long queryTablescount(Table tables);

	/** <pre>queryTables(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月23日 上午11:01:23    
	 * 修改人：张万利  
	 * 修改时间：2017年11月23日 上午11:01:23    
	 * 修改备注： 
	 * @param start
	 * @param rows
	 * @param tables
	 * @return</pre>    
	 */
	List<Table> queryTables(@Param(value = "start") int start, @Param(value = "rows") int rows, @Param(value = "tables") Table tables);

	/** <pre>deleteTable(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月23日 下午1:42:29    
	 * 修改人：张万利  
	 * 修改时间：2017年11月23日 下午1:42:29    
	 * 修改备注： 
	 * @param tableid</pre>    
	 */
	void deleteTable(Integer tableid);

	/** <pre>deleteAll(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月24日 下午2:16:38    
	 * 修改人：张万利  
	 * 修改时间：2017年11月24日 下午2:16:38    
	 * 修改备注： 
	 * @param tableid</pre>    
	 */
	void deleteAll(String[] tableid);

	/** <pre>queryType(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月23日 下午2:34:08    
	 * 修改人：张万利  
	 * 修改时间：2017年11月23日 下午2:34:08    
	 * 修改备注： 
	 * @return</pre>    
	 */
	
}
package com.xb.dao.table;

import com.xb.domain.TableType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TableTypeMapper {
    int insert(TableType record);

    int insertSelective(TableType record);

	/** <pre>queryType(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月23日 下午2:46:23    
	 * 修改人：张万利  
	 * 修改时间：2017年11月23日 下午2:46:23    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<TableType> queryType();

	/** <pre>queryTablesTypecount(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月24日 下午2:41:31    
	 * 修改人：张万利  
	 * 修改时间：2017年11月24日 下午2:41:31    
	 * 修改备注： 
	 * @param tabletype
	 * @return</pre>    
	 */
	long queryTablesTypecount(TableType tabletype);

	/** <pre>queryTablesType(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月24日 下午2:41:45    
	 * 修改人：张万利  
	 * 修改时间：2017年11月24日 下午2:41:45    
	 * 修改备注： 
	 * @param start
	 * @param rows
	 * @param tabletype
	 * @return</pre>    
	 */
	List<TableType> queryTablesType(@Param(value = "start") int start, @Param(value = "rows") int rows, @Param(value = "tabletype") TableType tabletype);

	/** <pre>deleteTableType(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月24日 下午8:51:52    
	 * 修改人：张万利  
	 * 修改时间：2017年11月24日 下午8:51:52    
	 * 修改备注： 
	 * @param tabletypeid</pre>    
	 */
	void deleteTableType(Integer tabletypeid);

	/** <pre>deleteTableTypeAll(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月24日 下午9:02:54    
	 * 修改人：张万利  
	 * 修改时间：2017年11月24日 下午9:02:54    
	 * 修改备注： 
	 * @param tabletypeid</pre>    
	 */
	void deleteTableTypeAll(String[] tabletypeid);

	/** <pre>addTableType(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月27日 上午11:52:40    
	 * 修改人：张万利  
	 * 修改时间：2017年11月27日 上午11:52:40    
	 * 修改备注： 
	 * @param tableType</pre>    
	 */
	void addTableType(TableType tableType);

}
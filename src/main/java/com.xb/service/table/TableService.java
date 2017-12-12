package com.xb.service.table;

import com.xb.domain.Emps;
import com.xb.domain.OrganizationTree;
import com.xb.domain.Table;
import com.xb.domain.TableType;

import java.util.List;
import java.util.Map;

public interface TableService {

	/** <pre>queryTables(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月23日 上午10:57:54    
	 * 修改人：张万利  
	 * 修改时间：2017年11月23日 上午10:57:54    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @param tables
	 * @return</pre>    
	 */
	Map<String, Object> queryTables(int page, int rows, Table tables);

	/** <pre>deleteTable(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月23日 下午1:39:48    
	 * 修改人：张万利  
	 * 修改时间：2017年11月23日 下午1:39:48    
	 * 修改备注： 
	 * @param tableid
	 * @return</pre>    
	 */
	String deleteTable(Integer tableid);

	/** <pre>queryType(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月23日 下午2:33:43    
	 * 修改人：张万利  
	 * 修改时间：2017年11月23日 下午2:33:43    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<TableType> queryType();

	/** <pre>deleteAll(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月24日 下午2:14:44    
	 * 修改人：张万利  
	 * 修改时间：2017年11月24日 下午2:14:44    
	 * 修改备注： 
	 * @param tableid</pre>    
	 */
	void deleteAll(String[] tableid);

	/** <pre>queryTablesType(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月24日 下午2:39:09    
	 * 修改人：张万利  
	 * 修改时间：2017年11月24日 下午2:39:09    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @param tabletype
	 * @return</pre>    
	 */
	Map<String, Object> queryTablesType(int page, int rows, TableType tabletype);

	/** <pre>queryBms(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月24日 下午5:12:49    
	 * 修改人：张万利  
	 * 修改时间：2017年11月24日 下午5:12:49    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<OrganizationTree> queryBms();

	/** <pre>queryEmps(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月24日 下午6:41:46    
	 * 修改人：张万利  
	 * 修改时间：2017年11月24日 下午6:41:46    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Emps> queryEmps();

	/** <pre>deleteTableType(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月24日 下午8:49:35    
	 * 修改人：张万利  
	 * 修改时间：2017年11月24日 下午8:49:35    
	 * 修改备注： 
	 * @param tabletypeid
	 * @return</pre>    
	 */
	String deleteTableType(Integer tabletypeid);

	/** <pre>deleteTableTypeAll(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月24日 下午9:00:43    
	 * 修改人：张万利  
	 * 修改时间：2017年11月24日 下午9:00:43    
	 * 修改备注： 
	 * @param tabletypeid</pre>    
	 */
	void deleteTableTypeAll(String[] tabletypeid);

	/** <pre>addTableType(这里用一句话描述这个方法的作用)   
	 * 创建人：张万利
	 * 创建时间：2017年11月27日 上午11:51:39    
	 * 修改人：张万利  
	 * 修改时间：2017年11月27日 上午11:51:39    
	 * 修改备注： 
	 * @param tableType
	 * @return</pre>    
	 */
	String addTableType(TableType tableType);

}

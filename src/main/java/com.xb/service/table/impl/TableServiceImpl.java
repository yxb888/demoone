package com.xb.service.table.impl;

import com.xb.dao.pact.EmpsMapper;
import com.xb.dao.pact.OrganizationTreeMapper;
import com.xb.dao.table.TableMapper;
import com.xb.dao.table.TableTypeMapper;
import com.xb.domain.Emps;
import com.xb.domain.OrganizationTree;
import com.xb.domain.Table;
import com.xb.domain.TableType;
import com.xb.service.table.TableService;
import com.xb.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TableServiceImpl implements TableService {
		@Autowired
		private TableMapper tableMapper;
		@Autowired
		private TableTypeMapper tableTypeMapper;
		@Autowired
		private OrganizationTreeMapper orgMapper;
		@Autowired
		private EmpsMapper empsMapper;

		/* (non-Javadoc)    
		 * @see com.xb.service.table.TableService#queryTables(int, int, com.xb.domain.Table)    
		 */
		@Override
		public Map<String, Object> queryTables(int page, int rows, Table tables) {
			//总条数
			long total = tableMapper.queryTablescount(tables);
			 PageUtil<Table> pages = new PageUtil<>(page, total, rows);
//			 当前页数据
			 List<Table> teas = tableMapper.queryTables(pages.getStart(),rows,tables);
			 SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			 for (int i = 0; i < teas.size(); i++) {
				 String times=sdf.format(teas.get(i).getCreatetime());
			 		teas.get(i).setCreatetimeStr(times);
			 }
			 		
			 Map<String, Object> map = new HashMap<>();
			 
			 map.put("total", total);
			 map.put("rows", teas);
			 return map;
		}

		/* (non-Javadoc)    
		 * @see com.xb.service.table.TableService#deleteTable(java.lang.Integer)    
		 */
		@Override
		public String deleteTable(Integer tableid) {
			tableMapper.deleteTable(tableid);
			return "1";
		}

		/* (non-Javadoc)    
		 * @see com.xb.service.table.TableService#queryType()    
		 */
//		@Override
//		public TableType queryType() {
//			// TODO Auto-generated method stub
//			return tableTypeMapper.queryType();
//		}

		/* (non-Javadoc)    
		 * @see com.xb.service.table.TableService#queryType()    
		 */
		@Override
		public List<TableType> queryType() {
			
			return tableTypeMapper.queryType();
		}

		/* (non-Javadoc)    
		 * @see com.xb.service.table.TableService#deleteAll(java.lang.String[])    
		 */
		@Override
		public void deleteAll(String[] tableid) {
			tableMapper.deleteAll(tableid);
		}

		/* (non-Javadoc)    
		 * @see com.xb.service.table.TableService#queryTablesType(int, int, com.xb.domain.TableType)    
		 */
		@Override
		public Map<String, Object> queryTablesType(int page, int rows, TableType tabletype) {
			//总条数
			long total = tableTypeMapper.queryTablesTypecount(tabletype);
			 PageUtil<TableType> pages = new PageUtil<>(page, total, rows);
//			 当前页数据
			 List<TableType> teas = tableTypeMapper.queryTablesType(pages.getStart(),rows,tabletype);
//			 SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
//			 for (int i = 0; i < teas.size(); i++) {
//				 String times=sdf.format(teas.get(i).getCreatetime());
//			 		teas.get(i).setCreatetimeStr(times);
//			 }
//			 		
			 Map<String, Object> map = new HashMap<>();
			 
			 map.put("total", total);
			 map.put("rows", teas);
			 return map;
		
		}

		/* (non-Javadoc)    
		 * @see com.xb.service.table.TableService#queryBms()    
		 */
		@Override
		public List<OrganizationTree> queryBms() {
			return orgMapper.queryBms();
		}

		/* (non-Javadoc)    
		 * @see com.xb.service.table.TableService#queryEmps()    
		 */
		@Override
		public List<Emps> queryEmps() {
			return empsMapper.queryEmps();
		}

		/* (non-Javadoc)    
		 * @see com.xb.service.table.TableService#deleteTableType(java.lang.Integer)    
		 */
		@Override
		public String deleteTableType(Integer tabletypeid) {
			tableTypeMapper.deleteTableType(tabletypeid);
			return "1";
		}

		/* (non-Javadoc)    
		 * @see com.xb.service.table.TableService#deleteTableTypeAll(java.lang.String[])    
		 */
		@Override
		public void deleteTableTypeAll(String[] tabletypeid) {
			
			tableTypeMapper.deleteTableTypeAll(tabletypeid);
		}

		/* (non-Javadoc)    
		 * @see com.xb.service.table.TableService#addTableType(com.xb.domain.TableType)    
		 */
		@Override
		public String addTableType(TableType tableType) {
			tableTypeMapper.addTableType(tableType);
			return "1";
		}
}

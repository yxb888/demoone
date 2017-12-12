package com.xb.service.diqu.impl;

import com.xb.dao.diqu.DiquMapper;
import com.xb.domain.Diqu;
import com.xb.domain.User;
import com.xb.service.diqu.DiquService;
import com.xb.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DiquServiceImpl implements DiquService {
	 @Autowired
	    private DiquMapper diquMapper;

	@Override
	public Map<String, Object> queryDiqu(int page, int rows, Diqu dq) {
//		总条数
		long total = diquMapper.queryTotal(dq);
		 PageUtil<User> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<User> teas = diquMapper.PageList(pages.getStart(), pages.getEnd(),dq);
		
		 Map<String, Object> map = new HashMap<>();
		 
		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}

	@Override
	public void deleteAll(String[] tId) {
//		 TODO Auto-generated method stub
		diquMapper.deleteAll(tId);	
	}
	//新增
	@Override
	public void addDiqu(Diqu dq) {
		// TODO Auto-generated method stub
		diquMapper.addDiqu(dq);
		
	}

	/* (non-Javadoc)    
	 * @see com.xb.service.diqu.DiquService#queryById(com.xb.domain.Diqu)    
	 */
	//修改 查询
	@Override
	public Diqu queryById(Diqu diqu) {
		return diquMapper.queryById(diqu);
	}

	/* (non-Javadoc)    
	 * @see com.xb.service.diqu.DiquService#updDQSave(com.xb.domain.Diqu)    
	 */
	//修改
	@Override
	public void updateDQSave(Diqu diqu) {
		diquMapper.updateDQSave(diqu);
		
	}

	/* (non-Javadoc)    
	 * @see com.xb.service.diqu.DiquService#retriveById(com.xb.domain.Diqu)    
	 */
	@Override
	public List<Diqu> retriveById() {
		// TODO Auto-generated method stub
		
		return  diquMapper.retriveById();
	}


	
	
	 
	 
}

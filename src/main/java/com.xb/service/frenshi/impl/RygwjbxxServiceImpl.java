package com.xb.service.frenshi.impl;

import com.xb.dao.frenshi.RygwjbxxMapper;
import com.xb.domain.Rygwjbxx;
import com.xb.service.frenshi.RygwjbxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RygwjbxxServiceImpl implements RygwjbxxService {
	
	@Autowired
	private RygwjbxxMapper rygwjbxxMapper;
	
	@Override
	public Map<String, Object> queryRygwjbxx(int page,int rows,Rygwjbxx rygwjbxx) {
		System.out.println(rygwjbxx.getRyName()+"88888888888888");
//	  	总条数
		long total = rygwjbxxMapper.queryRygwjbxxTotal(rygwjbxx);
		System.out.println("历次"+total);
//		分页
		int start = (page - 1) * rows;
////		PageUtil<Rygwjbxx> pageUtil = new PageUtil<Rygwjbxx>(page, total, rows);
		List<Rygwjbxx> list = rygwjbxxMapper.queryRygwjbxxPage(start,rows,rygwjbxx);
//		
		 Map<String, Object> map = new HashMap<>();
		 map.put("total", total);
		 map.put("rows", list);
		return map;
	}

	

	/* (non-Javadoc)
	 * @see com.xb.service.frenshi.RygwjbxxService#deleteRygwjbxx(java.lang.String[])
	 */
	@Override
	public void deleteRygwjbxx(String[] id)  {
		rygwjbxxMapper.deleteRygwjbxx(id);
		
	}



	/* (non-Javadoc)
	 * @see com.xb.service.frenshi.RygwjbxxService#toUpdateRsgw(java.lang.String)
	 */
	@Override
	public Rygwjbxx queryUpdateRsgw(String ryId) {
		
		return rygwjbxxMapper.queryUpdateRsgw(ryId);
	}



	/* (non-Javadoc)
	 * @see com.xb.service.frenshi.RygwjbxxService#updateRsgw(com.xb.domain.Rygwjbxx)
	 */
	@Override
	public void updateRsgw(Rygwjbxx rygwjbxx) {

		rygwjbxxMapper.updateRsgw(rygwjbxx);
	}



	
}

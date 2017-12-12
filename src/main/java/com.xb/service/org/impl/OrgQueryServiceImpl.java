package com.xb.service.org.impl;

import com.xb.dao.org.OrgListMapper;
import com.xb.domain.OrgList;
import com.xb.service.org.OrgQueryService;
import com.xb.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrgQueryServiceImpl implements OrgQueryService {

	@Autowired
	private OrgListMapper orgListMapper;

	@Override
	public Map<String, Object> queryOrgPage(int page, int rows,OrgList orglist) {
//		总条数
		long total = orgListMapper.queryTotal(orglist);
		 PageUtil<OrgList> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<OrgList> teas = orgListMapper.PageList(pages.getStart(), pages.getEnd(),orglist);
		
		 Map<String, Object> map = new HashMap<>();
		 
		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}
	
	@Override
	public Map<String, Object> queryOrgManPage(int page, int rows, OrgList orglist) {
//		总条数
		long total = orgListMapper.queryTotal(orglist);
		 PageUtil<OrgList> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<OrgList> teas = orgListMapper.PageList(pages.getStart(), pages.getEnd(),orglist);
		
		 Map<String, Object> map = new HashMap<>();
		 
		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}

	@Override
	public void deleteAll(String idStr) {
		orgListMapper.deleteAll(idStr.split(","));
		
	}

	@Override
	public void deleteAllOrg(String[] tId) {
		orgListMapper.deleteAllOrg(tId);
	}

	@Override
	public void addOrg(OrgList orgObj) {
		orgListMapper.addOrg(orgObj);
		
	}


}
	

package com.xb.service.pact.impl;

import com.xb.dao.pact.*;
import com.xb.domain.Emps;
import com.xb.domain.OrganizationTree;
import com.xb.domain.Pact;
import com.xb.domain.PactType;
import com.xb.service.pact.PactService;
import com.xb.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PactServiceImpl implements PactService {
	@Autowired
	private PactMapper pactMapper;
	@Autowired
	private OrganizationTreeMapper orgMapper;
	@Autowired
	private TryJbxxMapper trymapper;
	@Autowired
	private EmpsMapper empsMapper;
	@Autowired
	private PactTypeMapper pactTypeMapper;
	
	
	@Override
	public Map<String, Object> queryPact(int page, int rows, Pact pact) {
		//总条数
		long total = pactMapper.queryPactcount(pact);
		 PageUtil<Pact> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<Pact> teas = pactMapper.queryPact(pages.getStart(),rows,pact);
		 		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 		 for (int i = 0; i < teas.size(); i++) {
		 			 String  endtime= formatter.format(teas.get(i).getEndtime());
			         String staTime = formatter.format(teas.get(i).getStarttime());
			         teas.get(i).setEndtimeStr(endtime);
			         teas.get(i).setStarttimeStr(staTime);
				}
		 Map<String, Object> map = new HashMap<>();
		 
		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}

	@Override
	public String deletePact(String pactid) {
		
		pactMapper.deletePact(pactid);
		return "1";
	}

	@Override
	public List<OrganizationTree> queryPactTree() {
		
		return orgMapper.queryPactTree();
	}

	@Override
	public Map<String, Object> queryOrgsPage(int page, int rows,Emps emps) {
		//总条数
		long total = empsMapper.queryOrgscount(emps);
		 PageUtil<Emps> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<Emps> teas = empsMapper.queryOrgsPage(pages.getStart(),rows,emps);
		
		 Map<String, Object> map = new HashMap<>();
		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}

	@Override
	public String addPact(Pact pact) {
		pactMapper.addPact(pact);
		return "1";
	}

	@Override
	public void deleteAll(String[] pactid) {
		pactMapper.deleteAll(pactid);
	}

	@Override
	public Map<String, Object> queryPactType(int page, int rows) {
		//总条数
		long total = pactTypeMapper.queryPactTypecount();
		 PageUtil<PactType> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<PactType> teas = pactTypeMapper.queryPactType(pages.getStart(),rows);
		
		 Map<String, Object> map = new HashMap<>();
		 
		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}

	@Override
	public String deletePactType(String pacttypeid) {
		pactTypeMapper.deletePactType(pacttypeid);
		//删除成功返回
		return "2";
	}

	@Override
	public void deletePactTypeAll(String[] pacttypeid) {
		pactTypeMapper.deletePactTypeAll(pacttypeid);
	}

	@Override
	public Pact queryById(Pact pact) {
		return pactMapper.queryById(pact);
	}

	@Override
	public void updatePactType(Pact pact) {
		pactMapper.updatePactType(pact);
		
	}

	@Override
	public List<Pact> queryPacts(HttpServletResponse response, Pact pact) {
		
		return pactMapper.queryPacts(pact);
	}
}

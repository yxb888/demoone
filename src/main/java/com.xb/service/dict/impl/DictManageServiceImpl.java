package com.xb.service.dict.impl;

import com.xb.dao.dict.DictManageDao;
import com.xb.domain.Dict;
import com.xb.domain.DictTree;
import com.xb.service.dict.DictManageService;
import com.xb.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DictManageServiceImpl implements DictManageService {
	@Autowired
	private DictManageDao dictManageDao;

	@Override
	public Map<String, Object> DictManageAction_selectdictlist(int page, int rows, Dict dict) {
//		总条数
		String dictCode = dict.getDictCode();
		long total = dictManageDao.queryTotal(dict);
		 PageUtil<Dict> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<Dict> teas = dictManageDao.PageList(pages.getStart(), pages.getEnd(),dict);
		
		 Map<String, Object> map = new HashMap<>();
		 
		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}

	@Override
	public void deleteDictlist(String[] dictId) {
		dictManageDao.deleteDictlist(dictId);
		
	}

	@Override
	public Map<String, Object> DictManageAction_selectdictlistst(int page, int rows) {
//		总条数
		long total = dictManageDao.queryTotall();
		 PageUtil<Dict> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<Dict> teas = dictManageDao.PageListt(pages.getStart(), pages.getEnd());
		
		 Map<String, Object> map = new HashMap<>();
		 
		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}
//新增
	@Override
	public void dictAdd(DictTree dicttree) {
		// TODO Auto-generated method stub
		dictManageDao.dictAdd(dicttree);
		
	}

	@Override
	public void dictAdddict(Dict dict) {
		// TODO Auto-generated method stub
		dictManageDao.dictAdddict(dict);
		
		
	}

	
	@Override
	public List<Dict> selectupdate(Dict dict) {
		// TODO Auto-generated method stub
		List<Dict> teas=dictManageDao.selectupdate(dict);
 Map<String, Object> map = new HashMap<>();
		 
		 map.put("rows", teas);
		return teas;
	}

	@Override
	public void dictupdate(DictTree dicttree) {
		// TODO Auto-generated method stub
		dictManageDao.dictupdate(dicttree);
		
	}

	@Override
	public void dictupdatedict(Dict dict) {
		// TODO Auto-generated method stub
		dictManageDao.dictupdatedict(dict);
	}

	@Override
	public List<DictTree> queryDictTree() {
		// TODO Auto-generated method stub
		
		return dictManageDao.queryDictTree();
	}

	

}

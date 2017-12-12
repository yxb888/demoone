package com.xb.service.dict;

import com.xb.domain.Dict;
import com.xb.domain.DictTree;

import java.util.List;
import java.util.Map;

public interface DictManageService {

	Map<String, Object> DictManageAction_selectdictlist(int page, int rows, Dict dict);


	void deleteDictlist(String[] dictId);


	Map<String, Object> DictManageAction_selectdictlistst(int page, int rows);


	void dictAdd(DictTree dicttree);


	void dictAdddict(Dict dict);


	List<Dict> selectupdate(Dict dict);


	void dictupdate(DictTree dicttree);


	void dictupdatedict(Dict dict);


	List<DictTree> queryDictTree();





}

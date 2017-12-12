package com.xb.dao.dict;

import com.xb.domain.Dict;
import com.xb.domain.DictTree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictManageDao {

	public long queryTotal(Dict dict);

	public List<Dict> PageList(@Param("start") int start, @Param("end") int end, @Param("dict") Dict dict);

	public void deleteDictlist(String[] dictId);

	public long queryTotall();

	public List<Dict> PageListt(@Param("start") int start, @Param("end") int end);

	public void dictAdd(DictTree dicttree);

	public void dictAdddict(Dict dict);

	public List<Dict> selectupdate(Dict dict);

	public void dictupdate(DictTree dicttree);

	public void dictupdatedict(Dict dict);

	public List<DictTree> queryDictTree();

}

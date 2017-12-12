package com.xb.dao.frenshi;

import com.xb.domain.Rygwtree;
import com.xb.domain.Rygwzutree;

import java.util.List;
import java.util.Map;

public interface RygwzutreeMapper {

	List<Rygwzutree> queryRygwzutree();

	List<Rygwtree> queryZuTreeOnse(String id);

	List<Map<String, Object>> getAllGroupAsTree(String valueOf);

	List<Rygwtree> getAllOrgsTree(String id);


}
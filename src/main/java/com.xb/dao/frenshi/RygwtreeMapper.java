package com.xb.dao.frenshi;

import com.xb.domain.Rygwtree;

import java.util.List;

public interface RygwtreeMapper {
    
	List<Rygwtree> queryZuTree();

	List<Rygwtree> queryZuTreeOnse(String id);

	List<Rygwtree> getAllGroupAsTree(String valueOf);
//aaaa
	List<Rygwtree> getAllOrgsTree(String id);
}
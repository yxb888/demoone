package com.xb.dao.workObj;

import com.xb.domain.WorkTree;

import java.util.List;

public interface WorkTreeMapper {
    int insert(WorkTree record);

    int insertSelective(WorkTree record);

	List<WorkTree> queryTree();
}
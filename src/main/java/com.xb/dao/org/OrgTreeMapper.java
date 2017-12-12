package com.xb.dao.org;

import com.xb.domain.OrgTree;

import java.util.List;

public interface OrgTreeMapper {
    int insert(OrgTree record);

    int insertSelective(OrgTree record);

	List<OrgTree> queryTree();

}
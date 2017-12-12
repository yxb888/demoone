package com.xb.service.org.impl;

import com.xb.dao.org.OrgListMapper;
import com.xb.dao.org.OrgTreeMapper;
import com.xb.domain.OrgTree;
import com.xb.service.org.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {

	@Autowired
	private OrgTreeMapper orgTreeMapper;
	private OrgListMapper orgListMapper;

	@Override
	public List<OrgTree> queryTree() {
		return orgTreeMapper.queryTree();
	}


	
}

package com.xb.service.workObj.impl;

import com.xb.dao.workObj.WorkTreeMapper;
import com.xb.domain.WorkTree;
import com.xb.service.workObj.WorkTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTreeServiceImpl implements WorkTreeService {

	@Autowired
	private WorkTreeMapper workTreeMapper;

	@Override
	public List<WorkTree> queryTree() {
		return workTreeMapper.queryTree();
	}
	
}

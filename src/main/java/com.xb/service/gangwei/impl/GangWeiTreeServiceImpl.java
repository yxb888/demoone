package com.xb.service.gangwei.impl;

import com.xb.dao.gangwei.GangWeiMapper;
import com.xb.service.gangwei.GangWeiTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GangWeiTreeServiceImpl implements GangWeiTreeService {

	@Autowired
	private GangWeiMapper gangWeiMapper;
}

package com.xb.service.workObj;

import com.xb.domain.WorkEvection;

import java.util.Map;

public interface WorkEvectionService {

	Map<String, Object> queryWorkEvectionPage(int page, int rows) throws Exception;

	WorkEvection queryWorkEvectionById(WorkEvection workEvection) throws Exception;

	void deleteWorkEvectionAll(String[] tId);

}

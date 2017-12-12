package com.xb.service.workObj;

import com.xb.domain.WorkObj;

import java.util.Map;

public interface WorkObjservice {

	Map<String, Object> queryOrgManPage(int page, int rows) throws Exception;

	WorkObj queryById(WorkObj workObj) throws Exception;

	void deleteLeaveAll(String[] tId);

}

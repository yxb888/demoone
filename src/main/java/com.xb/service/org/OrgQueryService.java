package com.xb.service.org;

import com.xb.domain.OrgList;

import java.util.Map;

public interface OrgQueryService {

	Map<String, Object> queryOrgPage(int page, int rows, OrgList orglist);

	void deleteAll(String idStr);

	void deleteAllOrg(String[] tId);

	void addOrg(OrgList orgObj);

	Map<String, Object> queryOrgManPage(int page, int rows, OrgList orglist);
}

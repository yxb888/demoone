package com.xb.service.gangwei;

import com.xb.domain.GangWei;

import java.util.Map;

public interface GangWeiService {


	Map<String, Object> selectGangWei(int page, int rows);

	boolean delAllGangWei(String ids);

	void addGangWei(GangWei gw);

	GangWei queryGangWei(GangWei gw);

	void updateDQSave(GangWei gw);

}

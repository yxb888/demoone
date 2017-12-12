package com.xb.service.frenshi;

import com.xb.domain.Rygwjbxx;

import java.util.Map;

public interface RygwjbxxService {

	Map<String, Object> queryRygwjbxx(int page, int rows, Rygwjbxx rygwjbxx);

	/**
	 * @param id
	 */
	void deleteRygwjbxx(String[] id);


	/**
	 * @param ryId
	 * @return
	 */
	Rygwjbxx queryUpdateRsgw(String ryId);

	/**
	 * @param rygwjbxx
	 */
	void updateRsgw(Rygwjbxx rygwjbxx);

	/**
	 * @param rygwjbxx
	 */

}

package com.xb.dao.frenshi;

import com.xb.domain.Rygwjbxx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RygwjbxxMapper {

	long queryRygwjbxxTotal(@Param("rygwjbxx") Rygwjbxx rygwjbxx);

	List<Rygwjbxx> queryRygwjbxxPage(@Param("start") int start, @Param("rows") int rows, @Param("rygwjbxx") Rygwjbxx rygwjbxx);

	
	/**
	 * @param id
	 */
	void deleteRygwjbxx(String[] id) ;

	/**
	 * @param ryId
	 * @return
	 */
	Rygwjbxx toUpdateRsgw(String ryId);

	/**
	 * @param ryId
	 * @return
	 */
	Rygwjbxx queryUpdateRsgw(String ryId);

	/**
	 * @param rygwjbxx
	 */
	void updateRsgw(Rygwjbxx rygwjbxx);

//	List<Rygwjbxx> queryRygwjbxxPage(@Param("end")int end, @Param("start")int start, @Param("rygwjbxx")Rygwjbxx rygwjbxx);
}
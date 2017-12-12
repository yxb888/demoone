package com.xb.dao.workObj;

import com.xb.domain.WorkObj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkObjMapper {
    int insert(WorkObj record);

    int insertSelective(WorkObj record);

	long queryTotal() throws Exception;

	List<WorkObj> PageList(@Param("start") int start, @Param("end") int end) throws Exception;

	WorkObj queryById(WorkObj workObj) throws Exception;

	void deleteLeaveAll(String[] tId);
}
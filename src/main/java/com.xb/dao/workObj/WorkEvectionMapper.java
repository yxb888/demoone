package com.xb.dao.workObj;

import com.xb.domain.WorkEvection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkEvectionMapper {
    int insert(WorkEvection record);

    int insertSelective(WorkEvection record);

	long queryTotal() throws Exception;

	List<WorkEvection> PageList(@Param("start") int start, @Param("end") int end) throws Exception;

	WorkEvection queryWorkEvectionById(WorkEvection workEvection) throws Exception;

	void deleteWorkEvectionAll(String[] tId);
}
package com.xb.dao.workObj;

import com.xb.domain.WorkJobObj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkJobObjMapper {
    int insert(WorkJobObj record);

    int insertSelective(WorkJobObj record);

	long queryTotal() throws Exception;

	List<WorkJobObj> PageList(@Param("start") int start, @Param("end") int end) throws Exception;

	long queryTotalD() throws Exception;

	List<WorkJobObj> PageListD(@Param("start") int start, @Param("end") int end) throws Exception;
}
package com.xb.dao.pact;

import com.xb.domain.TryJbxx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TryJbxxMapper {
    int deleteByPrimaryKey(String ryId);

    int insert(TryJbxx record);

    int insertSelective(TryJbxx record);

    TryJbxx selectByPrimaryKey(String ryId);

    int updateByPrimaryKeySelective(TryJbxx record);

    int updateByPrimaryKey(TryJbxx record);

	long queryOrgscount(TryJbxx trys);

	List<TryJbxx> queryOrgsPage(@Param(value = "start") int start, @Param(value = "rows") int rows, @Param(value = "trys") TryJbxx trys);
}
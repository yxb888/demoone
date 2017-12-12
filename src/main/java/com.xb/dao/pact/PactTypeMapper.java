package com.xb.dao.pact;

import com.xb.domain.PactType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PactTypeMapper {
    int insert(PactType record);

    int insertSelective(PactType record);

	long queryPactTypecount();

	List<PactType> queryPactType(@Param("start") int start, @Param("rows") int rows);

	void deletePactType(String pacttypeid);

	void deletePactTypeAll(String[] pacttypeid);

}
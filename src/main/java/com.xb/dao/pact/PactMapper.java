package com.xb.dao.pact;

import com.xb.domain.Pact;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PactMapper {
    int insert(Pact record);

    int insertSelective(Pact record);

	long queryPactcount(Pact pact);

	List<Pact> queryPact(@Param("start") int start, @Param("rows") int rows, @Param("pact") Pact pact);

	void deletePact(String pactid);

	void addPact(Pact pact);

	void deleteAll(String[] pactid);

	Pact queryById(Pact pact);

	void updatePactType(Pact pact);

	List<Pact> queryPacts(Pact pact);
}
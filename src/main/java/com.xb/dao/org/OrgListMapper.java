package com.xb.dao.org;

import com.xb.domain.OrgList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrgListMapper {
    int insert(OrgList record);

    int insertSelective(OrgList record);

	long queryTotal(OrgList orglist);

	List<OrgList> PageList(@Param("start") int start, @Param("end") int end, @Param("orglist") OrgList orglist);

	void deleteAll(@Param(value = "idStr") String[] idStr);

	void deleteAllOrg(String[] tId);

	void addOrg(OrgList orgObj);

}
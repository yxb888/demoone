package com.xb.dao.role;

import com.xb.domain.ZsjRole;

public interface ZsjRoleMapper {
    int insert(ZsjRole record);

    int insertSelective(ZsjRole record);

	long queryTotal();
}
package com.xb.dao.user;

import com.xb.domain.UserKey;

import java.util.List;

public interface UserKeyMapper {
    int insert(UserKey record);

    int insertSelective(UserKey record);

	List<UserKey> queryUserKey();
}
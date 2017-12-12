package com.xb.service.user.impl;

import com.xb.dao.user.UserKeyMapper;
import com.xb.domain.UserKey;
import com.xb.service.user.UserKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserKeyServiceImpl implements UserKeyService {

	@Autowired
	private UserKeyMapper userKeyMapper;

	@Override
	public List<UserKey> queryUserKey() {
		// TODO Auto-generated method stub
		return userKeyMapper.queryUserKey();
	}
}

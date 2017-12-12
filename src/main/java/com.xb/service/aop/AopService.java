package com.xb.service.aop;

import com.xb.domain.LogPojo;

import java.util.Map;

public interface AopService {

	Map<String, Object> queryTopage(int page, int rows, LogPojo log);

}

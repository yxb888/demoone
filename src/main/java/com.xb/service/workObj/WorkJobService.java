package com.xb.service.workObj;

import java.util.Map;

public interface WorkJobService {

	Map<String, Object> queryWorkJobObjPage(int page, int rows) throws Exception;

	Map<String, Object> queryWorkJobObjDPage(int page, int rows) throws Exception;

}

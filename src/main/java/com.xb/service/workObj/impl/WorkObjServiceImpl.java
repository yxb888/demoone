package com.xb.service.workObj.impl;

import com.xb.dao.workObj.WorkObjMapper;
import com.xb.domain.WorkObj;
import com.xb.service.workObj.WorkObjservice;
import com.xb.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkObjServiceImpl implements WorkObjservice {

	@Autowired
	private WorkObjMapper workObjMapper;

	@Override
	public Map<String, Object> queryOrgManPage(int page, int rows) throws Exception {
//		 总条数
		 long total = workObjMapper.queryTotal();
		 PageUtil<WorkObj> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<WorkObj> teas = workObjMapper.PageList(pages.getStart(), pages.getEnd());
//		 时间格式化
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 for (int i = 0; i < teas.size(); i++) {
			 String letime = simpleDateFormat.format(teas.get(i).getApplydate());
 			 String  endtime= simpleDateFormat.format(teas.get(i).getLeaveenddate());
	         String staTime = simpleDateFormat.format(teas.get(i).getLeavestartdate());
	         teas.get(i).setEnddate(endtime);
	         teas.get(i).setStartdate(staTime);
	         teas.get(i).setApplytime(letime);
		}
		 Map<String, Object> map = new HashMap<>();
		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}

	@Override
	public WorkObj queryById(WorkObj workObj) throws Exception {
		return workObjMapper.queryById(workObj);
	}

	@Override
	public void deleteLeaveAll(String[] tId) {
		// TODO Auto-generated method stub
		workObjMapper.deleteLeaveAll(tId);
		
	}
}

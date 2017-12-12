package com.xb.service.workObj.impl;

import com.xb.dao.workObj.WorkEvectionMapper;
import com.xb.domain.WorkEvection;
import com.xb.service.workObj.WorkEvectionService;
import com.xb.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkEvectionServiceImpl implements WorkEvectionService {

	@Autowired
	private WorkEvectionMapper workEvectionMapper;

	@Override
	public Map<String, Object> queryWorkEvectionPage(int page, int rows) throws Exception {
//		 总条数
		 long total = workEvectionMapper.queryTotal();
		 PageUtil<WorkEvection> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<WorkEvection> teas = workEvectionMapper.PageList(pages.getStart(), pages.getEnd());
//		 时间格式化
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 for (int i = 0; i < teas.size(); i++) {
			 String  endtime= simpleDateFormat.format(teas.get(i).getEvectionstartdate());
	         String staTime = simpleDateFormat.format(teas.get(i).getEnddate());
	         String aptime = simpleDateFormat.format(teas.get(i).getApplydate());
	         teas.get(i).setEndtime(endtime);
	         teas.get(i).setStarttime(staTime);
	         teas.get(i).setApplytime(aptime);
		}
		 Map<String, Object> map = new HashMap<>();
		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}

	@Override
	public WorkEvection queryWorkEvectionById(WorkEvection workEvection) throws Exception {
		// TODO Auto-generated method stub
		return workEvectionMapper.queryWorkEvectionById(workEvection);
	}

	@Override
	public void deleteWorkEvectionAll(String[] tId) {
		workEvectionMapper.deleteWorkEvectionAll(tId);
		
	}
}

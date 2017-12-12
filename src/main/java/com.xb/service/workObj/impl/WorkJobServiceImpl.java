package com.xb.service.workObj.impl;

import com.xb.dao.workObj.WorkJobObjMapper;
import com.xb.domain.WorkJobObj;
import com.xb.service.workObj.WorkJobService;
import com.xb.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkJobServiceImpl implements WorkJobService {

	@Autowired
	private WorkJobObjMapper workJobObjMapper;

	@Override
	public Map<String, Object> queryWorkJobObjPage(int page, int rows) throws Exception {
//		 总条数
		 long total = workJobObjMapper.queryTotal();
		 PageUtil<WorkJobObj> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<WorkJobObj> teas = workJobObjMapper.PageList(pages.getStart(), pages.getEnd());
//		 时间格式化
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 for (int i = 0; i < teas.size(); i++) {
			 String  endtime= simpleDateFormat.format(teas.get(i).getWorkstartdate());
	         String staTime = simpleDateFormat.format(teas.get(i).getWorkenddate());
	         teas.get(i).setEnddate(endtime);
	         teas.get(i).setStartdate(staTime);
		}
		 Map<String, Object> map = new HashMap<>();
		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}

	@Override
	public Map<String, Object> queryWorkJobObjDPage(int page, int rows) throws Exception {
//		 总条数
		 long total = workJobObjMapper.queryTotalD();
		 PageUtil<WorkJobObj> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<WorkJobObj> teas = workJobObjMapper.PageListD(pages.getStart(), pages.getEnd());
//		 时间格式化
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 for (int i = 0; i < teas.size(); i++) {
			 String  endtime= simpleDateFormat.format(teas.get(i).getWorkstartdate());
	         String staTime = simpleDateFormat.format(teas.get(i).getWorkenddate());
	         teas.get(i).setEnddate(endtime);
	         teas.get(i).setStartdate(staTime);
		}
		 Map<String, Object> map = new HashMap<>();
		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}
}

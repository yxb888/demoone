package com.xb.service.gangwei.impl;

import com.xb.dao.gangwei.GangWeiMapper;
import com.xb.domain.GangWei;
import com.xb.service.gangwei.GangWeiService;
import com.xb.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GangWeiServiceImpl implements GangWeiService {

	@Resource
	private GangWeiMapper gangWeiMapper;

	@Override
	public Map<String, Object> selectGangWei(int page, int rows) {
		//总条数
		long total = gangWeiMapper.queryTotal();
		PageUtil<GangWei> pages = new PageUtil<>(page,total,rows);
		//当前页数据
		List<GangWei> teas = gangWeiMapper.PageList(pages.getStart(),pages.getEnd());
		Map<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("rows", teas);
		return map;
	}

	@Override
	public boolean delAllGangWei(String ids) {
		try {
			String[] id = ids.split(",");
			gangWeiMapper.delAllGangWei(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public void addGangWei(GangWei gw) {
		gangWeiMapper.addGangWei(gw);
	}

	@Override
	public GangWei queryGangWei(GangWei gw) {
		
		return gangWeiMapper.queryGangWei(gw);
	}

	@Override
	public void updateDQSave(GangWei gw) {
		gangWeiMapper.updateDQSave(gw);
	}


}

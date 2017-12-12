package com.xb.service.aop.impl;

import com.xb.domain.LogPojo;
import com.xb.service.aop.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AopServiceImpl implements AopService {
	@Autowired
	private  MongoTemplate mongoTemplate;

	@Override
	public Map<String, Object> queryTopage(int page, int rows,LogPojo log) {
		
		Query query = new Query();
		int start = (page-1)*rows;
		query.skip(start);
		query.limit(rows);
		long total = mongoTemplate.count(query,LogPojo.class,"logaop");
		query.with(new Sort(Direction.DESC,"id"));
		List<LogPojo> students = mongoTemplate.find(query, LogPojo.class,"logaop");
		
		
		Map<String, Object> map = new HashMap<>();
		 map.put("total", total);
		 map.put("rows", students);
		return map;
//		Query query = new Query();
//		Criteria c1 =Criteria.where("method").regex(orname);
//		//起始位置
//		int start = (page-1)*rows;	
//		query.skip(start);
//		//每页条数
//		query.limit(rows);
////		条件查询
//		query.addCriteria(c1);
//		//查询总条数
//		long tatol = mongotemplate.count(query, LogPojo.class,"logCon");
//		//查询分页数据
//		List<LogPojo> list = mongotemplate.find(query, LogPojo.class,"logCon");
//		//以Map形式进行传值
//		Map<String, Object> map = new HashMap<>();
//			map.put("total", tatol);
//			map.put("rows", list);
//		 return map;
		
	
	}
}

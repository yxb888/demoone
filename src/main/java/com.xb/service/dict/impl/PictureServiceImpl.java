/** 
 * <pre>项目名称:ssm-oa 
 * 文件名称:PictureServiceImpl.java 
 * 包名:com.xb.service.dict.impl 
 * 创建日期:2017年11月24日下午8:37:33 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.xb.service.dict.impl;

import com.xb.dao.dict.PictureDao;
import com.xb.domain.Picture;
import com.xb.domain.User;
import com.xb.service.dict.PictureService;
import com.xb.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * <pre>项目名称：ssm-oa    
 * 类名称：PictureServiceImpl    
 * 类描述：    
 * 创建人：杨兴北  
 * 创建时间：2017年11月24日 下午8:37:33    
 * 修改人：杨兴北  
 * 修改时间：2017年11月24日 下午8:37:33    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class PictureServiceImpl implements PictureService {

	
	@Autowired
	private PictureDao pictureDao;

	/* (non-Javadoc)    
	 * @see com.xb.service.dict.PictureService#insertSelective(com.xb.domain.Picture)    
	 */
	@Override
	public void insertSelective(Picture p) {
		// TODO Auto-generated method stub
		pictureDao.insertSelective(p);
	}

	/* (non-Javadoc)    
	 * @see com.xb.service.dict.PictureService#queryPicture(int, int)    
	 */
	@Override
	public Map<String, Object> queryPicture(int page, int rows) {
		// TODO Auto-generated method stub
//			总条数
			long total = pictureDao.queryTotal();
			 PageUtil<User> pages = new PageUtil<>(page, total, rows);
//			 当前页数据
			 List<User> teas = pictureDao.PageList(pages.getStart(), pages.getEnd());
			
			 Map<String, Object> map = new HashMap<>();
			 
			 map.put("total", total);
			 map.put("rows", teas);
			 return map;
	}
}

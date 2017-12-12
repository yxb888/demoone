/** 
 * <pre>项目名称:ssm-oa 
 * 文件名称:ZhishiServiceImpl.java 
 * 包名:com.xb.service.ziyuanzhishi.impl 
 * 创建日期:2017年11月23日上午8:38:08 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.xb.service.ziyuanzhishi.impl;

import com.xb.dao.ziyuanzhishi.ziyuanzhishiMapper;
import com.xb.dao.ziyuanzhishi.ziyuanzhishitypeMapper;
import com.xb.domain.User;
import com.xb.domain.ziyuanzhishi;
import com.xb.domain.ziyuanzhishitype;
import com.xb.service.ziyuanzhishi.ZhishiService;
import com.xb.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * <pre>项目名称：ssm-oa    
 * 类名称：ZhishiServiceImpl    
 * 类描述：    
 * 创建人：梁飞
 * 创建时间：2017年11月23日 上午8:38:08    
 * 修改人：梁飞 
 * 修改时间：2017年11月23日 上午8:38:08    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class ZhishiServiceImpl implements ZhishiService {
	 @Resource
	    private ziyuanzhishiMapper ziyuanzhishiMapper;
	 @Autowired
	 private ziyuanzhishitypeMapper typeMapper;

	/* (non-Javadoc)    
	 * @see com.xb.service.ziyuanzhishi.ZhishiService#queryZhishi(int, int, com.xb.domain.ziyuanzhishi)    
	 */
	@Override
	public Map<String, Object> queryZhishi(int page, int rows, ziyuanzhishi zs) {
//		总条数
		long total = ziyuanzhishiMapper.queryTotal(zs);
		 PageUtil<User> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<ziyuanzhishi> teas = ziyuanzhishiMapper.PageList(pages.getStart(), pages.getEnd(),zs);
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 		 for (int i = 0; i < teas.size(); i++) {
 			 String  endtime= formatter.format(teas.get(i).gettReleasetime());
	        
	         teas.get(i).settReleasetimeStr(endtime);
	       
		}
		 Map<String, Object> map = new HashMap<>();
		 		
		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}

	/* (non-Javadoc)    
	 * @see com.xb.service.ziyuanzhishi.ZhishiService#queryaddress(javax.servlet.http.HttpServletResponse, com.xb.domain.ziyuanzhishi)    
	 */
	@Override
	public List<ziyuanzhishi> queryaddress(HttpServletResponse response, ziyuanzhishi zs) {
		// TODO Auto-generated method stub
		return ziyuanzhishiMapper.queryaddress();
	}

	/* (non-Javadoc)    
	 * @see com.xb.service.ziyuanzhishi.ZhishiService#queryZhishiType(int, int, com.xb.domain.ziyuanzhishitype)    
	 */
	@Override
	public Map<String, Object> queryZhishiType(int page, int rows, ziyuanzhishitype zstp) {
//		总条数
		long total = typeMapper.queryTotal2(zstp);
		 PageUtil<User> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<ziyuanzhishitype> teas = typeMapper.PageList2(pages.getStart(), pages.getEnd(),zstp);
		 
		 Map<String, Object> map = new HashMap<>();
		 		
		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}

	/* (non-Javadoc)    
			新增类型
	 */
	@Override
	public void addType(ziyuanzhishitype tp) {
		typeMapper.addType(tp);
		
	}
}

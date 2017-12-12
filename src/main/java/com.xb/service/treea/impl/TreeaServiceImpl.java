/** 
 * <pre>项目名称:ssm-oa 
 * 文件名称:TreeaServiceImpl.java 
 * 包名:com.xb.service.treea.impl 
 * 创建日期:2017年11月17日下午8:57:19 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.xb.service.treea.impl;

import com.xb.dao.treea.TreeaMapper;
import com.xb.domain.treea.Treea;
import com.xb.service.treea.TreeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/** 
 * <pre>项目名称：ssm-oa    
 * 类名称：TreeaServiceImpl    
 * 类描述：    
 * 创建人：梁飞
 * 创建时间：2017年11月17日 下午8:57:19    
 * 修改人：梁飞 
 * 修改时间：2017年11月17日 下午8:57:19    
 * 修改备注：       
 * @version </pre>    
 */

@Service
public class TreeaServiceImpl implements TreeaService {
	@Autowired
	private TreeaMapper treeaMapper;

	/* (non-Javadoc)    
	 * @see com.xb.service.treea.TreeaService#queryTree(com.xb.domain.treea.Treea)    
	 */
	@Override
	public List<Treea> queryTreea(Treea treea) throws Exception {
		List<Treea> list= treeaMapper.queryTreea(treea);
		return list;
	}

	/* (non-Javadoc)    
	 * @see com.xb.service.treea.TreeaService#queryTreea2(com.xb.domain.treea.Treea)    
	 */
	
public boolean nodeHaveChild(Treea treea){
		
		boolean flag =false;
		try {
			List<Treea> queryTreea = treeaMapper.queryTreea(treea);
			if(queryTreea.size()>0){
				flag =true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
	}
	
	
	
	@Override
	public List<Treea> queryTreea2(Treea treea) throws Exception {
		List<Treea> list= new ArrayList<Treea>();
		if(treea.getId()!=null && !"".equals(treea.getId())){
			list = treeaMapper.queryTreea(treea);
		}else{
			list= treeaMapper.queryTreea2(treea);
		}
		
		List<Treea> asyncList =new ArrayList<Treea>();
		
		for (Treea tree2 : list) {
			if(nodeHaveChild(tree2)){
				tree2.setIsParent("true");
			}
			asyncList.add(tree2);
		}
		 
		
		return asyncList;
	}
}

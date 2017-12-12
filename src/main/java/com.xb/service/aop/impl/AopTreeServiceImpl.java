/** 
 * <pre>项目名称:ssm-oa 
 * 文件名称:AopTreeServiceImpl.java 
 * 包名:com.xb.service.aop.impl 
 * 创建日期:2017年11月29日下午7:10:38 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.xb.service.aop.impl;

import com.xb.dao.aop.AopTreeMapper;
import com.xb.domain.AopTree;
import com.xb.service.aop.AopTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** 
 * <pre>项目名称：ssm-oa    
 * 类名称：AopTreeServiceImpl    
 * 类描述：    
 * 创建人：张万利
 * 创建时间：2017年11月29日 下午7:10:38    
 * 修改人： 张万利  
 * 修改时间：2017年11月29日 下午7:10:38    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class AopTreeServiceImpl implements AopTreeService {

	@Autowired
	private AopTreeMapper aoptreemapper;
	/* (non-Javadoc)    
	 * @see com.xb.service.aop.AopTreeService#queryTree()    
	 */
	@Override
	public List<AopTree> queryTree() {
		// TODO Auto-generated method stub
		return aoptreemapper.queryTree();
	}

}

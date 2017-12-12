/** 
 * <pre>项目名称:ssm-oa 
 * 文件名称:AopTreeController.java 
 * 包名:com.xb.web.aop 
 * 创建日期:2017年11月29日下午7:07:29 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.xb.web.aop;

import com.xb.domain.AopTree;
import com.xb.service.aop.AopTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/** 
 * <pre>项目名称：ssm-oa    
 * 类名称：AopTreeController    
 * 类描述：    
 * 创建人：张万利
 * 创建时间：2017年11月29日 下午7:07:29    
 * 修改人： 张万利  
 * 修改时间：2017年11月29日 下午7:07:29    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("aoptreecontroller")
public class AopTreeController {

	@Autowired
	private AopTreeService aoptreeservice;
	
	@RequestMapping("queryTree")
	@ResponseBody
	public Object queryTree(){
		List<AopTree> menus = aoptreeservice.queryTree();
		return  menus;
	}
}

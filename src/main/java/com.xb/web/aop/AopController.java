package com.xb.web.aop;

import com.xb.domain.LogPojo;
import com.xb.service.aop.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("aops")
public class AopController {
	@Autowired
	private AopService aopService;
	
	
//	跳转到aop日志界面  aop/toAopOrg.jsp
	@RequestMapping("toquery")
	public String toquery(){
		return "aop/toAopOrg";
	}
	
//	跳转到aop日志查询页面aop/aopList.jsp
	@RequestMapping("toQueryAop")
	public String toQueryAop(){
		return "aop/aopList";
	}
	
	@RequestMapping("queryAopPage")
	@ResponseBody
	public Object queryAopPage(int page ,int rows,LogPojo log){
		Map<String, Object> map = aopService.queryTopage(page,rows,log);
		return map;
	}
	
}

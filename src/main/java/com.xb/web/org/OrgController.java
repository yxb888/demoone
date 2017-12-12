package com.xb.web.org;

import com.xb.domain.OrgTree;
import com.xb.service.org.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value="/org")
public class OrgController {
	
	@Autowired
	private OrgService orgservice;
	
//	跳转到机构展示页面
	@RequestMapping("toOrgShow")
	public String toOrgShow(){
		return "orgList";
	}
	
//	机构展示页面机构树
	@RequestMapping("queryTree")
	@ResponseBody
	public Object queryTree(){
		List<OrgTree> menus = orgservice.queryTree();
		return  menus;
	}
	

	
	
	
}

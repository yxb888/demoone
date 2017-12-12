package com.xb.web.frenshi;

import com.xb.domain.Rygwtree;
import com.xb.domain.Rygwzutree;
import com.xb.service.frenshi.RygwtreeService;
import com.xb.util.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("RygwtreeController")
public class RygwtreeController {
	
	@Autowired
	private RygwtreeService rygwtreeService;
	
//	跳页面
	@RequestMapping("toTree")
	public String toTree(){

		return "frenshi/rsgwList";
	}
//	人样岗位部门树
	@RequestMapping("queryZuTree")
	@ResponseBody
	public Object queryZuTree(){
		List<Rygwtree> list = rygwtreeService.queryZuTree();
		System.out.println(list);
		return list;
	}
	
//	人事岗位职位树
	@RequestMapping("queryRygwzutree")
	@ResponseBody
	public Object queryRygwzutree(){
		List<Rygwzutree> list = rygwtreeService.queryRygwzutree();
		System.out.println(list);
		return list;
	}
//查看组织机构树  下拉框形式，---- 杨兴北
	@RequestMapping("queryZuTreeOnse")
	@ResponseBody
	public Object queryZuTreeOnse(){
		String id="0";
		List<Rygwtree> list = rygwtreeService.queryZuTreeOnse(id);
		String sog_id="";
		if(list.size()>0){
		sog_id = list.get(0).getId();
		}
		List<TreeNode> treeList = rygwtreeService.queryRootNode(sog_id);
		System.out.println(list);
		return treeList;
	}

}

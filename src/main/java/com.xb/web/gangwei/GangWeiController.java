package com.xb.web.gangwei;

import com.xb.domain.GangWei;
import com.xb.service.gangwei.GangWeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/gangwei")
public class GangWeiController {

	@Autowired
	private GangWeiService gangWeiService;
	
	@RequestMapping(value="toGangWei")
	public String toGangWei(){
		return "fuzhurun/gangweichaxun";
		
	}
	@RequestMapping(value="toZtree")
	public String toZtree(){
		return "fuzhurun/tree";
		
	}
	@RequestMapping(value="toAddGangWei")
	public String toAddGangWei(){
		return "fuzhurun/gangweixinzeng";
		
	}

	
	//查询
	 @RequestMapping("selectGangWei")
		@ResponseBody
		public Object selectGangWei(int page,int rows){
			Map<String, Object> map = gangWeiService.selectGangWei(page,rows);
			return map;
			
		}
	
	 @RequestMapping("delAllGangWei")
	 @ResponseBody
	 public boolean delAllGangWei(@RequestParam String ids){
		 
		boolean isOk= gangWeiService.delAllGangWei(ids);
		 return isOk;
	 }
	 
	 @RequestMapping("addGangWei")
	 @ResponseBody
	 public Object addGangWei(GangWei gw){
		 gw.settGwId(UUID.randomUUID().toString());
		 gangWeiService.addGangWei(gw);
		 return "ok";
	 }
	 
		//修改查询
		@RequestMapping("/updateGangWei")
		public String updateGangWei(GangWei gw, Model model){
			gw=gangWeiService.queryGangWei(gw);
				model.addAttribute("gw", gw);
				return "fuzhurun/gangweiupdate";
		}
		//修改后新增
		@RequestMapping("updateDQSave")
		@ResponseBody
		public void updDQSave(GangWei gw){
			gangWeiService.updateDQSave(gw);
		}
	 
	 
}

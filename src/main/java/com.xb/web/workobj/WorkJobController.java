package com.xb.web.workobj;

import com.xb.service.workObj.WorkJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("workjobcontroller")
public class WorkJobController {

	@Autowired
	private WorkJobService workJobService;
	
//	跳转到工作展示页面已办  workObj/workJobList.jsp
	@RequestMapping("toWorkJobObjPage")
	public String toWorkJobObjPage(){
		return "workObj/workJobList";
	}
	
//	跳转到工作展示页面待办
	@RequestMapping("toWorkJobObjDPage")
	public String toWorkJobObjDPage(){
		return "workObj/workJobListD";
	}
	
//	分页查询 待办
	@RequestMapping("queryWorkJobObjDPage")
	@ResponseBody
	public Object queryWorkJobObjDPage(int page,int rows){
		Map<String, Object> maps = new HashMap<String, Object>();
		try {
			maps = workJobService.queryWorkJobObjDPage(page,rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maps;
	}
	
//	分页查询 已办
	@RequestMapping("queryWorkJobObjPage")
	@ResponseBody
	public Object queryWorkJobObjPage(int page,int rows){
		Map<String, Object> maps = new HashMap<String, Object>();
		try {
			maps = workJobService.queryWorkJobObjPage(page,rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maps;
	}
	
	
}

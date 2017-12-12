package com.xb.web.workobj;

import com.xb.domain.WorkObj;
import com.xb.service.workObj.WorkObjservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("workobjcontroller")
public class WorkObjController {

	@Autowired
	private WorkObjservice workObjservice;
	
	
//	跳转到请假管理页面
	@RequestMapping("toWorkLeave")
	public String toWorkLeave(){
		return "workObj/workList";
	}
	
	
//	分页查询请假列表
	@RequestMapping("queryWorkObjPage")
	@ResponseBody
	public Object queryWorkObjPage(int page,int rows){
		Map<String, Object> maps = new HashMap<String, Object>();
		try {
			maps = workObjservice.queryOrgManPage(page,rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maps;
	}
	
	
//	请假详情查询
	@RequestMapping("qurryLeaveById")
	public String qurryLeaveById(WorkObj workObj, Model model){
		try {
			workObj=workObjservice.queryById(workObj);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 String letime = simpleDateFormat.format(workObj.getApplydate());
	 			 String endtime= simpleDateFormat.format(workObj.getLeaveenddate());
		         String staTime = simpleDateFormat.format(workObj.getLeavestartdate());
		         workObj.setEnddate(endtime);
		         workObj.setStartdate(staTime);
		         workObj.setApplytime(letime);
			model.addAttribute("workObj", workObj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "workObj/leaveById";
	}
	
	
	@RequestMapping("deleteLeaveAll")
	@ResponseBody
	public void deleteLeaveAll(HttpServletRequest re,HttpServletResponse rs){
		String tId2 = re.getParameter("workid");
		String[] tId = tId2.split(",");
		
		workObjservice.deleteLeaveAll(tId);
	
		rs.setCharacterEncoding("UTF-8");
		rs.setContentType("html/text;chartset=utf-8");
		PrintWriter writer;
		try {
			writer = rs.getWriter();
			writer.print("ok");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

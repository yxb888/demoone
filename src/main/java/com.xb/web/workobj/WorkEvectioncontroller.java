package com.xb.web.workobj;

import com.xb.domain.WorkEvection;
import com.xb.service.workObj.WorkEvectionService;
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
@RequestMapping("workevectioncontroller")
public class WorkEvectioncontroller {

	@Autowired
	private WorkEvectionService workEvectionService;
	
//	跳转到出差展示页面workObj/workevection.jsp
	@RequestMapping("toWorkEvectionShow")
	public String toWorkEvectionShow(){
		return "workObj/workevection";
	}
	
//	分页查询
	@RequestMapping("queryWorkEvectionPage")
	@ResponseBody
	public Object queryWorkEvectionPage(int page,int rows){
		Map<String, Object> maps = new HashMap<String, Object>();
		try {
			maps = workEvectionService.queryWorkEvectionPage(page,rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maps;
	}
	
//	查看出差详情
	@RequestMapping("queryWorkEvectionById")
	public String queryWorkEvectionById(WorkEvection workEvection, Model model){
		try {
			workEvection=workEvectionService.queryWorkEvectionById(workEvection);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 String  endtime= simpleDateFormat.format(workEvection.getEvectionstartdate());
	         String staTime = simpleDateFormat.format(workEvection.getEnddate());
	         String aptime = simpleDateFormat.format(workEvection.getApplydate());
	         workEvection.setEndtime(endtime);
	         workEvection.setStarttime(staTime);
	         workEvection.setApplytime(aptime);
			model.addAttribute("workEvection", workEvection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "workObj/workEvectionById";
	}
	
	@RequestMapping("deleteWorkEvectionAll")
	@ResponseBody
	public void deleteWorkEvectionAll(HttpServletRequest re,HttpServletResponse rs){
		String tId2 = re.getParameter("evectionid");
		String[] tId = tId2.split(",");
		
		workEvectionService.deleteWorkEvectionAll(tId);
	
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

package com.xb.web.org;

import com.xb.domain.OrgList;
import com.xb.service.org.OrgQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping(value="/orgquery")
public class OrgQueryController {
	
	
	@Autowired
	private OrgQueryService orgqueryservice;
	
//	跳转到orglist.jsp机构树页面  
	@RequestMapping("toOrgShow")
	public String toOrgShow(){
		return "orgList";
	}
	
//	跳转到addOrg.jsp机构新增页面
	@RequestMapping("toAddOrg")
	public String toAddOrg(){
		return "addOrg";
	}
	
	
//	跳转到manOrgmanOeg.jsp机构管理页面
	@RequestMapping("ToQueryManOrg")
	public String ToQueryManOrg(){
		return "manOrg";
	}
	
	
//	跳转到dialogOrg.jsp机构展示页面
	@RequestMapping("ToQueryOrg")
	public String ToQueryOrg(){
		return "dialogOrg";
	}
	
//	分页条件 机构查看
	@RequestMapping("queryOrgPage")
	@ResponseBody
	public Object queryOrgPage(int page,int rows,OrgList orglist){
		Map<String, Object> orgmap = orgqueryservice.queryOrgPage(page,rows,orglist);
		return orgmap;
	}
	
//	分页条件 机构管理
	@RequestMapping("queryOrgManPage")
	@ResponseBody
	public Object queryOrgManPage(int page,int rows,OrgList orglist){
		Map<String, Object> orgmanmap = orgqueryservice.queryOrgManPage(page,rows,orglist);
		return orgmanmap;
	}
	
//	删除------废弃
	@RequestMapping("deleteAll")
	public String deleteAll(String idStr){
		orgqueryservice.deleteAll(idStr);
		return "redirect:toOrgShow.action";
	}
	
//	批量删除
	@RequestMapping("deleteAllOrg")
	@ResponseBody
	public void deleteAllOrg(HttpServletRequest re,HttpServletResponse rs){
		String tId2 = re.getParameter("orgid");
		String[] tId = tId2.split(",");
		
		orgqueryservice.deleteAllOrg(tId);
	
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
	
//	新增机构
	@RequestMapping("addOrg")
	@ResponseBody
	public Object addOrg(OrgList orgObj, HttpServletRequest re, HttpServletResponse rs){
			orgObj.setOrgid(UUID.randomUUID().toString());
			orgqueryservice.addOrg(orgObj);
		return "1";
		
	}
	
}

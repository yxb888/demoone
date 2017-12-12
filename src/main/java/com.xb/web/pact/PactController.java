package com.xb.web.pact;

import com.xb.domain.Emps;
import com.xb.domain.OrganizationTree;
import com.xb.domain.Pact;
import com.xb.service.pact.PactService;
import com.xb.util.ExportExcel;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("pact")
public class PactController {
	@Autowired
	private PactService pactService;
	//跳转页面（查询）
	@RequestMapping("toPact")
	public String toPact(){
		return "hetong/topact";
	}
	
	//分页查询合同
	@RequestMapping("queryPact")
	@ResponseBody
	public Object queryPact(int page , int rows,Model model,Pact pact){
		Map<String, Object> map = pactService.queryPact(page ,rows,pact);
		return map;
	}
	
//	@RequestMapping("query")
//	public String query(){
//		return "topact";
//	}
//	
	//删除合同
	@RequestMapping("deletePact")
	public void deletePact(HttpServletResponse response,String pactid) throws IOException{
		
			String flag = pactService.deletePact(pactid);
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer =response.getWriter();
			writer.write(flag);
			writer.flush();
			writer.close();
	}
	
	//跳转添加页面
	@RequestMapping("toAdd")
	public String toadd(){
		
		return "hetong/toaddpact";
	}
	
	//查询新增弹框中的树
	@RequestMapping("queryPactTree")
	@ResponseBody
	public Object queryPactTree(){
		List<OrganizationTree> menus = pactService.queryPactTree();
		return  menus;
	}
	
	//查询弹框中的人
	@RequestMapping("queryOrgsPage")
	@ResponseBody
	public Object queryOrgsPage(int page , int rows,Emps emps){
		Map<String, Object> map = pactService.queryOrgsPage(page ,rows,emps);
		return map;
	}
	//添加合同
	@RequestMapping("addPact")
	public void addPact(HttpServletResponse response,Pact pact){
		 String flags= pactService.addPact(pact);
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer=null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.write(flags);
		writer.flush();
		writer.close();
	}
	//批量删除
	@RequestMapping("/deleteAll")
	@ResponseBody
	public void deleteAll(HttpServletRequest re,HttpServletResponse rs){
		String pactids = re.getParameter("pactid");
		String[] pactid = pactids.split(",");
		
		pactService.deleteAll(pactid);
	
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
	
	//跳转到合同类型页面
	@RequestMapping("toPactType")
	public String toPactType(){
		return "hetong/pacttype";
	}
	
	//分页查询合同类别
	@RequestMapping("queryPactType")
	@ResponseBody
	public Object queryPactType(int page , int rows){
		Map<String, Object> map = pactService.queryPactType(page ,rows);
		return map;
	}
	
	//删除合同类别
		@RequestMapping("deletePactType")
		public void deletePactType(HttpServletResponse response,String pacttypeid) throws IOException{
			
				String flag = pactService.deletePactType(pacttypeid);
				response.setCharacterEncoding("UTF-8");
				PrintWriter writer =response.getWriter();
				writer.write(flag);
				writer.flush();
				writer.close();
		}
		
		
		//批量删除
		@RequestMapping("/deletePactTypeAll")
		@ResponseBody
		public void deletePactTypeAll(HttpServletRequest re,HttpServletResponse rs){
			String pacttids = re.getParameter("pacttypeid");
			String[] pacttypeid = pacttids.split(",");
			
			pactService.deletePactTypeAll(pacttypeid);
		
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
		
		
		@RequestMapping("updatePactById")
		public String queryById(Model model,Pact pact){
			
			pact=pactService.queryById(pact);
			model.addAttribute("pact", pact);
			return "hetong/updatePact";
		}
		
		//查询后新增
		@RequestMapping("/updatePactType")
		@ResponseBody
		public void updatePactType(Pact pact){
			pactService.updatePactType(pact);
		}	
		
		//导出合同数据
		@RequestMapping("Exportpact")
		public void pioExcel(HttpServletResponse response,Pact pact){
			List<Pact> list =new ArrayList<Pact>();
			try {
				String title = "项目树";
				String[] rowName = {"主键","合同名称","人员名称","合同状态","时间状态","合同类型","开始时间","结束时间","合同内容","合同附件"};
				list = pactService.queryPacts(response,pact);
				List<Object[]> arrObj=new ArrayList<Object[]>();
				Object[] objs=null;
				for (int i = 0; i < list.size(); i++) {  
					Pact pacts = list.get(i);
				    objs = new Object[rowName.length];  
				    objs[0] = pacts.getPactid();
				    objs[1] = pacts.getPactname();
				    objs[2] = pacts.getPactusername();
				    objs[3] = pacts.getPactzt();  
				    objs[4] = pacts.getTimetype();
				    objs[5] = pacts.getPacttype();
//				    objs[6] = pacts.getStarttime();
//				    objs[7] = pacts.getEndtime();
				    objs[8] = pacts.getPactmatter();
				    objs[9] = pacts.getPactaccessory();
				    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
				    String date = df.format(pacts.getStarttime());  
				    objs[6] = date; 
				    String enddate=df.format(pacts.getEndtime());
				    objs[7] = enddate; 
				    arrObj.add(objs);  
				}  
				ExportExcel  exportExcel = new ExportExcel(title, rowName, arrObj, response);
				exportExcel.export();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}

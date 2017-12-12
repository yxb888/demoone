package com.xb.web.diqu;

import com.xb.domain.Diqu;
import com.xb.service.diqu.DiquService;
import com.xb.util.XwpfTUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping(value="/diqu")
public class DiquController {
	
	@Autowired
	private DiquService diquService;
	//跳转新增
	@RequestMapping("todiqu")
	public String toDQ(){
		return "liangfei/todiqu";
	}
	//查询管理页面
	@RequestMapping("todiqu2")
	public String toDQ2(){
		return "liangfei/todiqu2";
	}
	 @RequestMapping("queryDiqu")
		@ResponseBody
		public Object queryUser(int page,int rows, Diqu dq){
			Map<String, Object> map = diquService.queryDiqu(page,rows,dq);
			return map;
		}
	 //新增地区
	 @RequestMapping("addDiqu")
	 @ResponseBody
	
	 public Object addDiqu(HttpServletRequest re,HttpServletResponse rs, Diqu dq){
		 dq.settId(UUID.randomUUID().toString());	
		 diquService.addDiqu(dq);
		 rs.setCharacterEncoding("UTF-8");
		 rs.setContentType("html/text;chartset=utf-8");
			return "ok";
			
		}
	 
	 
//	 删除地区
	@RequestMapping("/deleteAll")
	@ResponseBody
	public void deleteAll(HttpServletRequest re,HttpServletResponse rs){
		String tId2 = re.getParameter("tId");
		String[] tId = tId2.split(",");
		
		diquService.deleteAll(tId);
	
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
	//修改查询
	@RequestMapping("/updateDiqu")
	public String updateDiqu(Diqu diqu, Model model){
		diqu=diquService.queryById(diqu);
			model.addAttribute("diqu", diqu);
			return "liangfei/upddiqu";
	}
	//查询后新增
	@RequestMapping("updDQSave")
	@ResponseBody
	public void updDQSave(Diqu diqu){
		diquService.updateDQSave(diqu);
	}
	//导出word
	@RequestMapping("exportApplyForm")
	@ResponseBody
	 public void exportApplyForm(HttpServletRequest request, HttpServletResponse response,Diqu dq ) throws Exception {
		Diqu dqq =new Diqu();
		List<Diqu> list=new ArrayList<Diqu>();
	    //    String id = request.getParameter("id");  
		list = diquService.retriveById();  
	        	
	        Map<String, Object> Diqu = new HashMap<String, Object>();  
	  
	        Diqu.put("${tId}", list.get(0).gettId());
	        Diqu.put("${tDiquname}", list.get(0).gettDiquname());
	        Diqu.put("${tEgName}", list.get(0).gettEgName());
	        Diqu.put("${tBeizhu}", list.get(0).gettBeizhu());
	        XwpfTUtil xwpfTUtil = new XwpfTUtil();
	  
	        XWPFDocument doc;  
	        String fileNameInResource = "sta.docx";  
	        InputStream is;  
	        /*is = new FileInputStream(filePath);*/  
	        is = getClass().getClassLoader().getResourceAsStream(fileNameInResource);  
	        doc = new XWPFDocument(is);  
	  
	        xwpfTUtil.replaceInPara(doc, Diqu);  
	        //替换表格里面的变量  
	        xwpfTUtil.replaceInTable(doc, Diqu);  
	        OutputStream os = response.getOutputStream();  
	  
	        response.setContentType("application/vnd.ms-excel");  
	        response.setHeader("Content-disposition","attachment;filename="+list.get(0).gettDiquname()+".docx");  
	  
	        doc.write(os);  
	  
	        xwpfTUtil.close(os);  
	        xwpfTUtil.close(is);  
	  
	        os.flush();  
	        os.close();  
	    }  
	
	
	
	
	
	
}

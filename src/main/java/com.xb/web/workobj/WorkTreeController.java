package com.xb.web.workobj;

import com.xb.domain.WorkTree;
import com.xb.service.workObj.WorkTreeService;
import com.xb.util.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("worktreecontroller")
public class WorkTreeController {

	@Autowired
	private WorkTreeService workTreeService;
	
//	跳转到工作管理页面 workObj/leaveList.jsp
	@RequestMapping("toWorkLeave")
	public String toWorkLeave(){
		return "workObj/leaveList";
	}
	
	@RequestMapping("queryTree")
	@ResponseBody
	public Object queryTree(){
		List<WorkTree> menus = workTreeService.queryTree();
		return  menus;
	}
	
//	POI
	@RequestMapping("exportExcel")
	public void exportExcel(WorkTree tree,HttpServletResponse response){
		List<WorkTree> list =new ArrayList<WorkTree>();
		try {
			String title = "树形菜单";
			String[] rowName = {"id","pid","text","state","url"};
			list = workTreeService.queryTree();
			List<Object[]> arrObj=new ArrayList<Object[]>();
			Object[] objs=null;
			for (int i = 0; i < list.size(); i++) {  
				WorkTree tree1 = list.get(i);  
			    objs = new Object[rowName.length];  
			    objs[0] = tree1.getId();  
			    objs[1] = tree1.getPid();  
			    objs[2] = tree1.getText();
			    objs[3] = tree1.getState();
			    objs[4] = tree1.getUrl();  
			  /*  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			    String date = df.format(man.getModiDate());  
			    objs[5] = date;  */
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

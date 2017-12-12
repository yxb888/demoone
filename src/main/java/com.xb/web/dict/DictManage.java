package com.xb.web.dict;

import com.xb.domain.Dict;
import com.xb.domain.DictTree;
import com.xb.service.dict.DictManageService;
import com.xb.util.ExportExcel;
import com.xb.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/dict")
public class DictManage {
	
	
	 protected Map<String, String> condition = new HashMap<String, String>();
	@Autowired
	private DictManageService dictManageService;
	
	@RequestMapping("/toDictmain")
	public String toDictmain(HttpServletRequest re){
		re.getSession().setAttribute("dictcode", "dictcode");
		return "DictManage/dictmain_list";
		
	}
    @RequestMapping("/toUserlist")
 public String  toUserlist() {
    	return "systemUser/userlist";
    }
	Dict dict = new Dict();
//	 字典查询
	@RequestMapping("/DictManageAction_selectdictlist")
	@ResponseBody
	public Object DictManageAction_selectdictlist(int page,int rows,HttpServletRequest re){
	
		String dictIfChange = re.getParameter("dictIfChange");
		Object dictcode = re.getSession().getAttribute("dictcode");
//		String dictcode = re.getParameter("dictcode");
		Map<String,Object> map=new HashMap<String, Object>();
		if(!dictcode.equals("dictcode")){
			dict.setDictCode(dictcode.toString());
			if(!dictIfChange.equals("-请选择是否允许编辑:默认所有-")){
				dict.setDictIfchange(Integer.parseInt(dictIfChange));
			}
			 map=dictManageService.DictManageAction_selectdictlist(page,rows,dict);
		}else{
			if(!dictIfChange.equals("-请选择是否允许编辑:默认所有-")){
				dict.setDictIfchange(Integer.parseInt(dictIfChange));
				dict.setDictCode(null);
				 map=dictManageService.DictManageAction_selectdictlist(page,rows,dict);
			}else{
				 map=dictManageService.DictManageAction_selectdictlistst(page,rows);
			}
		}
		
		
		return map;
	}
////	模糊查询
//	@RequestMapping("/selectif")
//	@ResponseBody
//	public void  selectif(HttpServletRequest re){
//		String dictIfChange = re.getParameter("dictIfChange");
//		if(!dictIfChange.equals("-请选择是否允许编辑-")){
//			dict.setDictIfchange(Integer.parseInt(dictIfChange));
//			 map=dictManageService.DictManageAction_selectdictlist(page,rows,dict);
//		}
//		
//	}
	
	
//	 删除字典
	@RequestMapping("/DictManageAction_delitelist")
	@ResponseBody
	public void DictManageAction_delitelist(HttpServletRequest re,HttpServletResponse rs){
		String dictId2 = re.getParameter("dictId");
		String[] dictId = dictId2.split(",");
		System.out.println(dictId);
	dictManageService.deleteDictlist(dictId);
	
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
	
//	点击选择上级 进入相应的系统字典表
	@RequestMapping("/checktoDict")
	public String checktoDict(String dictcode,HttpServletRequest re){
		re.getSession().removeAttribute("dictcode");
		re.getSession().setAttribute("dictcode", dictcode);
		return "DictManage/dictmain_list";
		
	}
	
//	新增
	@RequestMapping("/dictAdd")
	@ResponseBody
	public String dictAdd(DictTree dicttree,Dict dict,HttpServletRequest re){
		dicttree.settDictText(dicttree.gettDictName());
		dicttree.settDictId(RandomUtil.getRandomCode(6));
		dictManageService.dictAdd(dicttree);
		dict.setDictCode(dicttree.gettDictCode());
		dict.setDictId(RandomUtil.getRandomCode(6));
		dict.setDictIfchange(1);
		dict.setDictTreeid(dicttree.gettDictId());
		dictManageService.dictAdddict(dict);
		System.out.println("aaa");
		return "a";
	}
	
//	修改
	@RequestMapping("/dictupdate")
	@ResponseBody
	public String dictupdate(DictTree dicttree,Dict dict,HttpServletRequest re){
		dicttree.settDictText(dicttree.gettDictName());
		dictManageService.dictupdate(dicttree);
		dict.setDictCode(dicttree.gettDictCode());
		dict.setDictTreeid(dicttree.gettDictId());
		dict.setDictIfchange(1);
		dict.setDictTreeid(dicttree.gettDictId());
		dictManageService.dictupdatedict(dict);
		System.out.println("aaa");
		return "a";
	}
	
	
//	修改回查
	@RequestMapping("/selectupdate")
	@ResponseBody
	public Object selectupdate(Dict dict,HttpServletRequest re){
		Map<String,Object> map=new HashMap<String, Object>();
		List<Dict> aaa =dictManageService.selectupdate(dict);
		String gettDictPid = aaa.get(0).getDicttree().gettDictPid();
		if(gettDictPid!=null&&gettDictPid!=""){
			if(gettDictPid.equals("1")){
				aaa.get(0).getDicttree().settDictLeaf("用功形式");	
			}else if(gettDictPid.equals("10")){
				aaa.get(0).getDicttree().settDictLeaf("婚姻状况");	
			}else if(gettDictPid.equals("11")){
				aaa.get(0).getDicttree().settDictLeaf("计划类型");	
			}else if(gettDictPid.equals("1101")){
				aaa.get(0).getDicttree().settDictLeaf("日志类型");	
			}else if(gettDictPid.equals("1102")){
				aaa.get(0).getDicttree().settDictLeaf("新闻类型");	
			}else if(gettDictPid.equals("1103")){
				aaa.get(0).getDicttree().settDictLeaf("公告类型");	
			}else if(gettDictPid.equals("12")){
				aaa.get(0).getDicttree().settDictLeaf("相册类型");	
			}else if(gettDictPid.equals("13")){
				aaa.get(0).getDicttree().settDictLeaf("日程类型");	
			}else if(gettDictPid.equals("14")){
				aaa.get(0).getDicttree().settDictLeaf("合同类型");	
			}else if(gettDictPid.equals("15")){
				aaa.get(0).getDicttree().settDictLeaf("人事管理");	
			}
		}
		//System.out.println(dicttree);
		System.out.println("aaa");
		return aaa;
	}
	
//	数据导出
//	修改
	@RequestMapping("/expotexecle")
	public void expotexecle(DictTree dicttree,Dict dict,HttpServletRequest re,HttpServletResponse response){

		List<DictTree> list =new ArrayList<DictTree>();
		try {
		String title = "字典数据";
		String[] rowName = {"id","名称","路径","pid","编码","英文名字","备注"};
		
		list=dictManageService.queryDictTree();
		List<Object[]> arrObj=new ArrayList<Object[]>();
		Object[] objs=null;
		for (int i = 0; i < list.size(); i++) {  
			DictTree tree1 = list.get(i);  
		    objs = new Object[rowName.length];  
		    objs[0] = tree1.gettDictId();
		    objs[1] = tree1.gettDictText();
		    objs[2] = tree1.gettDictUrl();
		    objs[3] = tree1.gettDictPid();
		    objs[4] = tree1.gettDictCode();
		    objs[5] = tree1.gettDictEnname();
		    objs[6] = tree1.gettText();
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

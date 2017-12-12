/** 
 * <pre>项目名称:ssm-oa 
 * 文件名称:ZiyuanzhishiController.java 
 * 包名:com.xb.web.ziyuanzhishi 
 * 创建日期:2017年11月23日上午8:39:09 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.xb.web.ziyuanzhishi;

import com.xb.domain.ziyuanzhishi;
import com.xb.domain.ziyuanzhishitype;
import com.xb.service.ziyuanzhishi.ZhishiService;
import com.xb.util.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping(value="/zhishi")
public class ZiyuanzhishiController {
	@Autowired
	private ZhishiService zhishiService;
	
	//跳转查询
		@RequestMapping("tozhishi")
		public String toDQ(){
			return "liangfei/zhishi/zhishiList";
		}
	//跳转管理
		@RequestMapping("tozhishi2")
		public String toDQ2(){
		return "liangfei/zhishi/zhishiguanli";
		}
	//跳转知识类型
		@RequestMapping("tozhishi3")
		public String toDQ3(){
		return "liangfei/zhishi/zhishitype";
		}
   //查询类型表
		@RequestMapping("queryZhishiType")
		@ResponseBody
			public Object queryZhishiType(int page,int rows, ziyuanzhishitype zstp){
			Map<String, Object> map = zhishiService.queryZhishiType(page,rows,zstp);
			return map;
			}
	//查询两表
		 @RequestMapping("queryZhishi")
			@ResponseBody
			public Object queryZhishi(int page,int rows, ziyuanzhishi zs){
				Map<String, Object> map = zhishiService.queryZhishi(page,rows,zs);
				return map;
			}
	//导出
		 @RequestMapping("Exportpact2")
			public void pioExcel(HttpServletResponse response,ziyuanzhishi zs){
				List<ziyuanzhishi> list =new ArrayList<ziyuanzhishi>();
				try {
					String title = "知识数据";
					String[] rowName = {"主键","知识标题","类型名称","关键字","发布人","发布时间","附件数"};
					list = zhishiService.queryaddress(response,zs);
					List<Object[]> arrObj=new ArrayList<Object[]>();
					Object[] objs=null;
					for (int i = 0; i < list.size(); i++) {  
						ziyuanzhishi pacts = list.get(i);
					    objs = new Object[rowName.length]; 
					    objs[0] = pacts.gettId();
					    objs[1] = pacts.gettTitle();
					    objs[2] = pacts.gettTypeName();
					    objs[3] = pacts.gettKeyword();
					    objs[4] = pacts.gettIssur();
					    objs[5] = pacts.gettReleasetime();
					    objs[6] = pacts.gettFujianNumber();
					 
					    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
					    String date = df.format(pacts.gettReleasetime());  
					    objs[5] = date; 

					    arrObj.add(objs);  
					}  
					ExportExcel  exportExcel = new ExportExcel(title, rowName, arrObj, response);
					exportExcel.export();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 
		//新增类型
		 @RequestMapping("addType")
		 @ResponseBody
		 public Object addType(HttpServletRequest re,HttpServletResponse rs, ziyuanzhishitype tp) throws UnsupportedEncodingException{
			 tp.settTypeId(UUID.randomUUID().toString());	
			 String tType =new String(tp.gettType().getBytes("ISO-8859-1"),"utf-8");
			 String tExplain =new String(tp.gettExplain().getBytes("ISO-8859-1"),"utf-8");
			 tp.settType(tType);
			 tp.settExplain(tExplain);
			
			 zhishiService.addType(tp);
			 rs.setCharacterEncoding("UTF-8");
			 rs.setContentType("html/text;chartset=utf-8");
				return "ok";
				
			}
}

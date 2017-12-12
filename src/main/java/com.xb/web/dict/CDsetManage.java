package com.xb.web.dict;

import com.xb.domain.Paramerta;
import com.xb.service.dict.DestService;
import com.xb.service.dict.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//磁盘管理
@Controller
@RequestMapping(value="/cdset")
public class CDsetManage {
	@Autowired
	private DestService destService;
	@Autowired
	private PictureService pictureService;
	

	@RequestMapping("/toCDsetmain")
	public String toDictmain(HttpServletRequest re){
//		re.getSession().setAttribute("dictcode", "dictcode");
		return "DictManage/cdsetmain";
		
	}
	
	@RequestMapping("/toPictue")
	public String toPictue(HttpServletRequest re){
//		re.getSession().setAttribute("dictcode", "dictcode");
		return "DictManage/showpicture";
		
	}
	
	
//	跳转参数设置页面
	@RequestMapping("/toParameterSetmain")
	public String toParameterSetmain(HttpServletRequest re){
//		re.getSession().setAttribute("dictcode", "dictcode");
		return "DictManage/parameterSet_list";
		
	}
	
	@RequestMapping("/cdsetManageAction_selectdictlist")
	@ResponseBody
	public String cdsetManageAction_selectdictlist(int page,int rows,HttpServletRequest re){
//		re.getSession().setAttribute("dictcode", "dictcode");
		
		
		return "DictManage/cdsetmain";
		
	}

	/**
	 * <pre>查询参数设置  
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月23日 上午11:41:04    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月23日 上午11:41:04    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @param re
	 * @return</pre>
	 */
	
	@RequestMapping("/selectByPrimaryKey")
	@ResponseBody
	public List selectByPrimaryKey(){
//		re.getSession().setAttribute("dictcode", "dictcode");
		List<Paramerta> s=destService.selectByPrimaryKey();
		System.out.println(111);
		return s;
		
	}

	
	@RequestMapping("/updateByPrimaryKeySelective")
	@ResponseBody
	public void updateByPrimaryKeySelective(Paramerta paramert){
//		re.getSession().setAttribute("dictcode", "dictcode");
		paramert.setpId("1");
	destService.updateByPrimaryKeySelective(paramert);
		System.out.println(111);
		
	}
	/**
	 * 公司信息修改
	 * 
	 */
	
	
	@RequestMapping("/tocompanymain")
	public String tocompanymain(HttpServletRequest re){
//		re.getSession().setAttribute("dictcode", "dictcode");
		return "DictManage/compan_list";
		
	}
	
	@RequestMapping("/selectcompanyKey")
	@ResponseBody
	public List selectcompanyKey(){
//		re.getSession().setAttribute("dictcode", "dictcode");
		List<Paramerta> s=destService.selectByPrimaryKey();
		System.out.println(111);
		return s;
		
	}
//上传图片
	/***  
     * 保存文件  
     *  
     * @param file  
     * @return  
     */  
    private boolean saveFile(HttpServletRequest request, MultipartFile file) {  
        // 判断文件是否为空  
        if (!file.isEmpty()) {  
            try {  
                // 保存的文件路径(如果用的是Tomcat服务器，文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中  )  
                String filePath = request.getSession().getServletContext()  
                    .getRealPath("/") + "upload/" + file.getOriginalFilename();  
                System.err.println(filePath);  
                File saveDir = new File(filePath);  
                if (!saveDir.getParentFile().exists())  
                    saveDir.getParentFile().mkdirs();  
                 System.err.println(filePath);  
                // 转存文件  
                file.transferTo(saveDir);  
                return true;  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return false;  
    }  
	@RequestMapping("/updatecompanySelective")
	@ResponseBody
	public void updatecompanySelective(Paramerta paramert){
		paramert.setpId("2");
	destService.updateByPrimaryKeySelectivea(paramert);
		System.out.println(111);
		
	}
	/**
	 * <pre>uploadMyFileNameMethod(上传图片 
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月27日 下午5:26:34    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月27日 下午5:26:34    
	 * 修改备注： 
	 * @param fileName
	 * @param request
	 * @return
	 * @throws Exception</pre>
	 */
	@RequestMapping("uploadMyFileNameMethod")
	@ResponseBody
	public Map uploadMyFileNameMethod(MultipartFile fileName ,HttpServletRequest request) throws Exception{
		   Map result = destService.uploadPicture(fileName,request);
	return result;
	}
	
	
	
	@RequestMapping("/queryPicture")
	@ResponseBody
	public Object queryPicture ( int page,int rows,HttpServletRequest request){
		Map<String, Object> map = pictureService.queryPicture(page,rows);
		return map;
		
	}
	

	@RequestMapping("getHeicharts")
	@ResponseBody
	public List<Map<String,Object>> getHeicharts(MultipartFile fileName ,HttpServletRequest request) throws Exception{
		List<Map<String,Object>> wwwmap=new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> hhhmap=new ArrayList<Map<String,Object>>();
		  Map<String,Object> map11=new HashMap<String,Object>();
		  Map<String,Object> map12=new HashMap<String,Object>();
		
		List<Map<String,Object>> map=new ArrayList<Map<String,Object>>();
		   List<Map<String,Object>> result = destService.getHeicharts();
		   List<Map<String,Object>> resultA = destService.getHeichartsA();
		   for (Map<String, Object> map2 : result) {
			   Map<String,Object> map3=new HashMap<String,Object>();
			   map3.put("name", map2.get("mon"));
			   map3.put("y", map2.get("sum"));
			   map.add(map3);
		}
		   for (Map<String, Object> map4 : resultA) {
			   Map<String,Object> map5=new HashMap<String,Object>();
			   map5.put("name", map4.get("mon"));
			   map5.put("y", map4.get("sum"));
			   hhhmap.add(map5);
		   }
		   map11.put("data1", map);
		   map11.put("data2", hhhmap);
		   wwwmap.add(map11);
	return wwwmap;
	}
	
	
	
	
	
}

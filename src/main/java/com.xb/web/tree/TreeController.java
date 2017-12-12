package com.xb.web.tree;

import com.xb.domain.*;
import com.xb.service.tree.TreeService;
import com.xb.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Controller
@RequestMapping(value="/tree")
public class TreeController {
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private TreeService treeservice;
	
	@RequestMapping("/queryTree")
	@ResponseBody //将返回的数据 以json的格式返回
	public Object queryTree(){
		List<Menutree> menus = treeservice.queryTree();
		return  menus;
	}
	
	
	
	
	@RequestMapping("selectMenuListTree")
	@ResponseBody
	List<Map<String, Object>> selectMenuListTree(HttpServletRequest request) {
		String parameter = request.getParameter("left");
		List<Map<String, Object>> list = new ArrayList<>();
//		Object attribute = request.getSession().getAttribute("userInfo");
//		if (null != attribute) {
//			User u = (User) attribute;
		String username = "";
		list = treeservice.selectMenuLists(parameter);
//		}
		return list;
	}
	
/**
 * <pre>selectMenuList 树查看 
 * 创建人：杨兴北   
 * 创建时间：2017年11月29日 下午4:55:42    
 * 修改人：杨兴北 
 * 修改时间：2017年11月29日 下午4:55:42    
 * 修改备注： 
 * @param roleid
 * @param request
 * @return</pre>
 */
	@RequestMapping("selectMenuList")
	@ResponseBody
	List<Map<String, Object>> selectMenuList(String roleid,HttpServletRequest request) {
		List<Map<String, Object>> list = new ArrayList<>();
		TreeList treeList=new TreeList();
		
		Role r = treeservice.selectMenuList(roleid);
		Set<Permission> roles = r.getRoles();
    	//获得所有的角色
//		List<Permission> list =new ArrayList<Permission>();
		list =  treeservice.selectTreeList();
		treeList.setRoles(roles);
		treeList.setList(list);
//		}
		return list;
	}
//	 根据角色id查看所属权限
	@RequestMapping("findMenuByRoleId")
	@ResponseBody
	List<Map<String, Object>> findMenuByRoleId(String roleid,HttpServletRequest request) {
		List<Map<String, Object>> list = new ArrayList<>();
		list = treeservice.findMenuByRoleId(roleid);
		return list;
	}
//	保存修改后的权限
	@RequestMapping("SaveByRoleId")
	@ResponseBody
	String  SaveByRoleId(String menuIds,String roleid,HttpServletRequest request) {
		User user =(User) request.getSession().getAttribute("userInfo");
		 Object object = redisTemplate.opsForValue().get(user.getUserid()+"change");
		 if(object!=null){
			 if(object.toString().equals("1")){
				 redisTemplate.delete(user.getUserid()+"change");
				 redisTemplate.opsForValue().set(user.getUserid()+"change", 2);
				 redisTemplate.delete(user.getUserid()+"change1");
				 redisTemplate.opsForValue().set(user.getUserid()+"change1", 2);
			 }
		 }
		
		
		
		List<Map<String, Object>> list = new ArrayList<>();
		treeservice.SaveByRoleId(menuIds,roleid);
		return "success";
	}
	
	
	
	
	@RequestMapping("selectMenuListDict")
	@ResponseBody
	List<Map<String, Object>> selectMenuListDict(HttpServletRequest request) {
		List<Map<String, Object>> list = new ArrayList<>();
//		Object attribute = request.getSession().getAttribute("userInfo");
//		if (null != attribute) {
//			User u = (User) attribute;
//			String username = u.getUsername();
			list = treeservice.selectMenuListDict();
//		}
		return list;
	}
//	删除树
	@RequestMapping("deletetree")
	@ResponseBody
	public void deletetree(HttpServletRequest re){
		String idss = re.getParameter("idss");
		System.out.println(idss);
		System.out.println("sdas");
		treeservice.deletetree(idss);
	}
	
//	xiugai shu
	@RequestMapping("updatetree")
	@ResponseBody
	public void updatetree(Permission permission,HttpServletRequest re){
		String idssname = re.getParameter("idssname");
		String idssnameid = re.getParameter("idssnameid");
		permission.settId(idssnameid);
		permission.settText(idssname);
		System.out.println(idssname);
		System.out.println("sdas");
		treeservice.updatetree(permission);
	}
	
//	新增树
	@RequestMapping("addtree")
	@ResponseBody
	public void addtree(Permission permission,HttpServletRequest re){
		String addpid = re.getParameter("addpid");
		String addname = re.getParameter("addname");
		permission.settId(RandomUtil.getRandomCode(3));
		permission.settPid(addpid);
		permission.settText(addname);
		System.out.println(addname);
		System.out.println("sdas");
		treeservice.addtree(permission);
	}
	
//	查看当前用户 所属的权限树
	@RequestMapping("getCurrenUserNodes")
	@ResponseBody
	public Set<Map<String,Object>> getCurrenUserNodes(HttpServletRequest request){
		User user =(User) request.getSession().getAttribute("userInfo");
		String left = request.getParameter("left");
		
		Set<Map<String,Object>> treeSet=treeservice.getCurrenUserNodes(user,left);
		return treeSet;
	}
	
	
	
}

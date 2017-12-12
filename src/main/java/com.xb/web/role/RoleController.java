package com.xb.web.role;

import com.xb.domain.Role;
import com.xb.domain.RolesList;
import com.xb.domain.User;
import com.xb.service.role.RoleService;
import com.xb.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 *jiaose控制器
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController {
	
	protected HttpSession s ;
	@Autowired
	private RedisTemplate redisTemplate;
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
    @RequestMapping("/view")
    public String view() {
        return "main/login";
    }
    @RequestMapping("/toUserPage")
    public String toUserPage() {
        return "usermain";
    }
    @RequestMapping("/index")
    public void indexs(HttpServletRequest req,HttpServletResponse res) {
    	
    	s.setAttribute("username", null);
    	
    }
    @RequestMapping("/toRolelist")
    public String toRolelist(HttpServletRequest req,HttpServletResponse res) {
    	
    	return "systemUser/rolelist";
    	
    }
    /**
     * <pre>进入用户管理
     * 创建人：杨兴北   
     * 创建时间：2017年11月28日 下午7:20:56    
     * 修改人：杨兴北 
     * 修改时间：2017年11月28日 下午7:20:56    
     * 修改备注： 
     * @return</pre>
     */
    @RequestMapping("/toShowRole")
    public String toShowRole(String userId,HttpServletRequest request) {
    	request.getSession().setAttribute("userId", userId);
        return "systemUser/showRole";
    }
    
    @RequestMapping("/indexview")
    public String index() {
        return "main/index";
    }
    @RequestMapping("/roleNodes")
    @ResponseBody
    public RolesList roleNodes(String userId, HttpServletRequest request) {
    	RolesList roleList=new RolesList();
    	//调用getResourcesList获得当前用户的角色集合
    	User resourcesList =userService.getResourcesList(userId);
    	Set<Role> roles = resourcesList.getRoles();
    	//获得所有的角色
		List<Role> list =new ArrayList<Role>();
		list =  roleService.selectRoleList();

		roleList.setList(list);
		roleList.setRoles(roles);
    	return roleList;
    }
    @RequestMapping("/addUserRoleRelation")
    @ResponseBody
    public String addUserRoleRelation(String id,String userid,HttpServletRequest request){
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
    	roleService.addUserRoleRelatio(id,userid);
    	return "ok";
    }
    
    @RequestMapping("queryRole")
   	@ResponseBody
   	public Object queryRole(int page,int rows){
   		Map<String, Object> map = roleService.queryRole(page,rows);
   		return map;
   	}
    
    
}



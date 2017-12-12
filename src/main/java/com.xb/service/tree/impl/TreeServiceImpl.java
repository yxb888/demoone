package com.xb.service.tree.impl;

import com.xb.dao.tree.MenutreeMapper;
import com.xb.domain.Menutree;
import com.xb.domain.Permission;
import com.xb.domain.Role;
import com.xb.domain.User;
import com.xb.service.tree.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TreeServiceImpl implements TreeService {

	@Autowired
	private MenutreeMapper menutreemapper;
	@Autowired
	private RedisTemplate redisTemplate;
	@Override
	public List<Menutree> queryTree() {
		return menutreemapper.queryTree();
	}
	
//	没用的代码0.....
	@Override
	public Role selectMenuList(String roleid) {
		
		Set<String> resources =new HashSet<String>();
		//定义一个新的set集合接受角色
		Set<Permission> Permission =new HashSet<Permission>();
		List<Map<String, Object>> menuList = menutreemapper.selectMenuList(roleid);
		if (null != menuList && 0 < menuList.size()) {
			for (Map<String, Object> map : menuList) {
				if (map.get("pid").toString().equals("0")) {
					map.put("isParent", true);
				}
			}
		}
		Role login=new Role();
		
		for (Map<String, Object> map : menuList) {
			if(map.get("addPage")!=null && !"".equals(map.get("addPage"))){
				resources.add(map.get("addPage").toString());
			}
			Permission r=new Permission();
			r.settId(map.get("id").toString());
			r.settName(map.get("name").toString());
			Permission.add(r);
		}
		login.setResources(resources);
		login.setRoles(Permission);
		return login;
	}
	@Override
	public List<Map<String, Object>> selectMenuListDict() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> menuList = menutreemapper.selectMenuListDict();
		if (null != menuList && 0 < menuList.size()) {
			for (Map<String, Object> map : menuList) {
				if (map.get("pid").toString().equals("0")) {
					map.put("isParent", true);
				}
			}
		}
		return menuList;
	}
	@Override
	public void deletetree(String idss) {
		// TODO Auto-generated method stub
		menutreemapper.deletetree(idss);
		
	}
	@Override
	public void updatetree(Permission permission) {
		// TODO Auto-generated method stub
		menutreemapper.updatetree(permission);
	}
	@Override
	public void addtree(Permission permission) {
		// TODO Auto-generated method stub
		menutreemapper.addtree(permission);
	}
//	查看1.jsp的树
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectMenuLists(String parameter) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> menuList=null;
		Object object=null;
		if(parameter.equals("1")){
			 object = redisTemplate.opsForValue().get("menuList1");
			 if(object==null){
					menuList = menutreemapper.selectMenuLists(parameter);
					redisTemplate.opsForValue().set("menuList1", menuList);
				}else {
					 menuList =(ArrayList<Map<String, Object>>)object;
				}
			
		}else{
			object = redisTemplate.opsForValue().get("menuList2");
			if(object==null){
				menuList = menutreemapper.selectMenuLists(parameter);
				redisTemplate.opsForValue().set("menuList2", menuList);
			}else {
				 menuList =(ArrayList<Map<String, Object>>)object;
			}
		}
		
		if (null != menuList && 0 < menuList.size()) {
			for (Map<String, Object> map : menuList) {
				if (map.get("pid").toString().equals("0")) {
					map.put("isParent", true);
				}
			}
		}
		return menuList;
	}

	/* (non-Javadoc)    
	 * @see com.xb.service.tree.TreeService#selectTreeList()    
	 */
	@Override
	public List<Map<String, Object>> selectTreeList() {
		// TODO Auto-generated method stub
		
		return  menutreemapper.selectTreeList();
	}

	/* (non-Javadoc)    
	 * @see com.xb.service.tree.TreeService#findMenuByRoleId(java.lang.String)    
	 */
	@Override
	public List<Map<String, Object>> findMenuByRoleId(String roleid) {
		// TODO Auto-generated method stub
		return menutreemapper.selectMenuList(roleid);
	}

	/* (non-Javadoc)    
	 * @see com.xb.service.tree.TreeService#SaveByRoleId(java.lang.String, java.lang.String)    
	 */
	@Override
	public void SaveByRoleId(String menuIds, String roleid) {
		// TODO Auto-generated method stub
		menutreemapper.deleteByrole(roleid);
		if(menuIds!=null && !"".equals(menuIds)){
			String[] ids =menuIds.split(",");
			List<Map<String,String>> list =new ArrayList<Map<String,String>>();
			for (int i = 0; i < ids.length; i++) {
				Map<String,String> map =new HashMap<String,String>();
				map.put("roleid", roleid);
				map.put("treeid", ids[i].trim().toString());
				list.add(map);
			}
			menutreemapper.addRoleTreeRelation(list);
		}
		
	}

	/* (non-Javadoc)    
	 * @see com.xb.service.tree.TreeService#getCurrenUserNodes(查询当前用户所对应的权限  
	 */
	@SuppressWarnings("unused")
	@Override
	public Set<Map<String, Object>> getCurrenUserNodes(User user, String left) {
		// TODO Auto-generated method stub
		user.setLift(left);
		Set<Map<String, Object>> set=new HashSet<Map<String, Object>>();
		List<Map<String, Object>> menuList=null;
//		判断  修改权限标识符是否存在
		
		
		
		
//		把用户id加字符串设置为redis的key
		Object objects=user.getUserid()+"menuList1";
		Object objects2=user.getUserid()+"menuList2";
		Object object=null;
		Object object2=null;
		Boolean hasKey = redisTemplate.hasKey(objects);
		Boolean hasKey2 = redisTemplate.hasKey(objects2);
		if(left.equals("1")){
			 Object change = redisTemplate.opsForValue().get(user.getUserid()+"change");
			 boolean changeKey = redisTemplate.hasKey(user.getUserid()+"change");
			 if(!changeKey){
				 redisTemplate.opsForValue().set(user.getUserid()+"change", 1);	
			}else{
				redisTemplate.delete(user.getUserid()+"change");
				 redisTemplate.opsForValue().set(user.getUserid()+"change", 1);
			}
			
			
			 object = redisTemplate.opsForValue().get(user.getUserid()+"menuList1");
			 if(!hasKey){
						 
		//				 menuList=new ArrayList<Map<String, Object>>();
						 menuList=menutreemapper.getCurrenUserNodes(user);
							 set=new HashSet<Map<String, Object>>();
							for (Map<String, Object> map : menuList) {
									set.add(map);
							}
					redisTemplate.opsForValue().set(user.getUserid()+"menuList1", menuList);
				}else {
					 if(change.toString().equals("2")){
						 menuList=menutreemapper.getCurrenUserNodes(user);
						 set=new HashSet<Map<String, Object>>();
						for (Map<String, Object> map : menuList) {
								set.add(map);
						}
						redisTemplate.delete(user.getUserid()+"menuList1");  
						redisTemplate.opsForValue().set(user.getUserid()+"menuList1", menuList);
					 }else{
//					 menuList =(ArrayList<Map<String, Object>>)object;
					 menuList =(ArrayList<Map<String, Object>>)object;
						for (Map<String, Object> map : menuList) {
							set.add(map);
						}
					}
				}
			
		}else{
			 Object change1 = redisTemplate.opsForValue().get(user.getUserid()+"change1");
				boolean changeKey1 = redisTemplate.hasKey(user.getUserid()+"change1");
				
				if(!changeKey1){
					redisTemplate.opsForValue().set(user.getUserid()+"change1", 1);	
				}else{
					redisTemplate.delete(user.getUserid()+"change1");
					redisTemplate.opsForValue().set(user.getUserid()+"change1", 1);
				}
				
			
			object2 = redisTemplate.opsForValue().get(user.getUserid()+"menuList2");
			if(!hasKey2){
				 menuList=menutreemapper.getCurrenUserNodes(user);
				
					for (Map<String, Object> map : menuList) {
							set.add(map);
					}
				redisTemplate.opsForValue().set(user.getUserid()+"menuList2", menuList);
			}else {
				 if(change1.toString().equals("2")){
					 menuList=menutreemapper.getCurrenUserNodes(user);
					 set=new HashSet<Map<String, Object>>();
					for (Map<String, Object> map : menuList) {
							set.add(map);
					}
					redisTemplate.delete(user.getUserid()+"menuList2");
					redisTemplate.opsForValue().set(user.getUserid()+"menuList2", menuList);
				 }else{
				
				 menuList =(ArrayList<Map<String, Object>>)object2;
					for (Map<String, Object> map : menuList) {
						set.add(map);
					}
				 }
			}
		}
		return set;
	}
}

package com.xb.service.user.impl;

import com.xb.dao.user.UserDao;
import com.xb.domain.Role;
import com.xb.domain.User;
import com.xb.service.user.UserService;
import com.xb.util.GeetestConfig;
import com.xb.util.PageUtil;
import com.xb.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	    private UserDao userDao;
	 @Override
	public User findByUsername(String parameter) {
		User findByUsername = userDao.findByUsername(parameter);
		return findByUsername;
	}
	@Override
	public Map<String, Object> queryUser(int page, int rows) {
//		总条数
		long total = userDao.queryTotal();
		 PageUtil<User> pages = new PageUtil<>(page, total, rows);
//		 当前页数据
		 List<User> teas = userDao.PageList(pages.getStart(), pages.getEnd());

		 Map<String, Object> map = new HashMap<>();

		 map.put("total", total);
		 map.put("rows", teas);
		 return map;
	}

//	修改查询
	public User findByUserid(int userid) {
		// TODO Auto-generated constructor stub

		return	userDao.findByUserid(userid);
	}
	/* (non-Javadoc)
	 * @see com.xb.service.user.UserService#sendEmailMethod(java.lang.String)
	 */
	  @SuppressWarnings("unchecked")
	@Override
	public Map sendEmailMethod(String parameter) throws Exception {
		// TODO Auto-generated method stub
			 Map resultmMap = new HashMap<>();
		User u=	userDao.sendEmailMethod(parameter);
		if(null !=u){
	    	String randomCode = RandomUtil.getRandomCode(6);
//	    	redisTemplate.opsForValue().set(arg0, arg1, arg2, TimeUnit.SECONDS);;
	    	redisTemplate.opsForValue().set(u.getUsermobile().toString() + "_code", randomCode, 300, TimeUnit.SECONDS);
	    	GeetestConfig.sendMail(parameter,randomCode);
	    	 resultmMap.put("error", 0);
	         resultmMap.put("message", "发送成功！");
            return resultmMap;
		}
		resultmMap.put("error", 1);
        resultmMap.put("message", "由于各种原因 发送失败:请重新发送");
				return resultmMap;

	}
	/* (non-Javadoc)
	 * @see com.xb.service.user.UserService#updatePasswordMethod(com.xb.domain.User)
	 */
	@Override
	public Map updatePasswordMethod(User user) throws Exception {
		// TODO Auto-generated method stub
		 Map resultmMap = new HashMap<>();
		Object object = redisTemplate.opsForValue().get(user.getUsermobile() + "_code");
		if(null == object){
			//超时
			resultmMap.put("error", 1);
	        resultmMap.put("message", "由于各种原因 修改失败:由于验证码超时或错误！");
		}else if(object.toString().equals(user.getUserImgCode())){
			//正确
			userDao.updatePasswordMethod(user);
			//验证码立刻失效
			redisTemplate.delete(user.getUsermobile() +"_code");
			resultmMap.put("error", 0);
	        resultmMap.put("message", "修改成功！");
		}else{
			//验证码错误
		}
		return resultmMap;
	}
	/* (non-Javadoc)
	 * @see com.xb.service.user.UserService#getResourcesList(int)
	 */
	@Override
	public User getResourcesList(String parseInt) {
		// TODO Auto-generated method stub
		//定义一个新的set集合接收权限
		User login=new User();
				Set<String> resources =new HashSet<String>();
				//定义一个新的set集合接受角色
				Set<Role> roles =new HashSet<Role>();
				//定义一个新的list集合查询当前用户的角色和权限
				List<Map<String,Object>> list =new ArrayList<Map<String,Object>>();

				//查询对应角色和权限信息
				list = userDao.getResourcesList(parseInt);

				//把查询的结果放到user对象
				for (Map<String, Object> map : list) {
					if(map.get("t_text")!=null && !"".equals(map.get("t_text"))){
						resources.add(map.get("t_text").toString());
					}
					Role r =new Role();
					r.setrId(map.get("r_id").toString());
					r.setrName(map.get("r_name").toString());
					roles.add(r);
				}
				//把查询的所有内容都放到user中
				login.setResources(resources);
				login.setRoles(roles);

		return login;
	}
	/* (non-Javadoc)
	 * @see com.xb.service.user.UserService#addUser(com.xb.domain.User)
	 */
	@Override
	public void addUser(User user) {
		user.setUserid(UUID.randomUUID().toString());
		user.setUserlock(1);
		userDao.addUser(user);

	}

	/* (non-Javadoc)
	 * @see com.xb.service.user.UserService#updateUserLock(com.xb.domain.User)
	 */
	@Override
	public void updateUserLock(User user) {
		userDao.updateUserLocks(user);
	}

	/* (non-Javadoc)
	 * @see com.xb.service.user.UserService#checkName(com.xb.domain.User)
	 */
	@Override
	public String checkName(User user) {
		List<User> namesize = userDao.checkName(user);
		if(namesize.size() == 1){
//			用户名已存在
			return "checkNameError";
		}else{
//			用户名不存在
			return "checkNameSuccess";
		}
	}

	/* (non-Javadoc)
	 * @see com.xb.service.user.UserService#updateLoginUser(com.xb.domain.User, javax.servlet.http.HttpSession)
	 */
	@Override
	public String updateLoginUser(User user, HttpSession session) {
		//获取session验证码内容
			String checkImg = (String)session.getAttribute("rand");

			 Integer count = (Integer)session.getAttribute("count");
				if(count == null){
					count=1;
				}
			 //判断验证码
			 if(checkImg.equals(user.getCheckImg())){
		//		 判断用户名是否存在
				 List<User> nameFalg = userDao.UserFalg(user);
				 if(nameFalg.size() == 1){
//					 session.setAttribute("userInfo", user);
		//			   判断用户是否被锁定
					 List<User> lockUser = userDao.lockUser(user);
					 if(lockUser.size() == 0){
						 List<User> userList = userDao.loginUserName(user);
						 if(userList.size() == 1){
							 return "LoginSuccerr";
						 }else{
							 if(count == 3){
								 userDao.updateUserLock(user);
//								 session.removeValue("count");
		//						 锁定用户
								 return "LoginLock";
							 }else{
								 session.setAttribute("count", ++count);
							 }
		//					 登录失败  密码错误
							 return "LoginError";
						 }
					 }else{
		//				 用户锁定
						 return "LoginUserLock";
					 }
				 }else{
		//			 用户名不存在
					 return "LoginNameError";
				 }
				}else{
//					验证码错误
					return "ImgError";
				}
	}
	/* (non-Javadoc)
	 * @see com.xb.service.user.UserService#queryUsers()
	 */
	@Override
	public List<User> queryUsers() {

		// TODO Auto-generated method stub
		return userDao.queryUsers();
	}



}

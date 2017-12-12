package com.xb.service.user;

import com.xb.domain.User;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UserService {

	User findByUsername(String parameter);

	Map<String, Object> queryUser(int page, int rows);

	User findByUserid(int userid);

	/** <pre>sendEmailMethod(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月23日 下午7:36:32    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月23日 下午7:36:32    
	 * 修改备注： 
	 * @param parameter</pre>    
	 * @return 
	 */
	Map sendEmailMethod(String parameter) throws Exception;

	/** <pre>updatePasswordMethod(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月23日 下午10:00:13    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月23日 下午10:00:13    
	 * 修改备注： 
	 * @param user</pre>    
	 * @return 
	 */
	Map updatePasswordMethod(User user)throws Exception;
	/** <pre>getResourcesList(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月28日 下午9:59:26    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月28日 下午9:59:26    
	 * 修改备注： 
	 * @param userId
	 * @return</pre>    
	 */
	User getResourcesList(String userId);

	/** <pre>addUser(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月30日 下午3:26:23    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月30日 下午3:26:23    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void addUser(User user);

	/** <pre>updateLoginUser(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月30日 下午3:26:49    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月30日 下午3:26:49    
	 * 修改备注： 
	 * @param user
	 * @param session
	 * @return</pre>    
	 */
	String updateLoginUser(User user, HttpSession session);

	/** <pre>updateUserLock(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月30日 下午3:27:08    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月30日 下午3:27:08    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void updateUserLock(User user);

	/** <pre>checkName(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月30日 下午3:27:34    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月30日 下午3:27:34    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
	String checkName(User user);

	/** <pre>queryUsers(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年12月5日 下午4:56:12    
	 * 修改人：杨兴北 
	 * 修改时间：2017年12月5日 下午4:56:12    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<User> queryUsers();


}

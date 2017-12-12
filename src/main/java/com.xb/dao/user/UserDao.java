package com.xb.dao.user;

import com.xb.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public User findByUsername(String username);

	public long queryTotal();

	public List<User> PageList(@Param("start") int start, @Param("end") int end);

	public User findByUserid(int userid);

	/** <pre>sendEmailMethod(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月23日 下午7:38:12    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月23日 下午7:38:12    
	 * 修改备注： 
	 * @param parameter
	 * @return</pre>    
	 */
	public User sendEmailMethod(String parameter) throws Exception;

	/** <pre>updatePasswordMethod(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月23日 下午10:01:43    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月23日 下午10:01:43    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	public void updatePasswordMethod(User user)throws Exception;

	public void addUser(User user);

	public void updateUserLocks(User user);

	public List<User> checkName(User user);

	public List<User> UserFalg(User user);

	public List<User> lockUser(User user);

	public List<User> loginUserName(User user);

	public void updateUserLock(User user);

	/** <pre>getResourcesList(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月30日 下午3:07:02    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月30日 下午3:07:02    
	 * 修改备注： 
	 * @param parseInt
	 * @return</pre>    
	 */
	public List<Map<String, Object>> getResourcesList(String parseInt);

	/** <pre>queryUsers(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年12月5日 下午4:57:07    
	 * 修改人：杨兴北 
	 * 修改时间：2017年12月5日 下午4:57:07    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public List<User> queryUsers();
}
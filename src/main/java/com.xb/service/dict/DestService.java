package com.xb.service.dict;

import com.xb.domain.Paramerta;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface DestService {

	/** <pre>selectByPrimaryKey(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月23日 上午11:42:26    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月23日 上午11:42:26    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Paramerta> selectByPrimaryKey();

	/** <pre>updateByPrimaryKeySelective(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月23日 下午2:15:56    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月23日 下午2:15:56    
	 * 修改备注： 
	 * @param paramert
	 * @return</pre>    
	 */
	void updateByPrimaryKeySelective(Paramerta paramert);

	/** <pre>updateByPrimaryKeySelectivea(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月24日 下午7:19:35    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月24日 下午7:19:35    
	 * 修改备注： 
	 * @param paramert</pre>    
	 */
	void updateByPrimaryKeySelectivea(Paramerta paramert);

	/** <pre>uploadPicture(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月27日 下午2:20:29    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月27日 下午2:20:29    
	 * 修改备注： 
	 * @param fileName
	 * @param request 
	 * @return</pre>    
	 */
	Map uploadPicture(MultipartFile fileName, HttpServletRequest request);

	/** <pre>getHeicharts(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年12月8日 下午5:32:21    
	 * 修改人：杨兴北 
	 * 修改时间：2017年12月8日 下午5:32:21    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Map<String, Object>> getHeicharts();

	/** <pre>getHeichartsA(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年12月8日 下午8:18:29    
	 * 修改人：杨兴北 
	 * 修改时间：2017年12月8日 下午8:18:29    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Map<String, Object>> getHeichartsA();



}

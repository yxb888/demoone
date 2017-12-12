package com.xb.dao.dict;

import com.xb.domain.Picture;
import com.xb.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PictureDao {

    int insert(Picture record);

    int insertSelective(Picture record);

	/** <pre>queryTotal(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年12月1日 下午7:46:56    
	 * 修改人：杨兴北 
	 * 修改时间：2017年12月1日 下午7:46:56    
	 * 修改备注： 
	 * @return</pre>    
	 */
	long queryTotal();

	/** <pre>PageList(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年12月1日 下午7:47:01    
	 * 修改人：杨兴北 
	 * 修改时间：2017年12月1日 下午7:47:01    
	 * 修改备注： 
	 * @param start
	 * @param end
	 * @return</pre>    
	 */
	List<User> PageList(@Param("start") int start, @Param("end") int end);
}
package com.xb.dao.ziyuanzhishi;

import com.xb.domain.ziyuanzhishi;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ziyuanzhishiMapper {
    int deleteByPrimaryKey(String tId);

    int insert(ziyuanzhishi record);

    int insertSelective(ziyuanzhishi record);

    ziyuanzhishi selectByPrimaryKey(String tId);

    int updateByPrimaryKeySelective(ziyuanzhishi record);

    int updateByPrimaryKey(ziyuanzhishi record);

	/** <pre>queryTotal(这里用一句话描述这个方法的作用)   
	 * 创建人：梁飞
	 * 创建时间：2017年11月23日 上午9:12:48    
	 * 修改人：梁飞   
	 * 修改时间：2017年11月23日 上午9:12:48    
	 * 修改备注： 
	 * @param zs
	 * @return</pre>    
	 */
	long queryTotal(ziyuanzhishi zs);
	
	List<ziyuanzhishi> PageList(@Param("start") int start, @Param("end") int end, @Param("zs") ziyuanzhishi zs);

	/** <pre>queryaddress(这里用一句话描述这个方法的作用)   
	 * 创建人：梁飞
	 * 创建时间：2017年11月23日 下午2:15:55    
	 * 修改人：梁飞   
	 * 修改时间：2017年11月23日 下午2:15:55    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<ziyuanzhishi> queryaddress();

}
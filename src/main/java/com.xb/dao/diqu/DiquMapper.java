package com.xb.dao.diqu;

import com.xb.domain.Diqu;
import com.xb.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiquMapper {
    int deleteByPrimaryKey(String tId);

    int insert(Diqu record);

    int insertSelective(Diqu record);

    Diqu selectByPrimaryKey(String tId);

    int updateByPrimaryKeySelective(Diqu record);

    int updateByPrimaryKey(Diqu record);



	public void deleteAll(String[] tId);

	void addDiqu(Diqu dq);

	long queryTotal(Diqu dq);

	List<User> PageList(@Param("start") int start, @Param("end") int end, @Param("dq") Diqu dq);

	void deleteOne(String id);

	/** <pre>queryById(这里用一句话描述这个方法的作用)   
	 * 创建人：梁飞
	 * 创建时间：2017年11月20日 下午6:40:05    
	 * 修改人：梁飞   
	 * 修改时间：2017年11月20日 下午6:40:05    
	 * 修改备注： 
	 * @param diqu
	 * @return</pre>    
	 */
	Diqu queryById(Diqu diqu);

	/** <pre>updDQSave(这里用一句话描述这个方法的作用)   
	 * 创建人：梁飞
	 * 创建时间：2017年11月20日 下午7:23:38    
	 * 修改人：梁飞   
	 * 修改时间：2017年11月20日 下午7:23:38    
	 * 修改备注： 
	 * @param diqu</pre>    
	 */
	void updateDQSave(Diqu diqu);

	/** <pre>retriveById(这里用一句话描述这个方法的作用)   
	 * 创建人：杨兴北   
	 * 创建时间：2017年11月30日 下午9:38:54    
	 * 修改人：杨兴北 
	 * 修改时间：2017年11月30日 下午9:38:54    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Diqu> retriveById();




}
package com.xb.dao.ziyuanzhishi;

import com.xb.domain.ziyuanzhishitype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ziyuanzhishitypeMapper {


	/** <pre>queryTotal2(这里用一句话描述这个方法的作用)   
   
	 */
    long queryTotal2(ziyuanzhishitype zstp);

	/** <pre>PageList2(这里用一句话描述这个方法的作用)   
	 * 创建人：梁飞
   
	 */
	List<ziyuanzhishitype> PageList2(@Param("start") int start, @Param("end") int end, @Param("zs") ziyuanzhishitype zstp);

	/** <pre>addType(这里用一句话描述这个方法的作用)   
	 * 创建人：梁飞
	 * 创建时间：2017年11月30日 下午8:19:09    
	 * 修改人：梁飞   
	 * 修改时间：2017年11月30日 下午8:19:09    
	 * 修改备注： 
	 * @param tp</pre>    
	 */
	void addType(ziyuanzhishitype tp);}
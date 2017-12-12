package com.xb.dao.gangwei;

import com.xb.domain.GangWei;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GangWeiMapper {
    int deleteByPrimaryKey(String tGwId);

    int insert(GangWei record);

    int insertSelective(GangWei record);

    GangWei selectByPrimaryKey(String tGwId);

    int updateByPrimaryKeySelective(GangWei record);

    int updateByPrimaryKey(GangWei record);

	long queryTotal();

	 List<GangWei> PageList(@Param("start") int start, @Param("end") int end);

	void delAllGangWei(String[] id);

	void addGangWei(GangWei gw);

	GangWei queryGangWei(GangWei gw);

	void updateDQSave(GangWei gw);

   
   
}
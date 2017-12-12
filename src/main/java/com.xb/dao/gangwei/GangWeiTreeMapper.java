package com.xb.dao.gangwei;

import com.xb.domain.GangWeiTree;

public interface GangWeiTreeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GangWeiTree record);

    int insertSelective(GangWeiTree record);

    GangWeiTree selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GangWeiTree record);

    int updateByPrimaryKey(GangWeiTree record);
}
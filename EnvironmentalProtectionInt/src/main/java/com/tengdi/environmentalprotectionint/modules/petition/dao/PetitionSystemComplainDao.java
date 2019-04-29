package com.tengdi.environmentalprotectionint.modules.petition.dao;

import com.tengdi.environmentalprotectionint.modules.petition.entity.PetitionSystemComplainEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 信访投诉
 * 
 * @author tengdi
 * @email 
 * @date 2018-11-20 09:53:05
 */
public interface PetitionSystemComplainDao extends BaseMapper<PetitionSystemComplainEntity> {

    List<PetitionSystemComplainEntity> queryList(Map<String,Object> map);

	int queryCount(Map<String,Object> map);

    List<PetitionSystemComplainEntity> dataById(String cid);

    PetitionSystemComplainEntity entityById(String pid);
}

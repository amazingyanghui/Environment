package com.tengdi.environmentalprotectionint.modules.petition.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.petition.entity.PetitionSystemComplainEntity;

import java.util.List;
import java.util.Map;

/**
 * 信访投诉
 *
 * @author tengdi
 * @email 
 * @date 2018-11-20 09:53:05
 */
public interface PetitionSystemComplainService extends IService<PetitionSystemComplainEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<PetitionSystemComplainEntity> queryList(Map<String,Object> map);

    List<PetitionSystemComplainEntity> dataById(String cid);

    PetitionSystemComplainEntity entityById(String pid);
}


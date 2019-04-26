package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoRepairRecordEntity;

import java.util.Map;

/**
 * 治理设施维护记录表
 *
 * @author tengdi
 * @email 
 * @date 2018-10-19 15:19:06
 */
public interface CominfoRepairRecordService extends IService<CominfoRepairRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


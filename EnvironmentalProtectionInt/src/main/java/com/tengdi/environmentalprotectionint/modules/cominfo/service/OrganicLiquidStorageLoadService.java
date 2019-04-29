package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.OrganicLiquidStorageLoadEntity ;

import java.util.List;
import java.util.Map;

/**
 * 工业企业有机液体储罐、装载信息
 *
 * @author tengdi
 * @email 
 * @date 2019-03-07 16:15:35
 */
public interface OrganicLiquidStorageLoadService extends IService<OrganicLiquidStorageLoadEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<OrganicLiquidStorageLoadEntity> queryList(Map<String, Object> params);

}


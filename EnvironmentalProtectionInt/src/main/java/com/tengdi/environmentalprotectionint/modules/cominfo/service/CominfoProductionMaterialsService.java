package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionMaterialsEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 主要原辅助材料
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:42:35
 */
public interface CominfoProductionMaterialsService extends IService<CominfoProductionMaterialsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CominfoProductionMaterialsEntity> queryList(Map<String, Object> params);
}


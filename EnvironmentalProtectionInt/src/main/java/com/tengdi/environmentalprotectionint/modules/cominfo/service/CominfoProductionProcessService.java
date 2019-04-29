package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionProcessEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 生产工艺
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:42:28
 */
public interface CominfoProductionProcessService extends IService<CominfoProductionProcessEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CominfoProductionProcessEntity> queryList(Map<String, Object> params);
}


package com.tengdi.environmentalprotectionint.modules.greentax.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpAtmosphereTaxEntity;
import java.util.Map;

/**
 * 大气水排放税上报
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 09:50:05
 */
public interface EpAtmosphereTaxService extends IService<EpAtmosphereTaxEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryTableData(Map<String, Object> params);
    /**
     * 更新排口（计算方法）
     */
    void updateOnlineMonitorPortinfoEntity(Map<String, Object> params);
}


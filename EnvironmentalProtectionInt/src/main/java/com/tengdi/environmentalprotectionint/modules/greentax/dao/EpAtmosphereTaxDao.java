package com.tengdi.environmentalprotectionint.modules.greentax.dao;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpAtmosphereTaxEntity;
import java.util.List;
import java.util.Map;
/**
 * 大气水排放税上报
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-06 09:50:05
 */
public interface EpAtmosphereTaxDao extends BaseMapper<EpAtmosphereTaxEntity> {
    List<Map<String,Object>> queryList(Map<String, Object> params);

    int queryListCount(Map<String, Object> params);

      void updateOnlineMonitorPortinfoEntity(Map<String, Object> params);
}

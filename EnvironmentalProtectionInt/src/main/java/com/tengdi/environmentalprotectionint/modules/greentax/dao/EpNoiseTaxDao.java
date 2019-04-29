package com.tengdi.environmentalprotectionint.modules.greentax.dao;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpNoiseTaxEntity;
import java.util.List;
import java.util.Map;
/**
 * 噪音环保税上报
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-06 09:51:49
 */
public interface EpNoiseTaxDao extends BaseMapper<EpNoiseTaxEntity> {
    List<Map<String,Object>> queryList(Map<String, Object> params);

    int queryListCount(Map<String, Object> params);
}

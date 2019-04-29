package com.tengdi.environmentalprotectionint.modules.greentax.dao;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteTaxEntity;
import java.util.List;
import java.util.Map;
/**
 * 固体废物环保税上报
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-06 09:52:02
 */
public interface EpSolidWasteTaxDao extends BaseMapper<EpSolidWasteTaxEntity> {
    List<Map<String,Object>> queryList(Map<String, Object> params);

    int queryListCount(Map<String, Object> params);
}

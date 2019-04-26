package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.OrganicLiquidStorageLoadEntity ;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
/**
 * 工业企业有机液体储罐、装载信息
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-07 16:15:35
 */
public interface OrganicLiquidStorageLoadDao extends BaseMapper<OrganicLiquidStorageLoadEntity> {
    List<Map<String,Object>> queryList(QueryCriterias criterias);

    int queryListCount(QueryCriterias criterias);
}

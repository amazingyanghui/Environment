package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoCentralizedHazardouswasteEntity ;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
/**
 * 危险废物集中处置厂运行情况
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:37:58
 */
public interface CominfoCentralizedHazardouswasteDao extends BaseMapper<CominfoCentralizedHazardouswasteEntity> {
    List<Map<String,Object>> queryList(QueryCriterias criterias);

    int queryListCount(QueryCriterias criterias);
}

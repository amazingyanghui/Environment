package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.tengdi.core.utils.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoWasteProcessPlaceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
/**
 * (固废,危险)废物处理场所
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-07 16:51:37
 */
public interface CominfoWasteProcessPlaceDao extends BaseMapper<CominfoWasteProcessPlaceEntity> {
    List<Map<String,Object>> queryList(QueryCriterias criterias);

    int queryListCount(QueryCriterias criterias);
}

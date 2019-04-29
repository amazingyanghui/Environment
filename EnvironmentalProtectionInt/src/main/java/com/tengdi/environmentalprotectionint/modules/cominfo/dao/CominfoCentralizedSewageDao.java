package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoCentralizedSewageEntity ;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
/**
 * 集中式污水处理厂运行情况
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:38:07
 */
public interface CominfoCentralizedSewageDao extends BaseMapper<CominfoCentralizedSewageEntity> {
    List<Map<String,Object>> queryList(QueryCriterias criterias);

    int queryListCount(QueryCriterias criterias);
}

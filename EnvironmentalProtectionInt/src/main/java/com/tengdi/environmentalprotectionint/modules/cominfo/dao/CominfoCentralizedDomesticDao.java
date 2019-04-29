package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoCentralizedDomesticEntity ;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
/**
 * 生活垃圾集中处置厂运行情况
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:38:04
 */
public interface CominfoCentralizedDomesticDao extends BaseMapper<CominfoCentralizedDomesticEntity> {
    List<Map<String,Object>> queryList(Map<String, Object> params);

    int queryCount(Map<String, Object> params);
}

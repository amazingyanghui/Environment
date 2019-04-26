package com.tengdi.environmentalprotectionint.modules.online.dao;

import com.tengdi.core.utils.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.online.entity.EnterprisesDischargeCoefficientEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
/**
 * 工业企业污染物产排污系数核算信息
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-08 14:08:30
 */
public interface EnterprisesDischargeCoefficientDao extends BaseMapper<EnterprisesDischargeCoefficientEntity> {
    List<Map<String,Object>> queryList(QueryCriterias criterias);

    int queryListCount(QueryCriterias criterias);

    List<EnterprisesDischargeCoefficientEntity> queryData(Map<String,Object> params);

    int queryCount(Map<String,Object> params);
}

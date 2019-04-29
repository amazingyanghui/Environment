package com.tengdi.environmentalprotectionint.modules.online.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.QueryCriterias;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.online.entity.EnterprisesDischargeCoefficientEntity;
import java.util.Map;

/**
 * 工业企业污染物产排污系数核算信息
 *
 * @author tengdi
 * @email 
 * @date 2019-03-08 14:08:30
 */
public interface EnterprisesDischargeCoefficientService extends IService<EnterprisesDischargeCoefficientEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryTableData(QueryCriterias criterias);
}


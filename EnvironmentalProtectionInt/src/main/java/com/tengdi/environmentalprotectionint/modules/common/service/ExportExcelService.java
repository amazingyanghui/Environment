package com.tengdi.environmentalprotectionint.modules.common.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.common.entity.ExportExcelData;
import com.tengdi.core.utils.PageUtils;

/**
 * 导出Excel
 *
 * @author tengdi
 * @email 
 * @date 2018-08-22 10:03:40
 */
public interface ExportExcelService extends IService<ExportExcelData> {

    PageUtils queryList(ExportExcelData criterias);

    String getLawEnforcementType(String lawEnforcementType);

}


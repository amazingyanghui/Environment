package com.tengdi.environmentalprotectionint.modules.common.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.common.entity.ImportExcelEntity;

/**
 * 导出Excel
 *
 * @author tengdi
 * @email 
 * @date 2018-08-22 10:03:40
 */
public interface ImportExcelService extends IService<ImportExcelEntity> {
    Integer insertData(ImportExcelEntity entity);
}


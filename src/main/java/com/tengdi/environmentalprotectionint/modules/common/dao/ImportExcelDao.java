package com.tengdi.environmentalprotectionint.modules.common.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.common.entity.ImportExcelEntity;

/**
 *
 * @author tengdi
 * @email
 * @date 2018-08-22 10:03:40
 */
public interface ImportExcelDao extends BaseMapper<ImportExcelEntity> {
    Integer insertData(ImportExcelEntity entity);

}

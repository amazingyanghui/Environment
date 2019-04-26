package com.tengdi.environmentalprotectionint.modules.common.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.environmentalprotectionint.modules.common.dao.ImportExcelDao;
import com.tengdi.environmentalprotectionint.modules.common.entity.ImportExcelEntity;
import com.tengdi.environmentalprotectionint.modules.common.service.ImportExcelService;
import org.springframework.stereotype.Service;

@Service("importExcelService")
public class ImportExcelServiceImpl extends ServiceImpl<ImportExcelDao, ImportExcelEntity> implements ImportExcelService {

    @Override
    public Integer insertData(ImportExcelEntity entity) {
        return baseMapper.insertData(entity);
    }
}

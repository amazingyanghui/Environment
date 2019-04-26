package com.tengdi.environmentalprotectionint.modules.penalty.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.penalty.entity.AdministrativePenaltyFileEntity;

import java.util.List;
import java.util.Map;

/**
 * 处罚资料文件
 *
 * @author tengdi
 * @email 
 * @date 2018-10-29 14:27:40
 */
public interface AdministrativePenaltyFileService extends IService<AdministrativePenaltyFileEntity> {

    PageUtils queryPage(Map<String, Object> params);
    /**
     * 根据行政处罚id查附件
     * @param aid
     * @return
     */
    List<AdministrativePenaltyFileEntity> dataByFile(String aid);
}


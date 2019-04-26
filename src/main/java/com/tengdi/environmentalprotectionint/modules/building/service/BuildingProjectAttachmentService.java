package com.tengdi.environmentalprotectionint.modules.building.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.building.entity.BuildingProjectAttachmentEntity;
import com.tengdi.core.utils.PageUtils;


import java.util.List;
import java.util.Map;

/**
 * 审批/批复文件
 *
 * @author tengdi
 * @email 
 * @date 2018-09-07 17:55:13
 */
public interface BuildingProjectAttachmentService extends IService<BuildingProjectAttachmentEntity> {

    PageUtils queryPage(Map<String, Object> params);

    BuildingProjectAttachmentEntity getBuildFile(String pid);

    /**
     * 根据项目id查附件
     * @param bid
     * @return
     */
    List<BuildingProjectAttachmentEntity> dataByFile(String bid);
}


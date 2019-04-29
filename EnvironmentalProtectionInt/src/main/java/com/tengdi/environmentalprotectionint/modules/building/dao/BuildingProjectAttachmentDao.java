package com.tengdi.environmentalprotectionint.modules.building.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.building.entity.BuildingProjectAttachmentEntity;

import java.util.List;

/**
 * 审批/批复文件
 * 
 * @author tengdi
 * @email 
 * @date 2018-09-07 17:55:13
 */
public interface BuildingProjectAttachmentDao extends BaseMapper<BuildingProjectAttachmentEntity> {

    BuildingProjectAttachmentEntity getBuildFile(String pid);

    /**
     * 根据项目id查附件
     * @param bid
     * @return
     */
    List<BuildingProjectAttachmentEntity> dataByFile(String bid);
}

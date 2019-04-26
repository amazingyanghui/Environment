package com.tengdi.environmentalprotectionint.modules.building.service.impl;

import com.tengdi.environmentalprotectionint.modules.building.dao.BuildingProjectAttachmentDao;
import com.tengdi.environmentalprotectionint.modules.building.entity.BuildingProjectAttachmentEntity;
import com.tengdi.environmentalprotectionint.modules.building.service.BuildingProjectAttachmentService;
import com.tengdi.core.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;



@Service("buildingProjectAttachmentService")
public class BuildingProjectAttachmentServiceImpl extends ServiceImpl<BuildingProjectAttachmentDao, BuildingProjectAttachmentEntity> implements BuildingProjectAttachmentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String buildingProjectAttachmentName = (String)params.get("buildingProjectAttachmentName");
        Page<BuildingProjectAttachmentEntity> page = this.selectPage(
                new Query<BuildingProjectAttachmentEntity>(params).getPage(),
                new EntityWrapper<BuildingProjectAttachmentEntity>()
                        .like(StringUtils.isNotBlank(buildingProjectAttachmentName),"buildingProjectAttachmentName", buildingProjectAttachmentName)
        );

        return new PageUtils(page);
    }

    @Override
    public BuildingProjectAttachmentEntity getBuildFile(String pid) {
        return baseMapper.getBuildFile(pid);
    }

    @Override
    public List<BuildingProjectAttachmentEntity> dataByFile(String bid) {
        return baseMapper.dataByFile(bid);
    }

}

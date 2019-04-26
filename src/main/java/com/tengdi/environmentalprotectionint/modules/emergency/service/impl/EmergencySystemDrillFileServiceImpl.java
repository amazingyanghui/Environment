package com.tengdi.environmentalprotectionint.modules.emergency.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

import com.tengdi.environmentalprotectionint.modules.emergency.dao.EmergencySystemDrillFileDao;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemDrillFileEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemDrillFileService;


@Service("emergencySystemDrillFileService")
public class EmergencySystemDrillFileServiceImpl extends ServiceImpl<EmergencySystemDrillFileDao, EmergencySystemDrillFileEntity> implements EmergencySystemDrillFileService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String emergencySystemDrillFileName = (String)params.get("emergencySystemDrillFileName");
        Page<EmergencySystemDrillFileEntity> page = this.selectPage(
                new Query<EmergencySystemDrillFileEntity>(params).getPage(),
                new EntityWrapper<EmergencySystemDrillFileEntity>()
                        .like(StringUtils.isNotBlank(emergencySystemDrillFileName),"emergencySystemDrillFileName", emergencySystemDrillFileName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<EmergencySystemDrillFileEntity> dataByFile(String aid) {
        return baseMapper.dataByFile(aid);
    }

}

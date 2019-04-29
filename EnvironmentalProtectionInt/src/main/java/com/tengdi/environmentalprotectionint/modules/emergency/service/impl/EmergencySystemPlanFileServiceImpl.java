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

import com.tengdi.environmentalprotectionint.modules.emergency.dao.EmergencySystemPlanFileDao;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemPlanFileEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemPlanFileService;


@Service("emergencySystemPlanFileService")
public class EmergencySystemPlanFileServiceImpl extends ServiceImpl<EmergencySystemPlanFileDao, EmergencySystemPlanFileEntity> implements EmergencySystemPlanFileService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String emergencySystemPlanFileName = (String)params.get("emergencySystemPlanFileName");
        Page<EmergencySystemPlanFileEntity> page = this.selectPage(
                new Query<EmergencySystemPlanFileEntity>(params).getPage(),
                new EntityWrapper<EmergencySystemPlanFileEntity>()
                        .like(StringUtils.isNotBlank(emergencySystemPlanFileName),"emergencySystemPlanFileName", emergencySystemPlanFileName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<EmergencySystemPlanFileEntity> dataByFile(String aid) {
        return baseMapper.dataByFile(aid);
    }

}

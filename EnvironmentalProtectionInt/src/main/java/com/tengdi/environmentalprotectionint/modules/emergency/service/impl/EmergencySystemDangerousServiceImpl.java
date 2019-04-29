package com.tengdi.environmentalprotectionint.modules.emergency.service.impl;

import com.tengdi.environmentalprotectionint.modules.emergency.dao.EmergencySystemDangerousDao;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemDangerousEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemDangerousService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

@Service("emergencySystemDangerousService")
public class EmergencySystemDangerousServiceImpl extends ServiceImpl<EmergencySystemDangerousDao, EmergencySystemDangerousEntity> implements EmergencySystemDangerousService {
    @Override
    public EmergencySystemDangerousEntity entityById(String pid) {
        return baseMapper.entityById(pid);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        int page =Integer.parseInt((String)params.get("page"));
        int limit =Integer.parseInt((String)params.get("limit"));
        Query query = new Query(params);
        List<EmergencySystemDangerousEntity> list =baseMapper.queryPage(query);
        int totalCount =baseMapper.queryPageSum(params);
        return new PageUtils(list,totalCount,limit,page);
    }

    @Override
    public List<EmergencySystemDangerousEntity> queryList(Map<String, Object> params) {
        List<EmergencySystemDangerousEntity> list=baseMapper.queryPage(params);
        return list;
    }

    @Override
    public List<EmergencySystemDangerousEntity> queryName(Map<String, Object> params) {
        return baseMapper.queryName(params);
    }

    @Override
    public List<EmergencySystemDangerousEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

}

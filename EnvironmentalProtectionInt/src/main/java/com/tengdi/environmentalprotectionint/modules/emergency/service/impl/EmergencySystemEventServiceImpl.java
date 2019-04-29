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

import com.tengdi.environmentalprotectionint.modules.emergency.dao.EmergencySystemEventDao;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemEventEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemEventService;


@Service("emergencySystemEventService")
public class EmergencySystemEventServiceImpl extends ServiceImpl<EmergencySystemEventDao, EmergencySystemEventEntity> implements EmergencySystemEventService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String emergencySystemEventName = (String)params.get("emergencySystemEventName");
        String cid=(String)params.get("cid");
        Page<EmergencySystemEventEntity> page = this.selectPage(
                new Query<EmergencySystemEventEntity>(params).getPage(),
                new EntityWrapper<EmergencySystemEventEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid)
                        .like(StringUtils.isNotBlank(emergencySystemEventName),"emergencySystemEventName", emergencySystemEventName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<EmergencySystemEventEntity> queryList(Map<String, Object> params) {
        List<EmergencySystemEventEntity> list=baseMapper.queryList(params);
        return list;
    }

    @Override
    public List<EmergencySystemEventEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

    @Override
    public EmergencySystemEventEntity entityById(String pid) {
        return baseMapper.entityById(pid);
    }

    @Override
    public List<EmergencySystemEventEntity> queryName(Map<String, Object> params) {
        return baseMapper.queryName(params);
    }

    @Override
    public PageUtils queryPageSql(Map<String, Object> params) {
        Integer limit = Integer.parseInt((String)params.get("limit"));
        Integer page = Integer.parseInt((String)params.get("page"));
        Query query = new Query(params);
        List<EmergencySystemEventEntity> list = baseMapper.queryList(query);
        int count = baseMapper.count(params);
        return new PageUtils(list,count,limit,page);
    }
}

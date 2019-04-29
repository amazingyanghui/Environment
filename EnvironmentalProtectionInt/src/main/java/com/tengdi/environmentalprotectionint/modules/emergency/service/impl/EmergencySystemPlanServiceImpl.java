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

import com.tengdi.environmentalprotectionint.modules.emergency.dao.EmergencySystemPlanDao;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemPlanEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemPlanService;


@Service("emergencySystemPlanService")
public class EmergencySystemPlanServiceImpl extends ServiceImpl<EmergencySystemPlanDao, EmergencySystemPlanEntity> implements EmergencySystemPlanService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String emergencySystemPlanName = (String)params.get("emergencySystemPlanName");
        String cid=(String)params.get("cid");
        Page<EmergencySystemPlanEntity> page = this.selectPage(
                new Query<EmergencySystemPlanEntity>(params).getPage(),
                new EntityWrapper<EmergencySystemPlanEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid)
                        .like(StringUtils.isNotBlank(emergencySystemPlanName),"emergencySystemPlanName", emergencySystemPlanName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<EmergencySystemPlanEntity> queryList(Map<String, Object> params) {
        List<EmergencySystemPlanEntity> list=baseMapper.queryList(params);

        return list;
    }

    @Override
    public List<EmergencySystemPlanEntity> queryName(Map<String, Object> params) {
        return baseMapper.queryName(params);
    }

    @Override
    public List<EmergencySystemPlanEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

    @Override
    public EmergencySystemPlanEntity entityById(String pid) {
        return baseMapper.entityById(pid);
    }

    @Override
    public String insertData(EmergencySystemPlanEntity entity) {
        int count=baseMapper.insertData(entity);
        return entity.getPid();
    }

    @Override
    public PageUtils queryPageSql(Map<String, Object> params) {
        Integer limit = Integer.parseInt((String)params.get("limit"));
        Integer page = Integer.parseInt((String)params.get("page"));
        Query query = new Query(params);
        List<EmergencySystemPlanEntity> list = baseMapper.queryList(query);
        int count = baseMapper.count(params);
        return new PageUtils(list,count,limit,page);
    }
}

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

import com.tengdi.environmentalprotectionint.modules.emergency.dao.EmergencySystemDrillDao;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemDrillEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemDrillService;

@Service("emergencySystemDrillService")
public class EmergencySystemDrillServiceImpl extends ServiceImpl<EmergencySystemDrillDao, EmergencySystemDrillEntity> implements EmergencySystemDrillService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String emergencySystemDrillName = (String)params.get("emergencySystemDrillName");
        String cid=(String)params.get("cid");
        Page<EmergencySystemDrillEntity> page = this.selectPage(
                new Query<EmergencySystemDrillEntity>(params).getPage(),
                new EntityWrapper<EmergencySystemDrillEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid)
                        .like(StringUtils.isNotBlank(emergencySystemDrillName),"emergencySystemDrillName", emergencySystemDrillName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<EmergencySystemDrillEntity> queryList(Map<String, Object> params) {
        List<EmergencySystemDrillEntity> list=baseMapper.queryList(params);
        return list;
    }

    @Override
    public List<EmergencySystemDrillEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

    @Override
    public EmergencySystemDrillEntity entityById(String pid) {
        return baseMapper.entityById(pid);
    }

    @Override
    public List<EmergencySystemDrillEntity> queryName(Map<String, Object> params) {
        return baseMapper.queryName(params);
    }

    @Override
    public String insertData(EmergencySystemDrillEntity entity) {
        int count=baseMapper.insertData(entity);
        return entity.getPid();
    }

    @Override
    public PageUtils queryPageSql(Map<String, Object> params) {
        Integer limit = Integer.parseInt((String)params.get("limit"));
        Integer page = Integer.parseInt((String)params.get("page"));
        Query query = new Query(params);
        List<EmergencySystemDrillEntity> list = baseMapper.queryList(query);
        int count = baseMapper.count(params);
        return new PageUtils(list,count,limit,page);
    }
}

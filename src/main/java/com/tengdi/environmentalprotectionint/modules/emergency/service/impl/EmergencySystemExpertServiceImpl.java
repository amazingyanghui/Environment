package com.tengdi.environmentalprotectionint.modules.emergency.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;
import com.tengdi.environmentalprotectionint.modules.emergency.dao.EmergencySystemExpertDao;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemExpertEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemExpertService;


@Service("emergencySystemExpertService")
public class EmergencySystemExpertServiceImpl extends ServiceImpl<EmergencySystemExpertDao, EmergencySystemExpertEntity> implements EmergencySystemExpertService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<EmergencySystemExpertEntity> list=baseMapper.queryList(query);
        int count=baseMapper.queryCount(query);
        PageUtils page=new PageUtils(list,count,query.getLimit(),query.getCurrPage());
        return page;
    }

    @Override
    public List<EmergencySystemExpertEntity> queryList(Map<String, Object> params) {
        List<EmergencySystemExpertEntity> list=baseMapper.queryList(params);
        return list;
    }

    @Override
    public EmergencySystemExpertEntity entityById(String pid) {
        return baseMapper.entityById(pid);
    }

    @Override
    public List<EmergencySystemExpertEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }
}

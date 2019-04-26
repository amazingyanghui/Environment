package com.tengdi.environmentalprotectionint.modules.emergency.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;
import com.tengdi.environmentalprotectionint.modules.emergency.dao.EmergencySystemRanksDao;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemRanksEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemRanksService;


@Service("emergencySystemRanksService")
public class EmergencySystemRanksServiceImpl extends ServiceImpl<EmergencySystemRanksDao, EmergencySystemRanksEntity> implements EmergencySystemRanksService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<EmergencySystemRanksEntity> list=baseMapper.queryList(query);
        int count=baseMapper.queryCount(query);
        PageUtils page=new PageUtils(list,count,query.getLimit(),query.getCurrPage());
        return page;
    }

    @Override
    public List<EmergencySystemRanksEntity> queryList(Map<String, Object> params) {
        List<EmergencySystemRanksEntity> list=baseMapper.queryList(params);
        return list;
    }

    @Override
    public List<EmergencySystemRanksEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }
}

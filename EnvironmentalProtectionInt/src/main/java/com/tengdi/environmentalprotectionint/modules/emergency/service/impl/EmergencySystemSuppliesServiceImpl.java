package com.tengdi.environmentalprotectionint.modules.emergency.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;
import com.tengdi.environmentalprotectionint.modules.emergency.dao.EmergencySystemSuppliesDao;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemSuppliesEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemSuppliesService;


@Service("emergencySystemSuppliesService")
public class EmergencySystemSuppliesServiceImpl extends ServiceImpl<EmergencySystemSuppliesDao, EmergencySystemSuppliesEntity> implements EmergencySystemSuppliesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<EmergencySystemSuppliesEntity> list=baseMapper.queryPage(query);
        int total=baseMapper.queryCount(query);
        PageUtils page = new PageUtils(list, total, query.getLimit(), query.getCurrPage());
        return page;
    }

    @Override
    public List<EmergencySystemSuppliesEntity> queryList(Map<String, Object> params) {
        List<EmergencySystemSuppliesEntity> list=baseMapper.queryPage(params);

        return list;
    }

    @Override
    public List<EmergencySystemSuppliesEntity> queryName(Map<String, Object> map) {
        return baseMapper.queryName(map);
    }

    @Override
    public List<EmergencySystemSuppliesEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

    @Override
    public EmergencySystemSuppliesEntity entityById(String pid) {
        return baseMapper.entityById(pid);
    }
}

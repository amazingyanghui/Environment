package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoProductionEquipmentDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionEquipmentEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoProductionEquipmentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("cominfoProductionEquipmentService")
public class CominfoProductionEquipmentServiceImpl extends ServiceImpl<CominfoProductionEquipmentDao, CominfoProductionEquipmentEntity> implements CominfoProductionEquipmentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<CominfoProductionEquipmentEntity> list=baseMapper.queryData(query);
        int total=baseMapper.queryCount(query);
        PageUtils page = new PageUtils(list, total, query.getLimit(), query.getCurrPage());
        return page;
    }

    @Override
    public List<CominfoProductionEquipmentEntity> queryList(Map<String, Object> params) {
        return baseMapper.dataById(params);
    }

    @Override
    public CominfoProductionEquipmentEntity entityById(String pid) {
        return baseMapper.entityById(pid);
    }

}

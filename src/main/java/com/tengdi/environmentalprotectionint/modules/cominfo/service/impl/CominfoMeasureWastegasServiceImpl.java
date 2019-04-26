package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoMeasureWastegasDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureWastegasEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoMeasureWastegasService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;


@Service("cominfoMeasureWastegasService")
public class CominfoMeasureWastegasServiceImpl extends ServiceImpl<CominfoMeasureWastegasDao, CominfoMeasureWastegasEntity> implements CominfoMeasureWastegasService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<CominfoMeasureWastegasEntity> list=baseMapper.queryData(query);
        int total=baseMapper.countData(query);
        PageUtils page = new PageUtils(list, total, query.getLimit(), query.getCurrPage());
        return page;
    }

    @Override
    public List<CominfoMeasureWastegasEntity> queryList(Map<String, Object> params) {
        Query query=new Query(params);
        List<CominfoMeasureWastegasEntity> list=baseMapper.queryData(query);
        return list;
    }

    @Override
    public List<CominfoMeasureWastegasEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

}

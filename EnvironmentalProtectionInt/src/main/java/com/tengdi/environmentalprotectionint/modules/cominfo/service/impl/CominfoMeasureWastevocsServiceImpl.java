package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoMeasureWastevocsDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureWastevocsEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoMeasureWastevocsService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("cominfoMeasureWastevocsService")
public class CominfoMeasureWastevocsServiceImpl extends ServiceImpl<CominfoMeasureWastevocsDao, CominfoMeasureWastevocsEntity> implements CominfoMeasureWastevocsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<CominfoMeasureWastevocsEntity> list=baseMapper.queryData(query);
        int total=baseMapper.countData(query);
        PageUtils page = new PageUtils(list, total, query.getLimit(), query.getCurrPage());
        return page;
    }

    @Override
    public List<CominfoMeasureWastevocsEntity> queryList(Map<String, Object> params) {
        Query query=new Query(params);
        List<CominfoMeasureWastevocsEntity> list=baseMapper.queryData(query);
        return list;
    }

    @Override
    public List<CominfoMeasureWastevocsEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

}

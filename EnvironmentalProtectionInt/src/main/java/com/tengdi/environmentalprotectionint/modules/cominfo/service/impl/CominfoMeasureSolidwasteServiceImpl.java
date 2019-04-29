package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoMeasureSolidwasteDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureSolidwasteEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoMeasureSolidwasteService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("cominfoMeasureSolidwasteService")
public class CominfoMeasureSolidwasteServiceImpl extends ServiceImpl<CominfoMeasureSolidwasteDao, CominfoMeasureSolidwasteEntity> implements CominfoMeasureSolidwasteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<CominfoMeasureSolidwasteEntity> list=baseMapper.queryData(query);
        int total=baseMapper.countData(query);
        PageUtils page = new PageUtils(list, total, query.getLimit(), query.getCurrPage());
        return page;
    }

    @Override
    public List<CominfoMeasureSolidwasteEntity> queryList(Map<String, Object> params) {
        String cid=(String)params.get("cid");
        List<CominfoMeasureSolidwasteEntity> list=this.selectList(
                new EntityWrapper<CominfoMeasureSolidwasteEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid));

        return list;
    }

    @Override
    public List<CominfoMeasureSolidwasteEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

}

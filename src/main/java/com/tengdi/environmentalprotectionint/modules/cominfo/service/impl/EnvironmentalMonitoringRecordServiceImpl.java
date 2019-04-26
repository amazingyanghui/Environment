package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.EnvironmentalMonitoringRecordDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.EnvironmentalMonitoringRecordEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.EnvironmentalMonitoringRecordService;


@Service("environmentalMonitoringRecordService")
public class EnvironmentalMonitoringRecordServiceImpl extends ServiceImpl<EnvironmentalMonitoringRecordDao, EnvironmentalMonitoringRecordEntity> implements EnvironmentalMonitoringRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<EnvironmentalMonitoringRecordEntity> list=baseMapper.queryList(query);
        int count=baseMapper.queryCount(query);
        PageUtils page=new PageUtils(list,count,query.getLimit(),query.getCurrPage());

        return page;
    }

    @Override
    public List<EnvironmentalMonitoringRecordEntity> queryList(Map<String, Object> params) {
        String cid=(String)params.get("cid");
        List<EnvironmentalMonitoringRecordEntity> list=this.selectList(
                new EntityWrapper<EnvironmentalMonitoringRecordEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid));

        return list;
    }

    @Override
    public EnvironmentalMonitoringRecordEntity entityById(String pid) {
        return baseMapper.entityById(pid);
    }

}

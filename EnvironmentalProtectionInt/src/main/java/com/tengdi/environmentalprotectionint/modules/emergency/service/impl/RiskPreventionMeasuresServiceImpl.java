package com.tengdi.environmentalprotectionint.modules.emergency.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.Query;
import com.tengdi.environmentalprotectionint.modules.emergency.dao.RiskPreventionMeasuresDao;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.RiskPreventionMeasuresEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.RiskPreventionMeasuresService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.tengdi.core.utils.PageUtils;


/**
* @Author:         songxiaowen
* @CreateDate:     2019/3/13 10:48
* @Email:          song19930910@163.com
*/
@Service("riskPreventionMeasuresService")
public class RiskPreventionMeasuresServiceImpl extends ServiceImpl<RiskPreventionMeasuresDao, RiskPreventionMeasuresEntity> implements RiskPreventionMeasuresService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String riskPreventionMeasuresName = (String)params.get("riskPreventionMeasuresName");
        Page<RiskPreventionMeasuresEntity> page = this.selectPage(
                new Query<RiskPreventionMeasuresEntity>(params).getPage(),
                new EntityWrapper<RiskPreventionMeasuresEntity>()
                        .like(StringUtils.isNotBlank(riskPreventionMeasuresName),"riskPreventionMeasuresName", riskPreventionMeasuresName)
        );

        return new PageUtils(page);
    }

    @Override
    public RiskPreventionMeasuresEntity entityById(String pid) {
        return  baseMapper.entityById(pid);
    }

    @Override
    public List<RiskPreventionMeasuresEntity> queryList(Map<String, Object> params) {
        List<RiskPreventionMeasuresEntity> list=baseMapper.queryList(params);
        return list;
    }

    @Override
    public PageUtils queryPageSql(Map<String, Object> params) {
        Integer limit = Integer.parseInt((String)params.get("limit"));
        Integer page = Integer.parseInt((String)params.get("page"));
        Query query = new Query(params);
        List<RiskPreventionMeasuresEntity> list = baseMapper.queryList(query);
        int count = baseMapper.count(params);
        return new PageUtils(list,count,limit,page);
    }

}

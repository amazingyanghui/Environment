package com.tengdi.environmentalprotectionint.modules.zoneinfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;
import com.tengdi.core.utils.MapUtils;

import com.tengdi.environmentalprotectionint.modules.zoneinfo.dao.ZoneinfoBaseinfoDao ;
import com.tengdi.environmentalprotectionint.modules.zoneinfo.entity.ZoneinfoBaseinfoEntity ;
import com.tengdi.environmentalprotectionint.modules.zoneinfo.service.ZoneinfoBaseinfoService ;



@Service("zoneinfoBaseinfoService")
public class ZoneinfoBaseinfoServiceImpl extends ServiceImpl<ZoneinfoBaseinfoDao, ZoneinfoBaseinfoEntity> implements ZoneinfoBaseinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String zoneinfoBaseinfoName = (String)params.get("zoneinfoBaseinfoName");
        Page<ZoneinfoBaseinfoEntity> page = this.selectPage(
                new Query<ZoneinfoBaseinfoEntity>(params).getPage(),
                new EntityWrapper<ZoneinfoBaseinfoEntity>()
                        .like(StringUtils.isNotBlank(zoneinfoBaseinfoName),"zoneinfoBaseinfoName", zoneinfoBaseinfoName)
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryTableData(Map<String, Object> params) {
        Integer limit = Integer.parseInt((String)params.get("limit"));
        Integer page = Integer.parseInt((String)params.get("page"));
        Query query = new Query(params);
        List<Map<String,Object>> list = new ArrayList<>();
        int count = 0;
        list = baseMapper.queryList(query);
        count = baseMapper.queryCount(query);
        return new PageUtils(list,count,limit,page);
    }

}

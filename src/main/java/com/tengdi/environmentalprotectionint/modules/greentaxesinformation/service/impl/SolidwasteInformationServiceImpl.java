package com.tengdi.environmentalprotectionint.modules.greentaxesinformation.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.Query;
import com.tengdi.environmentalprotectionint.modules.greentaxesinformation.dao.SolidwasteInformationDao;
import com.tengdi.environmentalprotectionint.modules.greentaxesinformation.entity.SolidwasteInformationEntity;
import com.tengdi.environmentalprotectionint.modules.greentaxesinformation.entity.SysWasteEntity;
import com.tengdi.environmentalprotectionint.modules.greentaxesinformation.service.SolidwasteInformationService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.tengdi.core.utils.PageUtils;



@Service("solidwasteInformationService")
public class SolidwasteInformationServiceImpl extends ServiceImpl<SolidwasteInformationDao, SolidwasteInformationEntity> implements SolidwasteInformationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String solidwasteInformationName = (String)params.get("solidwasteInformationName");
        Page<SolidwasteInformationEntity> page = this.selectPage(
                new Query<SolidwasteInformationEntity>(params).getPage(),
                new EntityWrapper<SolidwasteInformationEntity>()
                        .like(StringUtils.isNotBlank(solidwasteInformationName),"solidwasteInformationName", solidwasteInformationName)
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils getWasteAll(Map<String, Object> params) {
        Integer limit = Integer.parseInt((String)params.get("limit"));
        Integer page = Integer.parseInt((String)params.get("page"));
        Query query = new Query(params);
        List<SysWasteEntity> list = baseMapper.queryList(query);
        int count = baseMapper.count(params);
        return new PageUtils(list,count,limit,page);
    }

}

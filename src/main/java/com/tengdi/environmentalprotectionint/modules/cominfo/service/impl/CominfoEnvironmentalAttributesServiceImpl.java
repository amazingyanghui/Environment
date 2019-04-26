package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoEnvironmentalAttributesDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoEnvironmentalAttributesEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoEnvironmentalAttributesService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("cominfoEnvironmentalAttributesService")
public class CominfoEnvironmentalAttributesServiceImpl extends ServiceImpl<CominfoEnvironmentalAttributesDao, CominfoEnvironmentalAttributesEntity> implements CominfoEnvironmentalAttributesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String cominfoEnvironmentalAttributesName = (String)params.get("cominfoEnvironmentalAttributesName");
        Page<CominfoEnvironmentalAttributesEntity> page = this.selectPage(
                new Query<CominfoEnvironmentalAttributesEntity>(params).getPage(),
                new EntityWrapper<CominfoEnvironmentalAttributesEntity>()
                        .like(StringUtils.isNotBlank(cominfoEnvironmentalAttributesName),"cominfoEnvironmentalAttributesName", cominfoEnvironmentalAttributesName)
        );

        return new PageUtils(page);
    }

    @Override
    public CominfoEnvironmentalAttributesEntity dataById(String cid) {
        return baseMapper.dataById(cid);
    }

}

package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionWaterEntity;
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

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.OrganicLiquidStorageLoadDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.OrganicLiquidStorageLoadEntity ;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.OrganicLiquidStorageLoadService;



@Service("organicLiquidStorageLoadService")
public class OrganicLiquidStorageLoadServiceImpl extends ServiceImpl<OrganicLiquidStorageLoadDao, OrganicLiquidStorageLoadEntity> implements OrganicLiquidStorageLoadService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String organicLiquidStorageLoadName = (String)params.get("organicLiquidStorageLoadName");
        Page<OrganicLiquidStorageLoadEntity> page = this.selectPage(
                new Query<OrganicLiquidStorageLoadEntity>(params).getPage(),
                new EntityWrapper<OrganicLiquidStorageLoadEntity>()
                        .like(StringUtils.isNotBlank(organicLiquidStorageLoadName),"organicLiquidStorageLoadName", organicLiquidStorageLoadName)
        );

        return new PageUtils(page);
    }
    @Override
    public List<OrganicLiquidStorageLoadEntity> queryList(Map<String, Object> params) {
        String cid=(String)params.get("cid");
        List<OrganicLiquidStorageLoadEntity> list=this.selectList(
                new EntityWrapper<OrganicLiquidStorageLoadEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid));

        return list;
    }


}

package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoProductionWaterDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionWaterEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoProductionWaterService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("cominfoProductionWaterService")
public class CominfoProductionWaterServiceImpl extends ServiceImpl<CominfoProductionWaterDao, CominfoProductionWaterEntity> implements CominfoProductionWaterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String cominfoProductionWaterName = (String)params.get("cominfoProductionWaterName");
        String cid=(String)params.get("cid");
        Page<CominfoProductionWaterEntity> page = this.selectPage(
                new Query<CominfoProductionWaterEntity>(params).getPage(),
                new EntityWrapper<CominfoProductionWaterEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid)
                        .like(StringUtils.isNotBlank(cominfoProductionWaterName),"cominfoProductionWaterName", cominfoProductionWaterName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<CominfoProductionWaterEntity> queryList(Map<String, Object> params) {
        String cid=(String)params.get("cid");
        List<CominfoProductionWaterEntity> list=this.selectList(
                new EntityWrapper<CominfoProductionWaterEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid));

        return list;
    }

}

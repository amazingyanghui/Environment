package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoProductionEnergyDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionEnergyEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoProductionEnergyService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("cominfoProductionEnergyService")
public class CominfoProductionEnergyServiceImpl extends ServiceImpl<CominfoProductionEnergyDao, CominfoProductionEnergyEntity> implements CominfoProductionEnergyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String cominfoProductionEnergyName = (String)params.get("cominfoProductionEnergyName");
        String cid=(String)params.get("cid");
        Page<CominfoProductionEnergyEntity> page = this.selectPage(
                new Query<CominfoProductionEnergyEntity>(params).getPage(),
                new EntityWrapper<CominfoProductionEnergyEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid)
                        .like(StringUtils.isNotBlank(cominfoProductionEnergyName),"cominfoProductionEnergyName", cominfoProductionEnergyName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<CominfoProductionEnergyEntity> queryList(Map<String, Object> params) {
        String cid=(String)params.get("cid");
        List<CominfoProductionEnergyEntity> list=this.selectList(
                new EntityWrapper<CominfoProductionEnergyEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid));

        return list;
    }

}

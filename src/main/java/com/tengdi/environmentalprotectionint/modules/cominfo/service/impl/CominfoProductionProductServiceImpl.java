package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoProductionProductDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionProductEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoProductionProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("cominfoProductionProductService")
public class CominfoProductionProductServiceImpl extends ServiceImpl<CominfoProductionProductDao, CominfoProductionProductEntity> implements CominfoProductionProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String cominfoProductionProductName = (String)params.get("cominfoProductionProductName");
        String cid=(String)params.get("cid");
        Page<CominfoProductionProductEntity> page = this.selectPage(
                new Query<CominfoProductionProductEntity>(params).getPage(),
                new EntityWrapper<CominfoProductionProductEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid)
                        .like(StringUtils.isNotBlank(cominfoProductionProductName),"cominfoProductionProductName", cominfoProductionProductName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<CominfoProductionProductEntity> queryList(Map<String, Object> params) {
        String cid=(String)params.get("cid");
        List<CominfoProductionProductEntity> list=this.selectList(
                new EntityWrapper<CominfoProductionProductEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid));

        return list;
    }

}

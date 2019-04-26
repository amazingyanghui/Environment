package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoProductionMaterialsDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionMaterialsEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoProductionMaterialsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("cominfoProductionMaterialsService")
public class CominfoProductionMaterialsServiceImpl extends ServiceImpl<CominfoProductionMaterialsDao, CominfoProductionMaterialsEntity> implements CominfoProductionMaterialsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String cominfoProductionMaterialsName = (String)params.get("cominfoProductionMaterialsName");
        String cid=(String)params.get("cid");
        Page<CominfoProductionMaterialsEntity> page = this.selectPage(
                new Query<CominfoProductionMaterialsEntity>(params).getPage(),
                new EntityWrapper<CominfoProductionMaterialsEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid)
                        .like(StringUtils.isNotBlank(cominfoProductionMaterialsName),"cominfoProductionMaterialsName", cominfoProductionMaterialsName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<CominfoProductionMaterialsEntity> queryList(Map<String, Object> params) {
        String cid=(String)params.get("cid");
        List<CominfoProductionMaterialsEntity> list=this.selectList(
                new EntityWrapper<CominfoProductionMaterialsEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid));

        return list;
    }

}

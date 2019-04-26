package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoProductionProcessDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionProcessEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoProductionProcessService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("cominfoProductionProcessService")
public class CominfoProductionProcessServiceImpl extends ServiceImpl<CominfoProductionProcessDao, CominfoProductionProcessEntity> implements CominfoProductionProcessService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String cominfoProductionProcessName = (String)params.get("cominfoProductionProcessName");
        String cid=(String)params.get("cid");
        Page<CominfoProductionProcessEntity> page = this.selectPage(
                new Query<CominfoProductionProcessEntity>(params).getPage(),
                new EntityWrapper<CominfoProductionProcessEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid)
                        .like(StringUtils.isNotBlank(cominfoProductionProcessName),"cominfoProductionProcessName", cominfoProductionProcessName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<CominfoProductionProcessEntity> queryList(Map<String, Object> params) {
        String cid=(String)params.get("cid");
        List<CominfoProductionProcessEntity> list=this.selectList(
                new EntityWrapper<CominfoProductionProcessEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid));

        return list;
    }

}

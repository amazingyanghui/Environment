package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoRepairRecordDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoRepairRecordEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoRepairRecordService;


@Service("cominfoRepairRecordService")
public class CominfoRepairRecordServiceImpl extends ServiceImpl<CominfoRepairRecordDao, CominfoRepairRecordEntity> implements CominfoRepairRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String cominfoRepairRecordName = (String)params.get("cominfoRepairRecordName");
        String cid=(String)params.get("cid");
        String mid=(String)params.get("mid");
        String wid=(String)params.get("wid");
        String startTime=(String)params.get("startTime");
        Page<CominfoRepairRecordEntity> page = this.selectPage(
                new Query<CominfoRepairRecordEntity>(params).getPage(),
                new EntityWrapper<CominfoRepairRecordEntity>()
                        .like(StringUtils.isNotBlank(cominfoRepairRecordName),"cominfoRepairRecordName", cominfoRepairRecordName)
                        .eq(StringUtils.isNotBlank(cid),"cid",cid)
                        .eq(StringUtils.isNotBlank(mid),"mid",mid)
                        .eq(StringUtils.isNotBlank(wid),"wid",wid)
                        .eq(StringUtils.isNotBlank(startTime),"DATE_FORMAt(repair_date,'%Y-%m')",startTime)
        );

        return new PageUtils(page);
    }

}

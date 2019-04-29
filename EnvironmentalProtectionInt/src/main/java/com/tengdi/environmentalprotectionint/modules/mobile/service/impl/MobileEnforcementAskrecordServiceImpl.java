package com.tengdi.environmentalprotectionint.modules.mobile.service.impl;

import com.tengdi.environmentalprotectionint.modules.mobile.dao.MobileEnforcementAskrecordDao;
import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementAskrecordEntity;
import com.tengdi.environmentalprotectionint.modules.mobile.service.MobileEnforcementAskrecordService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

@Service("mobileEnforcementAskrecordService")
public class MobileEnforcementAskrecordServiceImpl extends ServiceImpl<MobileEnforcementAskrecordDao, MobileEnforcementAskrecordEntity> implements MobileEnforcementAskrecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        int page =Integer.parseInt((String)params.get("page"));
        int limit =Integer.parseInt((String)params.get("limit"));
        Query query = new Query(params);
        List<MobileEnforcementAskrecordEntity> list =baseMapper.queryPage(query);
        int totalCount =baseMapper.queryPageSum(params);
        return new PageUtils(list,totalCount,limit,page);
    }

    @Override
    public List<MobileEnforcementAskrecordEntity> queryName(Map<String, Object> params) {
        List<MobileEnforcementAskrecordEntity> list =baseMapper.queryPage(params);
        return list;
    }

    @Override
    public List<MobileEnforcementAskrecordEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

    @Override
    public MobileEnforcementAskrecordEntity entityById(String pid) {
        return baseMapper.entityById(pid);
    }

    @Override
    public List<MobileEnforcementAskrecordEntity> queryList(Map<String, Object> params) {
        List<MobileEnforcementAskrecordEntity> list=baseMapper.queryList(params);
        return list;
    }
}

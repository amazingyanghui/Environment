package com.tengdi.environmentalprotectionint.modules.petition.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

import com.tengdi.environmentalprotectionint.modules.petition.dao.PetitionSystemComplainDao;
import com.tengdi.environmentalprotectionint.modules.petition.entity.PetitionSystemComplainEntity;
import com.tengdi.environmentalprotectionint.modules.petition.service.PetitionSystemComplainService;


@Service("petitionSystemComplainService")
public class PetitionSystemComplainServiceImpl extends ServiceImpl<PetitionSystemComplainDao, PetitionSystemComplainEntity> implements PetitionSystemComplainService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        int page =Integer.parseInt((String)params.get("page"));
        int limit =Integer.parseInt((String)params.get("limit"));
        Query query = new Query(params);
        List<PetitionSystemComplainEntity> list =baseMapper.queryList(query);
        int totalCount =baseMapper.queryCount(params);
        return new PageUtils(list,totalCount,limit,page);
    }

    @Override
    public List<PetitionSystemComplainEntity> queryList(Map<String, Object> map) {
        return baseMapper.queryList(map);
    }

    @Override
    public List<PetitionSystemComplainEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

    @Override
    public PetitionSystemComplainEntity entityById(String pid) {
        return baseMapper.entityById(pid);
    }

}

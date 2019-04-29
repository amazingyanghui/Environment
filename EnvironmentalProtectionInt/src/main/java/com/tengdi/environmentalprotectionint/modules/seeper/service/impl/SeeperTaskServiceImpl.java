package com.tengdi.environmentalprotectionint.modules.seeper.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

import com.tengdi.environmentalprotectionint.modules.seeper.dao.SeeperTaskDao;
import com.tengdi.environmentalprotectionint.modules.seeper.entity.SeeperTaskEntity;
import com.tengdi.environmentalprotectionint.modules.seeper.service.SeeperTaskService;


@Service("seeperTaskService")
public class SeeperTaskServiceImpl extends ServiceImpl<SeeperTaskDao, SeeperTaskEntity> implements SeeperTaskService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<SeeperTaskEntity> list=baseMapper.queryList(query);
        int count=baseMapper.queryCount(query);
        PageUtils page=new PageUtils(list,count,query.getLimit(),query.getCurrPage());

        return page;
    }

}

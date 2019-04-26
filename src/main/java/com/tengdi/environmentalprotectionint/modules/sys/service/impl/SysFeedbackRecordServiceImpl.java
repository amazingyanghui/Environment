package com.tengdi.environmentalprotectionint.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

import com.tengdi.environmentalprotectionint.modules.sys.dao.SysFeedbackRecordDao;
import com.tengdi.environmentalprotectionint.modules.sys.entity.SysFeedbackRecordEntity;
import com.tengdi.environmentalprotectionint.modules.sys.service.SysFeedbackRecordService;


@Service("sysFeedbackRecordService")
public class SysFeedbackRecordServiceImpl extends ServiceImpl<SysFeedbackRecordDao, SysFeedbackRecordEntity> implements SysFeedbackRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<SysFeedbackRecordEntity> list=baseMapper.queryList(query);
        int count=baseMapper.queryCount(query);
        PageUtils page=new PageUtils(list,count,query.getLimit(),query.getCurrPage());

        return page;
    }

    @Override
    public List<SysFeedbackRecordEntity> queryList(Map<String, Object> params) {
        return baseMapper.queryList(params);
    }

}

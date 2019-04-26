package com.tengdi.environmentalprotectionint.modules.online.service.impl;

import com.tengdi.environmentalprotectionint.modules.online.dao.OnlineMonitorFactorDao;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorFactorEntity;
import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorFactorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("onlineMonitorFactorService")
public class OnlineMonitorFactorServiceImpl extends ServiceImpl<OnlineMonitorFactorDao, OnlineMonitorFactorEntity> implements OnlineMonitorFactorService {
    @Override
    public List<SelectEntity> list(int type) {
        List<OnlineMonitorFactorEntity> list =baseMapper.selectList(type);
        List<SelectEntity> selectlist = new ArrayList<SelectEntity>();
        for(OnlineMonitorFactorEntity entity : list){
            SelectEntity select = new SelectEntity();
            select.setId(entity.getFactorCode());
            select.setName(entity.getFactorName());
            selectlist.add(select);
        }

        return selectlist;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<OnlineMonitorFactorEntity> list=baseMapper.queryData(query);
        int total=baseMapper.queryCount(query);
        PageUtils page = new PageUtils(list, total, query.getLimit(), query.getCurrPage());
        return page;
    }
    @Override
    public List<OnlineMonitorFactorEntity> selFactorByStatisticalType(String type) {
        return baseMapper.selFactorByStatisticalType(type);
    }

    @Override
    public List<OnlineMonitorFactorEntity> queryFactorByPort(Map map){
        return  baseMapper.queryFactorByPort(map);
    }

}

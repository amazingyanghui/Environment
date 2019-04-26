package com.tengdi.environmentalprotectionint.modules.online.service.impl;

import com.tengdi.environmentalprotectionint.modules.online.dao.OnlineMonitorWasteinfoDao;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPortinfoEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorWasteEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorWasteinfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

@Service("onlineMonitorWasteinfoService")
public class OnlineMonitorWasteinfoServiceImpl extends ServiceImpl<OnlineMonitorWasteinfoDao, OnlineMonitorWasteEntity> implements OnlineMonitorWasteinfoService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<OnlineMonitorWasteEntity> list=baseMapper.queryList(query);
        int total=baseMapper.queryCount(query);
        PageUtils page = new PageUtils(list, total, query.getLimit(), query.getCurrPage());
        return page;
    }
}

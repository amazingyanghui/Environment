package com.tengdi.environmentalprotectionint.modules.online.service.impl;

import com.tengdi.environmentalprotectionint.modules.online.dao.OnlineMonitorStoreinfoDao;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorStoreinfoEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorStoreinfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

@Service("onlineMonitorStoreinfoService")
public class OnlineMonitorStoreinfoServiceImpl extends ServiceImpl<OnlineMonitorStoreinfoDao, OnlineMonitorStoreinfoEntity> implements OnlineMonitorStoreinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String onlineMonitorStoreinfoName = (String)params.get("onlineMonitorStoreinfoName");
        Page<OnlineMonitorStoreinfoEntity> page = this.selectPage(
                new Query<OnlineMonitorStoreinfoEntity>(params).getPage(),
                new EntityWrapper<OnlineMonitorStoreinfoEntity>()
                        .like(StringUtils.isNotBlank(onlineMonitorStoreinfoName),"onlineMonitorStoreinfoName", onlineMonitorStoreinfoName)
        );

        return new PageUtils(page);
    }

}

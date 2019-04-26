package com.tengdi.environmentalprotectionint.modules.online.service.impl;

import com.tengdi.environmentalprotectionint.modules.online.dao.OnlineMonitorHourdataDao;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorHourdataEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorHourdataService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("onlineMonitorHourdataService")
public class OnlineMonitorHourdataServiceImpl extends ServiceImpl<OnlineMonitorHourdataDao, OnlineMonitorHourdataEntity> implements OnlineMonitorHourdataService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String onlineMonitorHourdataName = (String)params.get("onlineMonitorHourdataName");
        Page<OnlineMonitorHourdataEntity> page = this.selectPage(
                new Query<OnlineMonitorHourdataEntity>(params).getPage(),
                new EntityWrapper<OnlineMonitorHourdataEntity>()
                        .like(StringUtils.isNotBlank(onlineMonitorHourdataName),"onlineMonitorHourdataName", onlineMonitorHourdataName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<OnlineMonitorHourdataEntity> queryList(Map map) {
        return baseMapper.queryList(map);
    }

}

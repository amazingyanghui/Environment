package com.tengdi.environmentalprotectionint.modules.sys.service.impl;

import com.tengdi.environmentalprotectionint.modules.sys.dao.SysNoticeDao;
import com.tengdi.environmentalprotectionint.modules.sys.entity.SysNoticeEntity;
import com.tengdi.environmentalprotectionint.modules.sys.service.SysNoticeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("sysNoticeService")
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeDao, SysNoticeEntity> implements SysNoticeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String title = (String)params.get("title");
        Page<SysNoticeEntity> page = this.selectPage(
                new Query<SysNoticeEntity>(params).getPage(),
                new EntityWrapper<SysNoticeEntity>()
                        .like(StringUtils.isNotBlank(title),"title", title)
        );

        return new PageUtils(page);
    }

}

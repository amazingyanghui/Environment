package com.tengdi.environmentalprotectionint.modules.mobile.service.impl;

import com.tengdi.environmentalprotectionint.modules.mobile.dao.MobileEnforcementAttachmentDao;
import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementAttachmentEntity;
import com.tengdi.environmentalprotectionint.modules.mobile.service.MobileEnforcementAttachmentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;




@Service("mobileEnforcementAttachmentService")
public class MobileEnforcementAttachmentServiceImpl extends ServiceImpl<MobileEnforcementAttachmentDao, MobileEnforcementAttachmentEntity> implements MobileEnforcementAttachmentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String mid = (String)params.get("mid");
        String type=(String)params.get("type");
        Page<MobileEnforcementAttachmentEntity> page = this.selectPage(
                new Query<MobileEnforcementAttachmentEntity>(params).getPage(),
                new EntityWrapper<MobileEnforcementAttachmentEntity>()
                        .eq(StringUtils.isNotBlank(mid),"mid",mid)
                        .eq(StringUtils.isNotBlank(type),"type",type)
        );
        return new PageUtils(page);
    }

    @Override
    public List<MobileEnforcementAttachmentEntity> dataByFile(Map<String,Object> map) {
        return baseMapper.dataByFile(map);
    }

}

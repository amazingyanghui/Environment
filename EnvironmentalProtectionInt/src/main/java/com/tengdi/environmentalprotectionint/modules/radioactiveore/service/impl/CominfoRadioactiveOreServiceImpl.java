package com.tengdi.environmentalprotectionint.modules.radioactiveore.service.impl;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.radioactiveore.dao.CominfoRadioactiveOreDao;
import com.tengdi.environmentalprotectionint.modules.radioactiveore.entity.CominfoRadioactiveOreEntity;
import com.tengdi.environmentalprotectionint.modules.radioactiveore.service.CominfoRadioactiveOreService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;
import com.tengdi.core.utils.MapUtils;

@Service("cominfoRadioactiveOreService")
public class CominfoRadioactiveOreServiceImpl extends ServiceImpl<CominfoRadioactiveOreDao, CominfoRadioactiveOreEntity> implements CominfoRadioactiveOreService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String cominfoRadioactiveOreName = (String)params.get("cominfoRadioactiveOreName");
        Page<CominfoRadioactiveOreEntity> page = this.selectPage(
                new Query<CominfoRadioactiveOreEntity>(params).getPage(),
                new EntityWrapper<CominfoRadioactiveOreEntity>()
                        .like(StringUtils.isNotBlank(cominfoRadioactiveOreName),"cominfoRadioactiveOreName", cominfoRadioactiveOreName)
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryTableData(Map<String, Object> params) {
        Integer limit = Integer.parseInt((String)params.get("limit"));
        Integer page = Integer.parseInt((String)params.get("page"));
        Query query = new Query(params);
        List<Map<String,Object>> list = new ArrayList<>();
        int count = 0;
        list = baseMapper.queryList(query);
        count = baseMapper.queryListCount(query);
        return new PageUtils(list,count,page,limit);
    }

}

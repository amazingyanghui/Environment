package com.tengdi.environmentalprotectionint.modules.greentax.service.impl;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.greentax.dao.EpSolidWasteMainDao;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteMainEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpSolidWasteMainService;
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

@Service("epSolidWasteMainService")
public class EpSolidWasteMainServiceImpl extends ServiceImpl<EpSolidWasteMainDao, EpSolidWasteMainEntity> implements EpSolidWasteMainService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String epSolidWasteMainName = (String)params.get("epSolidWasteMainName");
        Page<EpSolidWasteMainEntity> page = this.selectPage(
                new Query<EpSolidWasteMainEntity>(params).getPage(),
                new EntityWrapper<EpSolidWasteMainEntity>()
                        .like(StringUtils.isNotBlank(epSolidWasteMainName),"epSolidWasteMainName", epSolidWasteMainName)
        );

        return new PageUtils(page);
    }

//    @Override
//    public PageUtils queryTableData(QueryCriterias criterias) {
//        Integer limit = criterias.getLimit();
//        Integer page = criterias.getPage();
//        Integer offset = (page-1) * limit;
//        criterias.setPagenumber(offset);
//        criterias.setPagesize(limit);
//        List<Map<String,Object>> list = new ArrayList<>();
//        int count = 0;
//        // 非汇总表调用普通通用查询接口
//        if (StringUtils.isEmpty(criterias.getSumCols())) {
//            list = baseMapper.queryList(criterias);
//            count = baseMapper.queryListCount(criterias);
//        }
//        return new PageUtils(BeanHump.listUnderlineKeyToCamel(list),count,limit,page);
//    }

}

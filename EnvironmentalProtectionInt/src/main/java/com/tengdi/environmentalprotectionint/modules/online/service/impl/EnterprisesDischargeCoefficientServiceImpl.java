package com.tengdi.environmentalprotectionint.modules.online.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.BeanHump;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;
import com.tengdi.core.utils.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.online.dao.EnterprisesDischargeCoefficientDao;
import com.tengdi.environmentalprotectionint.modules.online.entity.EnterprisesDischargeCoefficientEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.EnterprisesDischargeCoefficientService;



@Service("enterprisesDischargeCoefficientService")
public class EnterprisesDischargeCoefficientServiceImpl extends ServiceImpl<EnterprisesDischargeCoefficientDao, EnterprisesDischargeCoefficientEntity> implements EnterprisesDischargeCoefficientService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<EnterprisesDischargeCoefficientEntity> list=baseMapper.queryData(query);
        int total=baseMapper.queryCount(query);
        PageUtils page = new PageUtils(list, total, query.getLimit(), query.getCurrPage());
        return page;
    }

    @Override
    public PageUtils queryTableData(QueryCriterias criterias) {
        Integer limit = criterias.getLimit();
        Integer page = criterias.getPage();
        Integer offset = (page-1) * limit;
        criterias.setPagenumber(offset);
        criterias.setPagesize(limit);
        List<Map<String,Object>> list = new ArrayList<>();
        int count = 0;
        // 非汇总表调用普通通用查询接口
        if (StringUtils.isEmpty(criterias.getSumCols())) {
            list = baseMapper.queryList(criterias);
            count = baseMapper.queryListCount(criterias);
        }
        return new PageUtils(BeanHump.listUnderlineKeyToCamel(list),count,limit,page);
    }

}

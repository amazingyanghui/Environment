package com.tengdi.environmentalprotectionint.modules.greentax.service.impl;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.greentax.dao.EpSolidWasteTaxDao;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteTaxEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpSolidWasteTaxService;
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

@Service("epSolidWasteTaxService")
public class EpSolidWasteTaxServiceImpl extends ServiceImpl<EpSolidWasteTaxDao, EpSolidWasteTaxEntity> implements EpSolidWasteTaxService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String epSolidWasteTaxName = (String)params.get("epSolidWasteTaxName");
        Page<EpSolidWasteTaxEntity> page = this.selectPage(
                new Query<EpSolidWasteTaxEntity>(params).getPage(),
                new EntityWrapper<EpSolidWasteTaxEntity>()
                        .like(StringUtils.isNotBlank(epSolidWasteTaxName),"epSolidWasteTaxName", epSolidWasteTaxName)
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryTableData(Map<String, Object> params) {
        Integer limit = Integer.parseInt((String)params.get("limit"));
        Integer page = Integer.parseInt((String)params.get("page"));
        if((params.get("cycle")!=null) && (!params.get("cycle").equals(""))){
            String  cycle =(String) params.get("cycle");
            String str1= cycle.substring(5,9);
            String str2= cycle.substring(10,14);
            params.put("reportSection",str1+"-"+str2);
        }
        Query query = new Query(params);
        List<Map<String,Object>> list = new ArrayList<>();
        int count = 0;
        list = baseMapper.queryList(query);
        count = baseMapper.queryListCount(query);
        return new PageUtils(list,count,limit,page);
    }

}

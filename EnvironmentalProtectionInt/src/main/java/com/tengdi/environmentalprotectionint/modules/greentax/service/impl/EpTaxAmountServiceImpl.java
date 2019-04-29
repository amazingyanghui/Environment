package com.tengdi.environmentalprotectionint.modules.greentax.service.impl;

import com.tengdi.environmentalprotectionint.modules.greentax.dao.EpTaxAmountDao;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpTaxAmountEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpTaxAmountService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("epTaxAmountService")
public class EpTaxAmountServiceImpl extends ServiceImpl<EpTaxAmountDao, EpTaxAmountEntity> implements EpTaxAmountService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String epTaxAmountName = (String)params.get("epTaxAmountName");
        Page<EpTaxAmountEntity> page = this.selectPage(
                new Query<EpTaxAmountEntity>(params).getPage(),
                new EntityWrapper<EpTaxAmountEntity>()
                        .like(StringUtils.isNotBlank(epTaxAmountName),"epTaxAmountName", epTaxAmountName)
        );

        return new PageUtils(page);
    }

}

package com.tengdi.environmentalprotectionint.modules.greentax.service.impl;

import com.tengdi.environmentalprotectionint.modules.greentax.dao.EpTaxFormulaItemDao;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpTaxFormulaItemEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpTaxFormulaItemService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("epTaxFormulaItemService")
public class EpTaxFormulaItemServiceImpl extends ServiceImpl<EpTaxFormulaItemDao, EpTaxFormulaItemEntity> implements EpTaxFormulaItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String epTaxFormulaItemName = (String)params.get("epTaxFormulaItemName");
        Page<EpTaxFormulaItemEntity> page = this.selectPage(
                new Query<EpTaxFormulaItemEntity>(params).getPage(),
                new EntityWrapper<EpTaxFormulaItemEntity>()
                        .like(StringUtils.isNotBlank(epTaxFormulaItemName),"epTaxFormulaItemName", epTaxFormulaItemName)
        );

        return new PageUtils(page);
    }

}

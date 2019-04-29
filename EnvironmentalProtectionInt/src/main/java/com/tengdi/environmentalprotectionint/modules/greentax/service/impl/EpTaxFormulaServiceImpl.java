package com.tengdi.environmentalprotectionint.modules.greentax.service.impl;

import com.tengdi.environmentalprotectionint.modules.greentax.dao.EpTaxFormulaDao;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpTaxFormulaEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpTaxFormulaService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

import javax.annotation.Resource;


@Service("epTaxFormulaService")
public class EpTaxFormulaServiceImpl extends ServiceImpl<EpTaxFormulaDao, EpTaxFormulaEntity> implements EpTaxFormulaService {

    @Resource
    private EpTaxFormulaDao epTaxFormulaDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String epTaxFormulaName = (String)params.get("epTaxFormulaName");
        Page<EpTaxFormulaEntity> page = this.selectPage(
                new Query<EpTaxFormulaEntity>(params).getPage(),
                new EntityWrapper<EpTaxFormulaEntity>()
                        .like(StringUtils.isNotBlank(epTaxFormulaName),"epTaxFormulaName", epTaxFormulaName)
        );

        return new PageUtils(page);
    }



    @Override
    public EpTaxFormulaEntity queryFormula(Map<String, Object> params) {
        return epTaxFormulaDao.selectByParam(params);
    }

}

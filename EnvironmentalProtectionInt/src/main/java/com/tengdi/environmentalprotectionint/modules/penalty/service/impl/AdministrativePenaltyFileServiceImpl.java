package com.tengdi.environmentalprotectionint.modules.penalty.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

import com.tengdi.environmentalprotectionint.modules.penalty.dao.AdministrativePenaltyFileDao;
import com.tengdi.environmentalprotectionint.modules.penalty.entity.AdministrativePenaltyFileEntity;
import com.tengdi.environmentalprotectionint.modules.penalty.service.AdministrativePenaltyFileService;


@Service("administrativePenaltyFileService")
public class AdministrativePenaltyFileServiceImpl extends ServiceImpl<AdministrativePenaltyFileDao, AdministrativePenaltyFileEntity> implements AdministrativePenaltyFileService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String administrativePenaltyFileName = (String)params.get("administrativePenaltyFileName");
        Page<AdministrativePenaltyFileEntity> page = this.selectPage(
                new Query<AdministrativePenaltyFileEntity>(params).getPage(),
                new EntityWrapper<AdministrativePenaltyFileEntity>()
                        .like(StringUtils.isNotBlank(administrativePenaltyFileName),"administrativePenaltyFileName", administrativePenaltyFileName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<AdministrativePenaltyFileEntity> dataByFile(String aid) {
        return baseMapper.dataByFile(aid);
    }

}

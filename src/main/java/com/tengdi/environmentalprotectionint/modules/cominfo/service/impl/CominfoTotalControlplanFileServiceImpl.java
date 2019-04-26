package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoTotalControlplanFileDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoTotalControlplanFileEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoTotalControlplanFileService;


@Service("cominfoTotalControlplanFileService")
public class CominfoTotalControlplanFileServiceImpl extends ServiceImpl<CominfoTotalControlplanFileDao, CominfoTotalControlplanFileEntity> implements CominfoTotalControlplanFileService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String cominfoTotalControlplanFileName = (String)params.get("cominfoTotalControlplanFileName");
        Page<CominfoTotalControlplanFileEntity> page = this.selectPage(
                new Query<CominfoTotalControlplanFileEntity>(params).getPage(),
                new EntityWrapper<CominfoTotalControlplanFileEntity>()
                        .like(StringUtils.isNotBlank(cominfoTotalControlplanFileName),"cominfoTotalControlplanFileName", cominfoTotalControlplanFileName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<CominfoTotalControlplanFileEntity> dataByFile(String aid) {
        return baseMapper.dataByFile(aid);
    }

}

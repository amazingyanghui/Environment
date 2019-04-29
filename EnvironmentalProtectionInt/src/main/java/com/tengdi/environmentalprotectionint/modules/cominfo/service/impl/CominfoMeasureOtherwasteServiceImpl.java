package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoMeasureOtherwasteDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureOtherwasteEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoMeasureOtherwasteService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("cominfoMeasureOtherwasteService")
public class CominfoMeasureOtherwasteServiceImpl extends ServiceImpl<CominfoMeasureOtherwasteDao, CominfoMeasureOtherwasteEntity> implements CominfoMeasureOtherwasteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<CominfoMeasureOtherwasteEntity> list=baseMapper.queryData(query);
        int total=baseMapper.countData(query);
        PageUtils page = new PageUtils(list, total, query.getLimit(), query.getCurrPage());
        return page;
    }

    @Override
    public List<CominfoMeasureOtherwasteEntity> queryList(Map<String, Object> params) {
        String cid=(String)params.get("cid");
        List<CominfoMeasureOtherwasteEntity> list=this.selectList(
                new EntityWrapper<CominfoMeasureOtherwasteEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid));

        return list;
    }

    @Override
    public List<CominfoMeasureOtherwasteEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

}

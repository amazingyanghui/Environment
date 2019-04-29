package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoTotalControlplanDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoTotalControlplanEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoTotalControlplanService;


@Service("cominfoTotalControlplanService")
public class CominfoTotalControlplanServiceImpl extends ServiceImpl<CominfoTotalControlplanDao, CominfoTotalControlplanEntity> implements CominfoTotalControlplanService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<CominfoTotalControlplanEntity> list=baseMapper.queryList(query);
        int count=baseMapper.queryCount(query);
        PageUtils page=new PageUtils(list,count,query.getLimit(),query.getCurrPage());

        return page;
    }

    @Override
    public CominfoTotalControlplanEntity entityById(String pid) {
        return baseMapper.entityById(pid);
    }

    @Override
    public String insertData(CominfoTotalControlplanEntity entity) {
        int count=baseMapper.insertData(entity);
        return entity.getPid();
    }

    @Override
    public List<CominfoTotalControlplanEntity> queryList(Map<String, Object> params) {
        String cid=(String)params.get("cid");
        List<CominfoTotalControlplanEntity> list=this.selectList(
                new EntityWrapper<CominfoTotalControlplanEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid));

        return list;
    }
}

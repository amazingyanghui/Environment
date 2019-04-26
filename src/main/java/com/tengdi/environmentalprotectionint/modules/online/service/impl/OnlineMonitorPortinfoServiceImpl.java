package com.tengdi.environmentalprotectionint.modules.online.service.impl;

import com.tengdi.environmentalprotectionint.modules.online.dao.OnlineMonitorPortinfoDao;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPortinfoEntity;
import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorPortinfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

@Service("onlineMonitorPortinfoService")
public class OnlineMonitorPortinfoServiceImpl extends ServiceImpl<OnlineMonitorPortinfoDao, OnlineMonitorPortinfoEntity> implements OnlineMonitorPortinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<OnlineMonitorPortinfoEntity> list=baseMapper.queryData(query);
        int total=baseMapper.queryCount(query);
        PageUtils page = new PageUtils(list, total, query.getLimit(), query.getCurrPage());
        return page;
    }

    @Override
    public List<OnlineMonitorPortinfoEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

    @Override
    public List<SelectEntity> list(String cid,Integer type) {
        boolean flag=(type<0)?false:true;
        List<OnlineMonitorPortinfoEntity> list =
                this.selectList(new EntityWrapper<OnlineMonitorPortinfoEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid", cid)
                        .eq(flag,"monitor_type",type)
                        .eq("monitor_useflag", 1)
                );

        List<SelectEntity> selectlist = new ArrayList<SelectEntity>();
        for(OnlineMonitorPortinfoEntity entity : list){
            SelectEntity select = new SelectEntity();
                select.setId(entity.getPid());
                select.setName(entity.getMonitorName());
                select.setType(entity.getMonitorType());
                select.setCode(entity.getPhotoPath());
                selectlist.add(select);
        }

        return selectlist;
    }

    @Override
    public List<SelectEntity> list(String cid) {
        List<OnlineMonitorPortinfoEntity> list =
                this.selectList(new EntityWrapper<OnlineMonitorPortinfoEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid", cid)
                        .eq("monitor_useflag", 1)
                );

        List<SelectEntity> selectlist = new ArrayList<SelectEntity>();
        for(OnlineMonitorPortinfoEntity entity : list){
            SelectEntity select = new SelectEntity();
            select.setId(entity.getPid());
            select.setName(entity.getMonitorName());
            select.setType(entity.getMonitorType());
            select.setCode(entity.getPhotoPath());
            selectlist.add(select);
        }

        return selectlist;
    }

    @Override
    public int createDateTable(String tableName) {
        return baseMapper.createDateTable(tableName);
    }

    @Override
    public int createHourTable(String tableName) {
        return baseMapper.createHourTable(tableName);
    }

    @Override
    public String idByInsert(OnlineMonitorPortinfoEntity entity) {
        int i=baseMapper.idByInsert(entity);
        return entity.getPid();
    }

    @Override
    public int dropDateTable(String tableName) {
        return baseMapper.dropDateTable(tableName);
    }

    @Override
    public int dropHourTable(String tableName) {
        return baseMapper.dropHourTable(tableName);
    }

    @Override
    public int updateForEnvironment(OnlineMonitorPortinfoEntity entity) {
        return baseMapper.updateForEnvironment(entity);
    }

    @Override
    public List<OnlineMonitorPortinfoEntity> noiseBaseInfoById(String cid) {
        return baseMapper.noiseBaseInfoById(cid);
    }

    @Override
    public List<OnlineMonitorPortinfoEntity> queryList(Map<String, Object> params){
        return baseMapper.queryList(params);
    }

}

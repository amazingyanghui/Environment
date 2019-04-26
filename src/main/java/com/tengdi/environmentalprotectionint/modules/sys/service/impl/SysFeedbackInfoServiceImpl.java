package com.tengdi.environmentalprotectionint.modules.sys.service.impl;

import com.tengdi.environmentalprotectionint.modules.sys.service.SysFeedbackRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

import com.tengdi.environmentalprotectionint.modules.sys.dao.SysFeedbackInfoDao;
import com.tengdi.environmentalprotectionint.modules.sys.entity.SysFeedbackInfoEntity;
import com.tengdi.environmentalprotectionint.modules.sys.service.SysFeedbackInfoService;


@Service("sysFeedbackInfoService")
public class SysFeedbackInfoServiceImpl extends ServiceImpl<SysFeedbackInfoDao, SysFeedbackInfoEntity> implements SysFeedbackInfoService {

    @Autowired
    private SysFeedbackRecordService sysFeedbackRecordService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<SysFeedbackInfoEntity> list=baseMapper.queryList(query);
        if(list!=null){
            for(SysFeedbackInfoEntity entity:list){
                if(entity.getLoginUser().equals("admin")){
                    entity.setCompanyName("admin");
                }
            }
        }
        int count=baseMapper.queryCount(query);
        PageUtils page=new PageUtils(list,count,query.getLimit(),query.getCurrPage());

        return page;
    }

    @Override
    public String insertData(SysFeedbackInfoEntity sysFeedbackInfoEntity) {
        int count=baseMapper.insertData(sysFeedbackInfoEntity);
        return sysFeedbackInfoEntity.getPid();
    }

    @Override
    public List<SysFeedbackInfoEntity> queryList(Map<String, Object> params) {
        List<SysFeedbackInfoEntity> list=baseMapper.queryList(params);
        if(list!=null){
            for(SysFeedbackInfoEntity entity:list){
                if(entity.getLoginUser().equals("admin")){
                    entity.setCompanyName("admin");
                }
                Map<String,Object> map=new HashMap<>();
                map.put("oid",entity.getPid());
                entity.setSysFeedbackRecordList(sysFeedbackRecordService.queryList(map));
            }
        }
        return list;
    }

}

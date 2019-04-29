package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoMeasureWastewaterDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureWastewaterEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoMeasureWastewaterService;
import com.tengdi.environmentalprotectionint.modules.sys.entity.SysShuiwuranwuEntity;
import com.tengdi.environmentalprotectionint.modules.sys.service.SysShuiwuranwuService;
import com.tengdi.core.utils.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("cominfoMeasureWastewaterService")
public class CominfoMeasureWastewaterServiceImpl extends ServiceImpl<CominfoMeasureWastewaterDao, CominfoMeasureWastewaterEntity> implements CominfoMeasureWastewaterService {
    @Autowired
    private SysShuiwuranwuService sysShuiwuranwuService;
    @Override
    public String getIndustry(String code) {
        String[] industryids = code.split(",");
        String industryidstemp = "";
        for(String industryid : industryids){
            List<SysShuiwuranwuEntity> sysList=sysShuiwuranwuService.selectByMap(new MapUtils().put("DaiMaZhi",industryid));
            if(sysList.size()>0){
                SysShuiwuranwuEntity sysHangyedaima = sysList.get(0);
                if(sysHangyedaima != null){
                    industryidstemp += sysHangyedaima.getMingcheng() + ",";
                }

            }
        }
        if (industryidstemp.length() > 0 ){
            industryidstemp = industryidstemp.substring(0, industryidstemp.length() - 1);
        }
        return industryidstemp;
    }

    @Override
    public List<CominfoMeasureWastewaterEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<CominfoMeasureWastewaterEntity> list=baseMapper.queryData(query);
        list=getList(list);
        int total=baseMapper.countData(query);
        PageUtils page = new PageUtils(list, total, query.getLimit(), query.getCurrPage());
        return page;
    }

    @Override
    public List<CominfoMeasureWastewaterEntity> queryList(Map<String, Object> params) {
        Query query=new Query(params);
        List<CominfoMeasureWastewaterEntity> list=baseMapper.queryData(query);
        list=getList(list);
        return list;
    }

    @Override
    public List<CominfoMeasureWastewaterEntity> getList(List<CominfoMeasureWastewaterEntity> list) {
        if(list.size()>0){
            for(CominfoMeasureWastewaterEntity entity:list){
                if(entity.getRemovalOfMaterial()!=null&&!entity.getRemovalOfMaterial().equals("")){
                    String industryidstemp=getIndustry(entity.getRemovalOfMaterial());
                    if(StringUtils.isNotBlank(industryidstemp)){
                        entity.setRemovalOfMaterialName(industryidstemp);
                    }
                }
            }
        }
        return list;
    }

}

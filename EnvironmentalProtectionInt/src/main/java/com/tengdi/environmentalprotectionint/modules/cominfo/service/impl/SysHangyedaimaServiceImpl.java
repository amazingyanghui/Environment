package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPortinfoEntity;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.SysHangyedaimaDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.SysHangyedaimaEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.SysHangyedaimaService;


@Service("sysHangyedaimaService")
public class SysHangyedaimaServiceImpl extends ServiceImpl<SysHangyedaimaDao, SysHangyedaimaEntity> implements SysHangyedaimaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String sysHangyedaimaName = (String)params.get("sysHangyedaimaName");
        Page<SysHangyedaimaEntity> page = this.selectPage(
                new Query<SysHangyedaimaEntity>(params).getPage(),
                new EntityWrapper<SysHangyedaimaEntity>()
                        .like(StringUtils.isNotBlank(sysHangyedaimaName),"sysHangyedaimaName", sysHangyedaimaName)
        );

        return new PageUtils(page);
    }

    @Override
    public JSONArray getHangYeLieBiao(String code) {
        String[] daiMaZhis = code.split(",");
        List<String> list = new ArrayList<String>();
        for(String daiMaZhi : daiMaZhis){
            list.add(daiMaZhi);
        }
        List<SysHangyedaimaEntity> hangyedaimaList = this.selectList(new EntityWrapper<SysHangyedaimaEntity>());
        for(SysHangyedaimaEntity sysHangyedaima : hangyedaimaList){
            sysHangyedaima.setNocheck(false);
            sysHangyedaima.setChecked(list.contains(String.valueOf(sysHangyedaima.getDaimazhi().trim())) ? true : false);
        }
        return JSONArray.fromObject(hangyedaimaList);
    }

    @Override
    public List<SysHangyedaimaEntity> queryList(Map map) {
        return baseMapper.queryList(map);
    }

    @Override
    public List<SysHangyedaimaEntity> dataByCode(String code) {
        return baseMapper.dataByCode(code);
    }

    @Override
    public List<String> getList(List<SysHangyedaimaEntity> list,List<String> strList,Integer hangbiaoshi) {

        if(list!=null){
            for(SysHangyedaimaEntity entity:list){
                if(entity.getFujidaimabiaoshi().equals(hangbiaoshi)){
                    strList.add(entity.getDaimazhi());
                    getList(list,strList,entity.getHangbiaoshi());
                }
            }
        }
        return strList;
    }

    @Override
    public List<String> getIndustryList(Map params) {
        String firstGrade=(String)params.get("firstGrade");
        String secondGrade=(String)params.get("secondGrade");
        String thirdGrade=(String)params.get("thirdGrade");
        String fourGrade=(String)params.get("fourGrade");
        List<String> strList=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        List<SysHangyedaimaEntity> queryList=queryList(map);
        List<SysHangyedaimaEntity> list=new ArrayList<SysHangyedaimaEntity>();
        if(StringUtils.isNotEmpty(firstGrade)){
            if(StringUtils.isNotEmpty(secondGrade)){
                if(StringUtils.isNotEmpty(thirdGrade)){
                    if(StringUtils.isNotEmpty(fourGrade)){
                        list=dataByCode(fourGrade);
                        if(list!=null){
                            strList.add(list.get(0).getDaimazhi());
                            strList=getList(queryList,strList,list.get(0).getHangbiaoshi());
                        }
                    }else {
                        list=dataByCode(thirdGrade);
                        if(list!=null){
                            strList.add(list.get(0).getDaimazhi());
                            strList=getList(queryList,strList,list.get(0).getHangbiaoshi());
                        }
                    }
                }else {
                    list=dataByCode(secondGrade);
                    if(list!=null){
                        strList.add(list.get(0).getDaimazhi());
                        strList=getList(queryList,strList,list.get(0).getHangbiaoshi());
                    }
                }
            }else {
                list=dataByCode(firstGrade);
                if(list!=null){
                    strList.add(list.get(0).getDaimazhi());
                    strList=getList(queryList,strList,list.get(0).getHangbiaoshi());
                }
            }
        }
        return strList;
    }

    @Override
    public List<SelectEntity> selectGetHangYeLieBiao() {
        List<SysHangyedaimaEntity> list=baseMapper.queryList(new HashMap());
        List<SelectEntity> selectlist = new ArrayList<SelectEntity>();
        for(SysHangyedaimaEntity entity : list){
            SelectEntity select = new SelectEntity();
            select.setId(entity.getDaimazhi());
            select.setName(entity.getMingcheng());
            selectlist.add(select);
        }
        return selectlist;
    }
}

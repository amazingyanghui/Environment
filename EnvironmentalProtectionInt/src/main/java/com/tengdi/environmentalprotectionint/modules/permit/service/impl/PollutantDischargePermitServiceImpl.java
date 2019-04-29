package com.tengdi.environmentalprotectionint.modules.permit.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoEnvironmentalManageEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoBaseinfoService;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoEnvironmentalManageService;
import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPortinfoEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorPortinfoService;
import com.tengdi.environmentalprotectionint.modules.permit.dao.PollutantDischargePermitDao;
import com.tengdi.environmentalprotectionint.modules.permit.entity.PollutantDischargePermitAndBaseInfoEntity;
import com.tengdi.environmentalprotectionint.modules.permit.entity.PollutantDischargePermitEntity;
import com.tengdi.environmentalprotectionint.modules.permit.service.PollutantDischargePermitService;
import com.tengdi.core.utils.DateUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;
import org.springframework.transaction.annotation.Transactional;

@Service("pollutantDischargePermitService")
public class PollutantDischargePermitServiceImpl extends ServiceImpl<PollutantDischargePermitDao, PollutantDischargePermitEntity> implements PollutantDischargePermitService {
    @Autowired
    private CominfoBaseinfoService cominfoBaseinfoService;
    @Autowired
    private CominfoEnvironmentalManageService cominfoEnvironmentalManageService;
    @Autowired
    private OnlineMonitorPortinfoService onlineMonitorPortinfoService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String pollutantDischargePermitName = (String)params.get("cid");
        Page<PollutantDischargePermitEntity> page = this.selectPage(
                new Query<PollutantDischargePermitEntity>(params).getPage(),
                new EntityWrapper<PollutantDischargePermitEntity>()
                        .like(StringUtils.isNotBlank(pollutantDischargePermitName),"cid", pollutantDischargePermitName)
        );
        return new PageUtils(page);
    }

    @Override
    public List<PollutantDischargePermitEntity> queryList(Map<String, Object> params) {
        List<PollutantDischargePermitEntity> list = baseMapper.queryList3(params);
        list=getList(list);
        return list;
    }

    @Override
    public PageUtils queryPageSql(Map<String, Object> params) {
        Integer limit = Integer.parseInt((String)params.get("limit"));
        Integer page = Integer.parseInt((String)params.get("page"));
        String differ=(String)params.get("differ");
        String yearType=(String)params.get("yearType");
        String year=(String)params.get("year");
        if(StringUtils.isNotBlank(yearType)){
            if(yearType.equals("1")){
                Integer yearInt=Integer.parseInt(year)-1;
                params.put("year",yearInt);
            }
        }

        if(StringUtils.isNotBlank(differ)){
            if(differ.equals("0")){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                year=sdf.format(DateUtils.getDate());
                params.put("year",year);
            }
        }
        Query query = new Query(params);
        List<PollutantDischargePermitEntity> list = baseMapper.queryList3(query);
        list=getList(list);
        int count = baseMapper.count(params);
        return new PageUtils(list,count,limit,page);
    }

    @Override
    public List<PollutantDischargePermitEntity> queryName(Map<String, Object> params) {
        List<PollutantDischargePermitEntity> list = baseMapper.queryName(params);
        list=getList(list);
        return list;
    }

    @Override
    public List<PollutantDischargePermitEntity> dataById(String cid) {
        List<PollutantDischargePermitEntity> list = baseMapper.dataById(cid);
        list=getList(list);
        return list;
    }

    @Override
    public List<PollutantDischargePermitEntity> getList(List<PollutantDischargePermitEntity> list) {
        if(list.size()>0){
            for(PollutantDischargePermitEntity entity:list){
                if(entity.getIndustryids() != null && !entity.getIndustryids().equals("")){
                    String industryidstemp=cominfoBaseinfoService.getIndustry(entity.getIndustryids());
                    if(StringUtils.isNotBlank(industryidstemp)){
                        entity.setIndustry(industryidstemp);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public JSONArray basestaticcount(String year ){

        int curyearpers = 0 ;
        int totalpers = 0 ;
        int curyearformpers = 0 ;
        int curyeartempers = 0 ;
        int lastyearpers = 0 ;
        curyearpers =baseMapper.curyeartotalpermits(year) ;
        totalpers = baseMapper.totalpermit(year);
        curyearformpers = baseMapper.formal(year);
        curyeartempers = baseMapper.provisional(year);
        lastyearpers = baseMapper.lastyeartotalpermit(year);

        JSONArray jsonArr = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        String curyearpermits ="curyearpermits",
                totalpermits ="totalpermits",
                curyearformalpermit ="curyearformalpermit",
                curyeartemppermit ="curyeartemppermit" ,
                lastyearpermit ="lastyearpermit";
        jsonObj.put(curyearpermits,curyearpers) ;
        jsonObj.put(totalpermits,totalpers) ;
        jsonObj.put(curyearformalpermit,curyearformpers) ;
        jsonObj.put(curyeartemppermit,curyeartempers) ;
        jsonObj.put(lastyearpermit,lastyearpers) ;
        jsonArr.add(jsonObj) ;
        return jsonArr;
    }

    @Override
    public JSONArray monthstaticcount(String year){
        List<PollutantDischargePermitEntity> list ;
        list = baseMapper.monthpermitList(year) ;
        String month ="month", counts ="counts";
        JSONArray jsonArr = new JSONArray();
        JSONObject jsonObj= new JSONObject();
        for(int i=0;i<list.size();i++){
            PollutantDischargePermitEntity pollutantDischargePermitEntity = list.get(i);
            jsonObj.put(month,Integer.parseInt((String)pollutantDischargePermitEntity.getMonth()));
            jsonObj.put(counts,Integer.parseInt((String)pollutantDischargePermitEntity.getCounts()));
            jsonArr.add(jsonObj);
        }
        return jsonArr;
    }

    @Override
    public JSONArray industrystaticcount(String year){
        int curyearpers = 0 ;
        JSONArray jsonArr = new JSONArray();
        List<PollutantDischargePermitEntity> list ;
        curyearpers =baseMapper.curyeartotalpermits(year) ;
        list = baseMapper.industrypermitList(year) ;
        list=getList(list);
        String percents = "" ;
        NumberFormat numberFormat = NumberFormat.getInstance();
        for(int i=0;i<list.size();i++){
            String industry = "name",//"illegalType", //用于年度查询比较
                    industrypermits = "industrypermits",
                    industrypermitscale = "y";//
            JSONObject jsonObj = new JSONObject();
            PollutantDischargePermitEntity pollutantDischargePermitEntity = list.get(i);

            if(curyearpers==0){
                percents="0";
            }else{
                percents = numberFormat.format((float) Integer.parseInt(pollutantDischargePermitEntity.getIndustrypermits()) / (float) curyearpers * 100);
                // System.out.println("行业为:" + Integer.parseInt(pollutantDischargePermitEntity.getIndustrypermits()) );
            }
            jsonObj.put(industrypermitscale,Double.parseDouble(percents));
            jsonObj.put(industrypermits,Integer.parseInt(pollutantDischargePermitEntity.getIndustrypermits()) );

            //System.out.println("百分比为:" + percents + "%");
            if(pollutantDischargePermitEntity.getIndustry()!=null){
                jsonObj.put(industry,pollutantDischargePermitEntity.getIndustry());
            }else{
                jsonObj.put(industry,"未知类型"); // 企业类别为null
            }

            jsonArr.add(jsonObj);
        }
        return jsonArr;

    }




    @Override
    public List<SelectEntity> list(String cid) {
        List<PollutantDischargePermitEntity> list =
                this.selectList(new EntityWrapper<PollutantDischargePermitEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid", cid)
                );

        List<SelectEntity> selectlist = new ArrayList<SelectEntity>();
        for(PollutantDischargePermitEntity entity : list){
            SelectEntity select = new SelectEntity();
            select.setId(entity.getPid());
            select.setName(entity.getPermitCode());
            selectlist.add(select);
        }

        return selectlist;
    }

    @Override
    public PollutantDischargePermitAndBaseInfoEntity getBaseInfoForEnvironment(String pid) {
        PollutantDischargePermitAndBaseInfoEntity entity=baseMapper.getBaseInfoForEnvironment(pid);
        List<PollutantDischargePermitAndBaseInfoEntity> list=getPaiKouInfoForEnvironment(pid);
        entity.setBaseInfoEntityList(list);
        return entity;
    }

    @Override
    public List<PollutantDischargePermitAndBaseInfoEntity> getPaiKouInfoForEnvironment(String pid) {
        return baseMapper.getPaiKouInfoForEnvironment(pid);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateEnvironmentInfo(PollutantDischargePermitAndBaseInfoEntity entity) {
        CominfoEnvironmentalManageEntity manageEntity=new CominfoEnvironmentalManageEntity();
        manageEntity.setPid(entity.getEid());
        manageEntity.setIsSampling(entity.getIsSampling());
        manageEntity.setIsOceaneering(entity.getIsOceaneering());
        manageEntity.setIsSewagetreatmentSites(entity.getIsSewagetreatmentSites());
        manageEntity.setIsDomesticwasteSites(entity.getIsDomesticwasteSites());
        manageEntity.setUpdatedate(DateUtils.getStringDate());
        cominfoEnvironmentalManageService.updateForEnvironment(manageEntity);
        List<PollutantDischargePermitAndBaseInfoEntity> entityList=entity.getBaseInfoEntityList();
        for(PollutantDischargePermitAndBaseInfoEntity baseInfoEntity:entityList){
            OnlineMonitorPortinfoEntity portinfoEntity=new OnlineMonitorPortinfoEntity();
            portinfoEntity.setPid(baseInfoEntity.getOid());
            portinfoEntity.setTaxSourceCode(baseInfoEntity.getTaxSourceCode());
            portinfoEntity.setAirpollutantType(baseInfoEntity.getAirpollutantType());
            portinfoEntity.setUpdatedate(DateUtils.getDate());
            onlineMonitorPortinfoService.updateForEnvironment(portinfoEntity);
            PollutantDischargePermitEntity permitEntity=new PollutantDischargePermitEntity();
            permitEntity.setPid(entity.getPid());
            permitEntity.setControlRequirements(entity.getControlRequirements());
            permitEntity.setUpdatedate(DateUtils.getDate());
            baseMapper.updateForEnvironment(permitEntity);
        }
    }

    @Override
    public int updateForEnvironment(PollutantDischargePermitEntity entity) {
        return baseMapper.updateForEnvironment(entity);
    }
}

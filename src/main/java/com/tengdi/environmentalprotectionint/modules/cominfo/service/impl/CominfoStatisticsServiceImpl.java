package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.MapUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;
import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoEnvironmentalManageDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoStatisticsDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoEnvironmentalManageEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.SysHangyedaimaEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoEnvironmentalManageService;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoStatisticsService;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.SysHangyedaimaService;
import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorPortinfoService;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysDictService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("cominfoStatisticsServiceImpl")
public class CominfoStatisticsServiceImpl extends ServiceImpl<CominfoStatisticsDao, CominfoEnvironmentalManageEntity> implements CominfoStatisticsService {

    @Autowired
    private SysDictService sysDictService;
    @Autowired
    private SysHangyedaimaService sysHangyedaimaService;
    @Autowired
    private OnlineMonitorPortinfoService onlineMonitorPortinfoService;


    // 查询
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Integer limit = Integer.parseInt((String)params.get("limit"));
        Integer page = Integer.parseInt((String)params.get("page"));
        String pollutionSourceCategory = (String)params.get("pollutionSourceCategory");
        if(pollutionSourceCategory != null && !pollutionSourceCategory.equals("")){
            params.put("pollutionSourceCategory",pollutionSourceCategory.split("-"));
        }
        Query query = new Query(params);
        List<CominfoBaseinfoEntity> list = baseMapper.queryPage(query);
        for(CominfoBaseinfoEntity cominfoBaseinfo:list){
            if(cominfoBaseinfo.getIndustryids() != null && !cominfoBaseinfo.getIndustryids().equals("")){
                String industryidstemp = getIndustry(cominfoBaseinfo.getIndustryids());
                if(StringUtils.isNotBlank(industryidstemp)){
                    cominfoBaseinfo.setIndustry(industryidstemp);
                }
            }
        }
        List<CominfoBaseinfoEntity> queryList=new ArrayList<>();
        String monitorType=(String) query.get("monitorType");
        if(StringUtils.isNotBlank(monitorType)){
            Integer type= Integer.valueOf(monitorType);
            for (CominfoBaseinfoEntity entity:list){
                List<SelectEntity> entityList =onlineMonitorPortinfoService.list(entity.getPid());
                if(entityList!=null){
                    boolean flag=false;
                    for(SelectEntity selectEntity:entityList){
                        if(type.equals(selectEntity.getType())){
                            flag=true;
                        }
                    }
                    if(flag){
                        queryList.add(entity);
                    }
                }
            }
            list=queryList;
        }
        int count = baseMapper.count(params);
        return new PageUtils(list,count,limit,page);

    }



    @Override
    public CominfoEnvironmentalManageEntity dataById(String cid) {
        return baseMapper.dataById(cid);
    }

    //查询统计基础信息,首页的第一排框
    @Override
    public JSONArray baseInfoStatic(){
        int count = 0 ;
        int keyCount = 0 ;

        int tempCount = 0;          //临时企业个数
        int registerCount = 0;      //注册企业个数
        int checkCount = 0;         //待审核企业个数
        int checkedCount = 0;       //已审核企业个数


        int waterSourceCount = 0 ;
        int airSourceCount= 0 ;
        int VOCsourceCount = 0 ;
        int riskSourceCount = 0 ;
        count =baseMapper.sourceCount();              //企业总数
        keyCount = baseMapper.keySourceCount();       //重点污染源

//        waterSourceCount = baseMapper.waterSourceCount();   //废水产生源
//        airSourceCount = baseMapper.airSourceCount();       //废气产生源
//        VOCsourceCount = baseMapper.VocSourceCount();       //VOCs产生源
//        riskSourceCount = baseMapper.riskSourceCount();     //风险源
        JSONArray jsonArr = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("count",count);
        jsonObj.put("keyCount",keyCount);

        jsonObj.put("tempCount",tempCount);
        jsonObj.put("registerCount",registerCount);
        jsonObj.put("checkCount",checkCount);
        jsonObj.put("checkedCount",checkedCount);

        jsonArr.add(jsonObj) ;
        return jsonArr;
    }

    //企业统计 按规模查询
    @Override
    public JSONArray enterpriScaleStatic(){
        //规模字典
        String type="enterprise_scale_type";
        Map<String, Object> dictMap = getDictMap(type);
        List<CominfoEnvironmentalManageEntity> dataList = baseMapper.enterpriScaleStaticList();
        JSONArray jsonArr = getEnterpriScaleStaticJsonArray(dataList, dictMap);
        return  jsonArr ;
    }
    private Map<String, Object> getDictMap(String type) {
        List<SysDictEntity> dictList = sysDictService.selectByMap(new MapUtils().put("type",type));
        Map<String,Object> dictMap = new HashMap<>();
        for (SysDictEntity entity : dictList) {
            dictMap.put(entity.getKey().toString(),entity.getValue());
        }
        return dictMap;
    }
    private JSONArray getEnterpriScaleStaticJsonArray(List<CominfoEnvironmentalManageEntity> dataList, Map<String, Object> dictMap) {
        JSONArray jsonArr = new JSONArray();
        int other = 0;
        CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity = null;
        JSONObject jsonObj = null;
        for(int i=0;i<dataList.size();i++){
            cominfoEnvironmentalManageEntity = dataList.get(i);
            jsonObj = new JSONObject();
            if(dictMap.containsKey(cominfoEnvironmentalManageEntity.getEnterpriseScale())){
                jsonObj.put("name",dictMap.get(cominfoEnvironmentalManageEntity.getEnterpriseScale()));
                jsonObj.put("y",Integer.parseInt(cominfoEnvironmentalManageEntity.getEnterpriseCount()));
                jsonArr.add(jsonObj);
            }else {
                other += Integer.parseInt(cominfoEnvironmentalManageEntity.getEnterpriseCount());
            }
        }
        if(other > 0){
            jsonObj.put("name","其他");
            jsonObj.put("y",other);
            jsonArr.add(jsonObj);
        }
        return jsonArr;
    }

    //企业统计 按区域查询
    @Override
    public JSONArray enterpriAreaStatic() {
        String type="enterprise_area_type";     // todo 后期维护,暂时在表中以 industrial_area 字段使用
        List<SysDictEntity> dictList = sysDictService.selectByMap(new MapUtils().put("type",type));
        List<Map<String,Object>> datalist = baseMapper.enterpriAreaStaticList();
        JSONArray jsonArr = new JSONArray();
        JSONObject jsonObject = null;
        int other = 0;
        for (Map<String, Object> map : datalist) {
            jsonObject = new JSONObject();
            if(map.containsKey("areaName") && (!"".equals(map.get("areaName")))){
                jsonObject.put("name",map.get("areaName"));
                jsonObject.put("y",map.get("areaCount"));
                jsonArr.add(jsonObject);
            }else if(map.containsKey("areaCount")){
                other += Integer.parseInt(map.get("areaCount").toString());
            }
        }
        if(other > 0 ){
            jsonObject.put("name","其他");
            jsonObject.put("y",other);
            jsonArr.add(jsonObject);
        }
        return  jsonArr ;
    }


    // 执法统计
    @Override
    public JSONObject lawEnforceStatic(Map<String, Object> params) {
        List<Map<String, Object>> list = baseMapper.lawEnforceStatic(params);
        JSONObject jsonObject = null;
        String[] name = null;
        int[] count = null;
        if(null != list && list.size()>0){
            jsonObject = new JSONObject();
            name = new String[list.size()];
            count = new int[list.size()];
            Map<String,Object> map = null;
            for (int i = 0; i < list.size(); i++) {
                map = list.get(i);
                if("".equals(map.get("areaName"))){
                    name[i] = "其他";
                    count[i] = Integer.parseInt(map.get("areaCount").toString());
                }else {
                    name[i] = map.get("areaName").toString();
                    count[i] = Integer.parseInt(map.get("areaCount").toString());
                }
            }
            jsonObject.put("name",name);
            jsonObject.put("count",count);
        }
        return jsonObject;
    }














    @Override
    public String getIndustry(String code) {
        String[] industryids = code.split(",");
        String industryidstemp = "";
        for(String industryid : industryids){
            List<SysHangyedaimaEntity> sysList = sysHangyedaimaService.selectByMap(new MapUtils().put("DaiMaZhi",industryid));
            if(sysList.size()>0){
                SysHangyedaimaEntity sysHangyedaima = sysList.get(0);
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







    public JSONArray sourceCategoryStatic(){
        JSONArray jsonArray = new JSONArray();
        int totalCompany = 0 ;
        List<CominfoEnvironmentalManageEntity> list ;
        totalCompany =baseMapper.sourceCount(); //企业总数
        list = baseMapper.sourceCategoryStaticList();
        String type="pollution_source_category_type";
        List<SysDictEntity> list2 = sysDictService.selectByMap(new MapUtils().put("type",type));
        String percents = "" ;
        NumberFormat numberFormat = NumberFormat.getInstance();
        for(int i=0;i<list.size();i++){
            String sourcecategory = "name",
                    sourcecount = "sourcecount",
                    sourcescale = "y";//
            JSONObject jsonObj = new JSONObject();
            CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity = list.get(i);
            if(totalCompany==0){
                percents="0";
            }else{
                percents = numberFormat.format((float) Integer.parseInt(cominfoEnvironmentalManageEntity.getSourcecounts()) / (float) totalCompany * 100);
            }
            jsonObj.put(sourcescale,Double.parseDouble(percents));
            jsonObj.put(sourcecount,Integer.parseInt(cominfoEnvironmentalManageEntity.getSourcecounts()) );

            for (SysDictEntity dictEntity : list2) {
                if(cominfoEnvironmentalManageEntity.getSourcecategory()!=null&&!cominfoEnvironmentalManageEntity.getSourcecategory().equals("Null")){
                    if(dictEntity.getKey()==Integer.parseInt(cominfoEnvironmentalManageEntity.getSourcecategory())){
                        jsonObj.put(sourcecategory,dictEntity.getValue());
                        break;
                    }
                }else{
                    jsonObj.put(sourcecategory,"无");
                }

            }

            jsonArray.add(jsonObj);
        }
        return jsonArray ;
    }
    public JSONArray riskLevelStatic(){
        JSONArray jsonArr = new JSONArray();
        List<CominfoEnvironmentalManageEntity> list ;
        list = baseMapper.riskLevelStaticList();
        String DictType = "risk_rating" ;
        String  riskLevelName= "" ;
        for(int i=0;i<list.size();i++){
            CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity = list.get(i);
            JSONObject jsonObj = new JSONObject();
            String riskLevel = "riskLevel",
                    riskCount = "riskCount";

            List<SysDictEntity> dictList = sysDictService.selectByMap(new MapUtils().put("type",DictType));
            if (cominfoEnvironmentalManageEntity.getRiskLevel() != null) {
                for (SysDictEntity record : dictList) {
                    if (cominfoEnvironmentalManageEntity.getRiskLevel() != null) {
                        if (Integer.parseInt(cominfoEnvironmentalManageEntity.getRiskLevel()) == record.getKey()) {
                            riskLevelName = record.getValue();
                        }
                    }

                }
            }
            jsonObj.put(riskLevel,riskLevelName);
            jsonObj.put(riskCount,Integer.parseInt(cominfoEnvironmentalManageEntity.getRiskCount()));
            jsonArr.add(jsonObj);
        }
        return  jsonArr ;
    }
    @Override
    public JSONArray industryidStatic(){
        JSONArray jsonArr = new JSONArray();
        List<CominfoEnvironmentalManageEntity> list ;

        List<CominfoEnvironmentalManageEntity> list2 = new ArrayList<CominfoEnvironmentalManageEntity>();
        List<CominfoEnvironmentalManageEntity> list3 = new ArrayList<CominfoEnvironmentalManageEntity>();
        List<CominfoEnvironmentalManageEntity> first_list ;
        List<CominfoEnvironmentalManageEntity> second_list ;
        List<CominfoEnvironmentalManageEntity> third_list ;
        List<CominfoEnvironmentalManageEntity> fouth_list ;
        List<CominfoEnvironmentalManageEntity> fif_list ;
        list = baseMapper.industryidStaticList();
        first_list = baseMapper.firstOrder();
        second_list = baseMapper.secondOrder();
        third_list = baseMapper.thirdOrder();
        fouth_list = baseMapper.fouthOrder();
        JSONObject jsonObj_ = new JSONObject();
        jsonObj_.put("id","0");
        jsonObj_.put("name","企业总数");
        jsonObj_.put("parent","");
        jsonArr.add(jsonObj_);

        /**
         * 获取两级结构旭日图数据统计
         */
        // 1 查询企业总数

        // 2 查询17个大类对应每个类的总数(包括自身等级与下面的不同层级的总数之和)

        // 3 查询大类下面的几十个小类的总数(自身等级数量与对应下面层级的数量之和)

        //最低层级合算
        int sum4 =0 ;
        for(int j=0;j<fouth_list.size();j++){

            CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity2 = fouth_list.get(j);
             sum4 += Integer.parseInt(cominfoEnvironmentalManageEntity2.getIndustryidCount()) ;

        }

        int sum3 = 0 ;
        List<CominfoEnvironmentalManageEntity> list1 = new ArrayList<CominfoEnvironmentalManageEntity>();
        for(int i=0;i<third_list.size();i++){

            CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity1 = third_list.get(i);
            sum3 += Integer.parseInt(cominfoEnvironmentalManageEntity1.getIndustryidCount()) ;
            CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity_1_=new CominfoEnvironmentalManageEntity() ;
            for(int j=0;j<fouth_list.size();j++){
                CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity2 = fouth_list.get(j);
                if(cominfoEnvironmentalManageEntity2.getParent().equals(cominfoEnvironmentalManageEntity1.getIndustryID())){ //将第四级的类型数量放入第三级（存在着四级本级没有 但是下一级有值的情况
                    int count_ = 0 ;
                    count_ = Integer.parseInt(cominfoEnvironmentalManageEntity1.getIndustryidCount())+Integer.parseInt((String)cominfoEnvironmentalManageEntity2.getIndustryidCount());
                    cominfoEnvironmentalManageEntity1.setIndustryidCount(String.valueOf( count_));
                    cominfoEnvironmentalManageEntity2.setCancelManagement(1);
                }
            }
        }
        for(CominfoEnvironmentalManageEntity entrty:fouth_list){
            if(!(entrty.getCancelManagement().equals(1))){
                CominfoEnvironmentalManageEntity entrty1=new CominfoEnvironmentalManageEntity();
                entrty1.setParent(entrty.getParparent());
                entrty1.setIndustryidCount(entrty.getIndustryidCount());
                entrty1.setIndustryName(entrty.getParname());
                entrty1.setIndustryID(entrty.getParent());
               third_list.add( entrty1);
            }
        }


        int third_value3 = 0 ;
        for(int i=0;i<third_list.size();i++){
            CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity_ = third_list.get(i);
            third_value3+= Integer.parseInt(cominfoEnvironmentalManageEntity_.getIndustryidCount());
        }
        int sum2 = 0 ;
        for(int i=0;i<second_list.size();i++){

            CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity1 = second_list.get(i);
            sum2 += Integer.parseInt(cominfoEnvironmentalManageEntity1.getIndustryidCount()) ;
            for(int j=0;j<third_list.size();j++){

                CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity2 = third_list.get(j);
                if(cominfoEnvironmentalManageEntity2.getParent().equals(cominfoEnvironmentalManageEntity1.getIndustryID())){ //查询出的四级类别与查出来有值的第三级类别比较
                    int count_ = 0 ;
                    count_ = Integer.parseInt(cominfoEnvironmentalManageEntity1.getIndustryidCount())+Integer.parseInt((String)cominfoEnvironmentalManageEntity2.getIndustryidCount());
                    cominfoEnvironmentalManageEntity1.setIndustryidCount(String.valueOf( count_));
                }else{
                    CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity_=new CominfoEnvironmentalManageEntity() ;
                    cominfoEnvironmentalManageEntity_.setParent(cominfoEnvironmentalManageEntity2.getParparent());
                    cominfoEnvironmentalManageEntity_.setIndustryidCount(cominfoEnvironmentalManageEntity2.getIndustryidCount());
                    cominfoEnvironmentalManageEntity_.setIndustryName(cominfoEnvironmentalManageEntity2.getParname());
                    cominfoEnvironmentalManageEntity_.setIndustryID(cominfoEnvironmentalManageEntity2.getParent());
                  //  list2.add(cominfoEnvironmentalManageEntity_);

                }

            }
        }
        int third_value2 = 0 ;
        for(int i=0;i<second_list.size();i++){
            CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity_ = second_list.get(i);
            third_value2+= Integer.parseInt(cominfoEnvironmentalManageEntity_.getIndustryidCount());
        }

        int sum1 = 0 ;
        for(int i=0;i<first_list.size();i++){

            CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity1 = first_list.get(i);
            sum1 += Integer.parseInt(cominfoEnvironmentalManageEntity1.getIndustryidCount()) ;
            for(int j=0;j<second_list.size();j++){

                CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity2 = second_list.get(j);
                if(cominfoEnvironmentalManageEntity2.getParent().equals(cominfoEnvironmentalManageEntity1.getIndustryID())){
                    int count_ = 0 ;
                    count_ = Integer.parseInt(cominfoEnvironmentalManageEntity1.getIndustryidCount())+Integer.parseInt((String)cominfoEnvironmentalManageEntity2.getIndustryidCount());
                    cominfoEnvironmentalManageEntity1.setIndustryidCount(String.valueOf( count_));
                }else {
                    CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity_=new CominfoEnvironmentalManageEntity() ;
                    cominfoEnvironmentalManageEntity_.setParent(cominfoEnvironmentalManageEntity2.getParparent());
                    cominfoEnvironmentalManageEntity_.setIndustryidCount(cominfoEnvironmentalManageEntity2.getIndustryidCount());
                    cominfoEnvironmentalManageEntity_.setIndustryName(cominfoEnvironmentalManageEntity2.getParname());
                    cominfoEnvironmentalManageEntity_.setIndustryID(cominfoEnvironmentalManageEntity2.getParent());
                    //list3.add(cominfoEnvironmentalManageEntity_);
                }

            }
        }


        int third_value1 = 0 ;
        for(int i=0;i<first_list.size();i++){
            CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity_ = first_list.get(i);
            third_value1+= Integer.parseInt(cominfoEnvironmentalManageEntity_.getIndustryidCount());
            //System.out.println("合算后second_list的父级工业类别名称 ====> "+cominfoEnvironmentalManageEntity_.getIndustryName());
            //System.out.println("合算后second_list的父级工业类别企业数量 ====> "+cominfoEnvironmentalManageEntity_.getIndustryidCount());
        }


        for(int i=0;i<list.size();i++){
            CominfoEnvironmentalManageEntity cominfoEnvironmentalManageEntity = list.get(i);
            JSONObject jsonObj = new JSONObject();
            String industryCode = "id",
                    industryidCount = "value",
                    parent = "parent",
                    industryName = "name";
            jsonObj.put(industryCode,cominfoEnvironmentalManageEntity.getIndustryCode());

            //数据格式过滤行业大类
            if(!(cominfoEnvironmentalManageEntity.getIndustryCode().equals("A")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("B")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("C")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("D")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("E")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("F")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("G")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("H")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("I")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("K")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("L")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("M")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("N")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("O")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("Q")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("R")||
                    cominfoEnvironmentalManageEntity.getIndustryCode().equals("S")
            )){
                if(cominfoEnvironmentalManageEntity.getIndustryidCount()!=null){
                    jsonObj.put(industryidCount,Integer.parseInt(cominfoEnvironmentalManageEntity.getIndustryidCount()));
                }
            }

            jsonObj.put(industryName,cominfoEnvironmentalManageEntity.getIndustryName());
            if(cominfoEnvironmentalManageEntity.getParent()==null){
                jsonObj.put(parent,"");
            }else {
                jsonObj.put(parent,cominfoEnvironmentalManageEntity.getParent());
            }

            jsonArr.add(jsonObj);
        }
        return  jsonArr ;
    }
    @Override
    public int updateForEnvironment(CominfoEnvironmentalManageEntity environmentalManageEntity) {
        return baseMapper.updateForEnvironment(environmentalManageEntity);
    }
}

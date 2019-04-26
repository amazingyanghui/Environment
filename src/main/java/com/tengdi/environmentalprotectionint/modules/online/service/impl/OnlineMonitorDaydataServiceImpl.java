package com.tengdi.environmentalprotectionint.modules.online.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.SysHangyedaimaEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.SysHangyedaimaService;
import com.tengdi.environmentalprotectionint.modules.common.entity.OnlineCommonEntity;
import com.tengdi.environmentalprotectionint.modules.common.utils.Utils;
import com.tengdi.environmentalprotectionint.modules.online.dao.OnlineMonitorDaydataDao;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorDaydataEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorFactorEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPointFactorEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineTableRetrieveEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorDaydataService;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorFactorService;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorPointFactorService;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineTableRetrieveService;
import com.tengdi.core.utils.MapUtils;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("onlineMonitorDaydataService")
public class OnlineMonitorDaydataServiceImpl extends ServiceImpl<OnlineMonitorDaydataDao, OnlineMonitorDaydataEntity> implements OnlineMonitorDaydataService {
    @Autowired
    private SysHangyedaimaService sysHangyedaimaService;
    @Autowired
    private OnlineTableRetrieveService onlineTableRetrieveService;
    @Autowired
    private OnlineMonitorPointFactorService onlineMonitorPointFactorService;
    @Autowired
    private OnlineMonitorFactorService onlineMonitorFactorService;
    //获取废气废水因子
    @Value("${tengdi.commonConfig.FactorStr}")
    private String[] FactorStr;

    @Override
    public List<SysDictEntity> dictList(String type) {
        return baseMapper.dictList(type);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String onlineMonitorDaydataName = (String)params.get("onlineMonitorDaydataName");
        Page<OnlineMonitorDaydataEntity> page = this.selectPage(
                new Query<OnlineMonitorDaydataEntity>(params).getPage(),
                new EntityWrapper<OnlineMonitorDaydataEntity>()
                        .like(StringUtils.isNotBlank(onlineMonitorDaydataName),"onlineMonitorDaydataName", onlineMonitorDaydataName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<OnlineMonitorDaydataEntity> queryList(Map map) {
        return baseMapper.queryList(map);
    }

    @Override
    public OnlineCommonEntity onlineDayData(OnlineCommonEntity onlineCommonEntity) {
        Map<String, Object> map = new HashMap<>();
        map.put("cid",onlineCommonEntity.getCid());
        map.put("mid",onlineCommonEntity.getMid());
        map.put("startDate",onlineCommonEntity.getStartDate());
        map.put("endDate",onlineCommonEntity.getEndDate());
        List<double[]> testDataList = new ArrayList<>();
        List<String> nameList=new ArrayList<>();
        String nameStr=null;
        List<Integer> isEnvironmentFactorList=new ArrayList<>();
        List<Double> maximumValueList=new ArrayList<>();
        List<Double> minimumValueList=new ArrayList<>();
        String mid = (String) map.get("mid");
        List<String> factorList=onlineCommonEntity.getFactorList();//因子id的list
        if (mid != null) {
            //从表名检索表得出日数据表名和小时数据表名
            OnlineTableRetrieveEntity retrieveEntity=onlineTableRetrieveService.dataByCid(map);
            if(retrieveEntity!=null) {
                map.put("tableName", retrieveEntity.getDdTabName());//表名
                boolean flag=true;
                if (factorList == null || factorList.get(0).equals("[]")) {
                    flag=false;
                    List<OnlineMonitorPointFactorEntity> factorEntityList = onlineMonitorPointFactorService.dataByMid(mid);
                    factorList=new ArrayList<>();
                    for(int i=0;i<factorEntityList.size();i++){
                        factorList.add(factorEntityList.get(i).getFid());
                    }
                }
                for (int i = 0; i < factorList.size(); i++) {//根据每个因子id查出因子表数据
                    String factor = factorList.get(i);
                    //本地系统不需要了，因手机端要求注掉这一段
//                    if(flag){
//                        factor = factor.substring(factor.indexOf('"') + 1, factor.lastIndexOf('"'));
//                    }
                    //获取因子名称
                    OnlineMonitorFactorEntity monitorFactorEntity = onlineMonitorFactorService.selectByMap(new MapUtils().put("factor_code",factor)).get(0);
//                    nameList.add(monitorFactorEntity.getFactorName()+monitorFactorEntity.getEmissionUnit());
                    //获取因子最大值和最小值
                    OnlineMonitorPointFactorEntity factorEntities= onlineMonitorPointFactorService.selectByMap(new MapUtils().put("fid",factor).put("mid",mid)).get(0);
                    maximumValueList.add(factorEntities.getMaximumValue());
                    minimumValueList.add(factorEntities.getMinimumValue());
                    map.put("fid", factor);
                    //因子id和排口id查出所属日数据
                    List<OnlineMonitorDaydataEntity> list = queryList(map);
                    StringBuffer str = new StringBuffer();
                    if(Arrays.asList(FactorStr).contains(factor)){//是否是废水和废气
                        //因子名称加排放量单位
                        if(monitorFactorEntity.getEmissionUnit()!=null){
                            nameStr=monitorFactorEntity.getFactorName()+"（"+monitorFactorEntity.getEmissionUnit()+"）";
                        }else {
                            nameStr=monitorFactorEntity.getFactorName()+"（）";
                        }
                        nameList.add(nameStr);
                        isEnvironmentFactorList.add(0);
                        for (OnlineMonitorDaydataEntity entity : list) {
                            str.append(entity.getCouValue() + ",");
                        }
                    }else{
                        //因子名称加浓度单位
                        if(monitorFactorEntity.getEmissionUnit()!=null){
                            nameStr=monitorFactorEntity.getFactorName()+"（"+monitorFactorEntity.getUnit()+"）";
                        }else {
                            nameStr=monitorFactorEntity.getFactorName()+"（）";
                        }
                        nameList.add(nameStr);
                        isEnvironmentFactorList.add(1);
                        for (OnlineMonitorDaydataEntity entity : list) {
                            str.append(entity.getAvgValue() + ",");
                        }
                    }

                    String[] testData = str.toString().split(",");
                    double[] data = null;
                    if (!str.toString().equals("")) {
                        data = Utils.StringToInt(testData);
                    }
                    testDataList.add(data);
                }
            }
        }
        onlineCommonEntity.setTestDataList(testDataList);
        onlineCommonEntity.setNameList(nameList);
        onlineCommonEntity.setIsEnvironmentFactorList(isEnvironmentFactorList);
        onlineCommonEntity.setMaximumValueList(maximumValueList);
        onlineCommonEntity.setMinimumValueList(minimumValueList);
        return onlineCommonEntity;
    }

    /**
     * 在线监控统计-监控企业、重点监控、水监控、气监控、voc监控
     */
    @Override
    public List<Map<String, Object>> onlineMonitoring() {
        return baseMapper.onlineMonitoring();
    }
    /**
     *  在线监控统计-根据统计类型联动获取该类型的污染因子
     */
    @Override
    public List<OnlineMonitorFactorEntity> selFactorByStatisticalType(String type) {
        return baseMapper.selFactorByStatisticalType(type);
    }
    /**
     *  在线监控统计-月排放量统计
     */
    @Override
    public  Object []  monthlyEmissionStatistics(String year, String type,String fid) {
        Map<String, Object> map = new HashMap<>();
        map.put("tableNames","online_monitor_daydata");
        map.put("fid",fid);
        map.put("newyear",year);
        List<OnlineMonitorDaydataEntity> list = baseMapper.selDailyDataByfactorGroupMonth(map);
        List<Double> listValue = new ArrayList<Double>();
        Map<Integer,Double> mapvalue = new HashMap<Integer,Double>();
        for(OnlineMonitorDaydataEntity entity : list){
            Double value = 0.0;
//            if(type.equals("1")){//废气（取折算排放量）
//                value = Double.parseDouble(entity.getZscouValue());
//            }else{
                value = Double.parseDouble(entity.getCouValue());
//            }
            String month = entity.getCreatedate().substring(5,7);

            mapvalue.put(Integer.parseInt(month),value);
        }

        for(int i = 1 ; i <= 12;i++){
            if(mapvalue.get(i) != null){
                listValue.add(mapvalue.get(i));
            }else{
                listValue.add(0.0);
            }
        }

        return listValue.toArray();
    }

    @Override
    public JSONArray monthlyEmissionStatisticsConversion(int[] monthContainer) {
        String key1 = "month", key2 = "number";
        JSONArray jsonArr = new JSONArray();
        for(int i=0;i<monthContainer.length;i++){
            JSONObject jsonObjTemp = new JSONObject();
            jsonObjTemp.put(key1,"name");
            jsonObjTemp.put(key2,monthContainer[i]);
            jsonArr.add(jsonObjTemp);
        }
        return jsonArr;
    }
    /**
     * 在线监控统计-本年排放量与去年对比
     */
    @Override
    public Double[] yearAndLastyearContrastByEmissions(String year, String type,String fid) {
        Map<String, Object> map =new HashMap<>();
        int year1=Integer.parseInt(year);
        int lastYear=year1-1;
        map.put("year",year);
        map.put("lastYear",lastYear);
        map.put("tableName","online_monitor_daydata");
        map.put("fid",fid);
        //获取今年和去年所有日数据表
        Double [] yearContainer=new Double [2];
        Double value = 0.0;
        Double value1 = 0.0;
        List<OnlineMonitorDaydataEntity>  list = baseMapper.selDailyData(map);
        List<OnlineMonitorDaydataEntity>  list1 = baseMapper.selDailyDatalastYear(map);
        for(OnlineMonitorDaydataEntity entity : list){
//            if(type.equals("1")){//废气（取折算排放量）
//                value += Double.parseDouble(entity.getZscouValue());
//            }else{
                value += Double.parseDouble(entity.getCouValue());
//            }
        }
        for(OnlineMonitorDaydataEntity entity : list1){
//            if(type.equals("1")){//废气（取折算排放量）
//                value1 += Double.parseDouble(entity.getZscouValue());
//            }else{
                value1 += Double.parseDouble(entity.getCouValue());
//            }
        }
        yearContainer[0]=value;
        yearContainer[1]=value1;
        return yearContainer;
    }
    /**
     * 在线监控统计-排放量排行榜
     */
    @Override
    public  Map<String, Object>  emissionRanking(String year, String type,String fid) {
        Map<String, Object> map =new HashMap<>();
        int year1=Integer.parseInt(year);
        int lastYear=year1-1;
        map.put("year",year);
        map.put("lastYear",lastYear);
        map.put("tableName","online_monitor_companydaydata");
        map.put("fid",fid);
        map.put("type",type);
       //获取所有企业某因子排行数据
        List<Map<String,Object>> list=baseMapper.enterprise(map);
        Double [] value=new Double [list.size()];
        String [] name=new String [list.size()];
        for(int i=0;i<list.size();i++){
            Map<String,Object> map2 =list.get(i);
            value[i]=Double.parseDouble((String)map2.get("valueSum"));
            name[i]=(String)map2.get("companyName");
        }
        Map<String, Object> map3 =new HashMap<>();
        map3.put("name",name);
        map3.put("value",value);
        return map3;
    }
    /**
     *在线监控统计-废水实时排放情况
     */
    @Override
    public Map<String, Object> RealtimeEmissions(String year,String currentmonth,String currentlastmonth) {
        Map<String, Object> map =new HashMap<>();
        map.put("year",year);
        map.put("currentmonth",currentmonth);
        map.put("currentlastmonth",currentlastmonth);
        map.put("fid","B01");
        map.put("fid1","B01");
        map.put("fid2","011");
        map.put("fid3","060");
        List< Map<String, Object>>  list = baseMapper.wasteWaterDischargeForYear(map);
        DecimalFormat df = new java.text.DecimalFormat("#0.00");
        for(Map<String, Object> entity:list){
            double nb=Double.parseDouble(entity.get("couValue").toString());
            String str1="";
            if(nb>10000){
                nb=nb/10000;
                str1=df.format(nb)+'万';
            }else{
                str1=df.format(nb);
            }
            if(entity.get("fid").equals("B01")){
                map.put("B01",str1);
            }
            if(entity.get("fid").equals("011")){
                map.put("011",str1);
            }
            if(entity.get("fid").equals("060")){
                map.put("060",str1);
            }
        }
        List<OnlineMonitorDaydataEntity>  list1 =  baseMapper.wasteWaterDischarge(map);

        for(OnlineMonitorDaydataEntity entity1:list1){
            double num= Double.parseDouble(entity1.getCouValue());
            String str="";
            if(num>10000){
                 num=num/10000;
                 str=df.format(num)+'万';
            }else{
                 str=df.format(num);
            }
            if(entity1.getCreatedate().equals(currentmonth)){
                map.put("monthsum",str);
            }else{
                map.put("lastmonthsum",str);
            }
        }
        if(map.get("B01")==null){
            map.put("B01",0);
        }
        if(map.get("011")==null){
            map.put("011",0);
        }
        if(map.get("060")==null){
            map.put("060",0);
        }
        if(map.get("monthsum")==null){
            map.put("monthsum",0);
        }
        if(map.get("lastmonthsum")==null){
            map.put("lastmonthsum",0);
        }
        return map;
    }

    @Override
    public List<OnlineMonitorDaydataEntity> getDataFromRedis(Map<String, Object> params) {
        return null;
    }
    /**
     * 在线监控企业列表查询
     */
    @Override
    public PageUtils onlineMonitoringEnterpriseList(Map<String, Object> params) {
        Integer limit = Integer.parseInt((String)params.get("limit"));
        Integer page = Integer.parseInt((String)params.get("page"));
        Query query = new Query(params);
        List<CominfoBaseinfoEntity> list = baseMapper.onlineMonitoringEnterpriseList(query);
        for(CominfoBaseinfoEntity cominfoBaseinfo:list){
            if(cominfoBaseinfo.getIndustryids() != null && !cominfoBaseinfo.getIndustryids().equals("")){
                String industryidstemp=getIndustry(cominfoBaseinfo.getIndustryids());
                cominfoBaseinfo.setIndustry(industryidstemp);
            }
        }
        int count = baseMapper.onlineMonitoringEnterpriseListCount(params);
        return new PageUtils(list,count,limit,page);
    }
    /**
     * 获取行业列表跟字典表映射获得对应名称
     */
    @Override
    public String getIndustry(String code) {
        String[] industryids = code.split(",");
        String industryidstemp = "";
        for(String industryid : industryids){
            SysHangyedaimaEntity sysHangyedaima = sysHangyedaimaService.selectByMap(new MapUtils().put("DaiMaZhi",industryid)).get(0);
            if(sysHangyedaima != null){
                industryidstemp += sysHangyedaima.getMingcheng() + ",";
            }
        }
        if (industryidstemp.length() > 0 ){
            industryidstemp = industryidstemp.substring(0, industryidstemp.length() - 1);
        }
        return industryidstemp;
    }
}

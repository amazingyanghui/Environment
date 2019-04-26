package com.tengdi.environmentalprotectionint.modules.penalty.service.impl;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.MapUtils;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysDictService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

import com.tengdi.environmentalprotectionint.modules.penalty.dao.AdministrativePenaltyInfoDao;
import com.tengdi.environmentalprotectionint.modules.penalty.entity.AdministrativePenaltyInfoEntity;
import com.tengdi.environmentalprotectionint.modules.penalty.service.AdministrativePenaltyInfoService;


@Service("administrativePenaltyInfoService")
public class AdministrativePenaltyInfoServiceImpl extends ServiceImpl<AdministrativePenaltyInfoDao, AdministrativePenaltyInfoEntity> implements AdministrativePenaltyInfoService {

    @Autowired
    private SysDictService sysDictService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String administrativePenaltyInfoName = (String)params.get("administrativePenaltyInfoName");
        Page<AdministrativePenaltyInfoEntity> page = this.selectPage(
                new Query<AdministrativePenaltyInfoEntity>(params).getPage(),
                new EntityWrapper<AdministrativePenaltyInfoEntity>()
                        .like(StringUtils.isNotBlank(administrativePenaltyInfoName),"administrativePenaltyInfoName", administrativePenaltyInfoName)
        );

        return new PageUtils(page);
    }

    @Override
    public String insertData(AdministrativePenaltyInfoEntity entity) {
        int count=baseMapper.insertData(entity);
        return entity.getPid();
    }

    @Override
    public List<AdministrativePenaltyInfoEntity> queryName(Map<String, Object> params) {
        return baseMapper.queryName(params);
    }

    @Override
    public List<AdministrativePenaltyInfoEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

    @Override
    public AdministrativePenaltyInfoEntity entityById(String pid) {
        return baseMapper.entityById(pid);
    }

    @Override
    public List<AdministrativePenaltyInfoEntity> queryList(Map<String, Object> params) {
        List<AdministrativePenaltyInfoEntity> list=baseMapper.queryList2(params);
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
        List<AdministrativePenaltyInfoEntity> list = baseMapper.queryList2(query);
        int count = baseMapper.count(params);
        return new PageUtils(list,count,limit,page);
    }

    @Override
    public JSONArray staticcount(String year) {
        JSONArray jsonArr = new JSONArray();
        /*String cid=(String)params.get("year");*/
        List<AdministrativePenaltyInfoEntity> list=baseMapper.totalmoney(year);
        int cases = 0 ;
        int i = 0 ;
        int lastCases = 0 ;
        int monerys = 0 ;
        int addMonerys = 0 ;
        double result ;
        String lastYear="";
        //该年度案件总数
        cases = baseMapper.totalcases(year);
        //获取上一年度
         i = Integer.parseInt(year);
         lastYear = String.valueOf(i-1);
        //上一年度总案件
         lastCases = baseMapper.totalcases(lastYear);
        //该年度金额总数

        for(int j=0;j<list.size();j++){
            String publishmentResult = "" ;
            AdministrativePenaltyInfoEntity administrativePenaltyInfoEntity = list.get(j);
            if(administrativePenaltyInfoEntity.getPunishmentResult()!=null){
                 publishmentResult = administrativePenaltyInfoEntity.getPunishmentResult();
            }
            if(!("").equals(publishmentResult)){
               int rmbextis =  publishmentResult.indexOf("人民币");
               int yextis =  publishmentResult.indexOf("元整");
               if(rmbextis!=-1&&yextis!=-1){
//                   System.out.println(rmbextis+" 人民币位置 "+yextis+"元位置");
                  String  publishmony =   publishmentResult.substring((rmbextis+3),yextis);
//                   System.out.println(" 处罚人民币 "+publishmony);
                   monerys += Integer.parseInt(publishmony);

               }
            }


        }

        System.out.println(" 总金额 "+monerys);
        // monerys = baseMapper.totalmoney(year);
        //上一年度金额总数
        int lastMonerys = 0;

        List<AdministrativePenaltyInfoEntity> lastlist=baseMapper.totalmoney(lastYear);
        for(int k=0;k<lastlist.size();k++){
            String publishmentResult = "" ;
            AdministrativePenaltyInfoEntity administrativePenaltyInfoEntity = lastlist.get(k);
            if(administrativePenaltyInfoEntity.getPunishmentResult()!=null){
                publishmentResult = administrativePenaltyInfoEntity.getPunishmentResult();
            }
            if(!("").equals(publishmentResult)){

                int rmbextis =  publishmentResult.indexOf("人民币");
                int yextis =  publishmentResult.indexOf("元整");
                if(rmbextis!=-1&&yextis!=-1){
//                    System.out.println(rmbextis+" 人民币位置 "+yextis+"元位置");
                    String  publishmony =   publishmentResult.substring((rmbextis+3),yextis);
//                    System.out.println(" 处罚人民币 "+publishmony);
                    lastMonerys += Integer.parseInt(publishmony);

                }
            }


        }

        //年度增加金额
         addMonerys =  (monerys - lastMonerys) ;

        //年度增长率
       NumberFormat numberFormat = NumberFormat.getInstance(); // 创建一个数值格式化对象
        // 设置精确到小数点后2位
        if(lastMonerys==0){
            result= 0 ;
        }else{
           // result = numberFormat.format((double) addMonerys / (double) lastMonerys * 100);
            result = change((double)addMonerys /  lastMonerys * 100);
        }

        JSONObject jsonObj = new JSONObject();
            String cutcasescount = "cutcasescount",
            curmonerycount="curmonerycount" ,
            growthRate ="growthRate" ,
            changeMoneys = "changeMoneys";

        jsonObj.put(cutcasescount,cases);
        jsonObj.put(curmonerycount,change((double)monerys/10000));
        jsonObj.put(growthRate,result);
        jsonObj.put(changeMoneys,change((double)addMonerys/10000));

        jsonArr.add(jsonObj) ;
        return jsonArr;

    }


    @Override
    public JSONArray monthStatic(String year,String type){
        JSONArray jsonArr = new JSONArray();
        List<AdministrativePenaltyInfoEntity> list ;
        String month ="month",
                monthcases ="monthcases",
                monthmonery ="monthmonery";
        DecimalFormat df = new DecimalFormat("#0.00");


        if(type.equals("1")){
            for(int i = 0 ;i<12;i++){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("year",year);
                map.put("month",(i+1));
                list = baseMapper.monthmoneryList(map) ;
                JSONObject jsonObjTemp = new JSONObject();
                int monthmonery_ = 0 ;

                for(int k=0;k<list.size();k++){
                    String publishmentResult = "" ;
                    AdministrativePenaltyInfoEntity administrativePenaltyInfoEntity = list.get(k);
                    if(administrativePenaltyInfoEntity.getPunishmentResult()!=null){
                        publishmentResult = administrativePenaltyInfoEntity.getPunishmentResult();
                    }
                    if(!("").equals(publishmentResult)){

                        int rmbextis =  publishmentResult.indexOf("人民币");
                        int yextis =  publishmentResult.indexOf("元整");
                        if(rmbextis!=-1&&yextis!=-1){
//                            System.out.println(rmbextis+" 人民币位置 "+yextis+"元位置");
                            String  publishmony =   publishmentResult.substring((rmbextis+3),yextis);
//                            System.out.println(" 处罚人民币 "+publishmony);
                            monthmonery_ += Integer.parseInt(publishmony);

                        }
                    }

                }

                jsonObjTemp.put(month,(i+1));
                jsonObjTemp.put(monthmonery,change((double)monthmonery_/10000));
                jsonArr.add(jsonObjTemp);
            }

        }else{
            list = baseMapper.monthcacesList(year) ;
            JSONObject jsonObjTemp = new JSONObject();
            for(int i=0;i<list.size();i++){
                AdministrativePenaltyInfoEntity administrativePenaltyInfoEntity = list.get(i);
                if(administrativePenaltyInfoEntity.getMonth()!=null){
                    jsonObjTemp.put(month,Integer.parseInt((String)administrativePenaltyInfoEntity.getMonth()));
                }
                if(administrativePenaltyInfoEntity.getMonth()!=null){
                    jsonObjTemp.put(monthcases,Integer.parseInt((String)administrativePenaltyInfoEntity.getMonthcases()));
                }

                jsonArr.add(jsonObjTemp);
            }

        }



       return  jsonArr ;
    }
    @Override
    public JSONArray yearStatic(String year,String type){
        int cases = 0 ;
        int i = 0 ;
        int lastCases = 0 ;
        int monerys = 0 ;
        int addMonerys = 0 ;
        int  lastMonerys = 0;
        String result ="" ;
        String lastYear="";
        //该年度案件总数
        cases = baseMapper.totalcases(year);
        //获取上一年度
        i = Integer.parseInt(year);
        lastYear = String.valueOf(i-1);
        //上一年度总案件
        lastCases = baseMapper.totalcases(lastYear);
        //该年度金额总数
        List<AdministrativePenaltyInfoEntity> list=baseMapper.totalmoney(year);
        for(int j=0;j<list.size();j++){
            String publishmentResult = "" ;
            AdministrativePenaltyInfoEntity administrativePenaltyInfoEntity = list.get(j);
            if(administrativePenaltyInfoEntity.getPunishmentResult()!=null){
                publishmentResult = administrativePenaltyInfoEntity.getPunishmentResult();
            }
            if(!("").equals(publishmentResult)){

                int rmbextis =  publishmentResult.indexOf("人民币");
                int yextis =  publishmentResult.indexOf("元整");
                int fhextis = publishmentResult.indexOf("￥");
                int yzextis = publishmentResult.indexOf("元整)");
                String  publishmony = "" ;
                if(rmbextis!=-1&&yextis!=-1){
//                    System.out.println(rmbextis+" 人民币位置 "+yextis+"元位置");
                    if(fhextis==-1){
                        publishmony = publishmentResult.substring((rmbextis+3),yextis);
//                      System.out.println(" 处罚人民币 "+publishmony);
                        monerys += Integer.parseInt(publishmony);

                    }else {
                        if(fhextis<yextis){
                            publishmony = publishmentResult.substring((fhextis+1),yzextis);
                            monerys += Integer.parseInt(publishmony);
                        }else{
                            publishmony = publishmentResult.substring((fhextis+1),yextis);
                            monerys += Integer.parseInt(publishmony);
                        }

                    }

                }
            }


        }
        //上一年度金额总数
        List<AdministrativePenaltyInfoEntity> lastlist=baseMapper.totalmoney(lastYear);
        for(int k=0;k<lastlist.size();k++){
            String publishmentResult = "" ;
            AdministrativePenaltyInfoEntity administrativePenaltyInfoEntity = lastlist.get(k);
            if(administrativePenaltyInfoEntity.getPunishmentResult()!=null){
                publishmentResult = administrativePenaltyInfoEntity.getPunishmentResult();
            }

            System.out.println(" kk   "+k);
            if(!("").equals(publishmentResult)){
                String  publishmony = "" ;
                int rmbextis =  publishmentResult.indexOf("人民币");
                int yextis =  publishmentResult.indexOf("元整");
                int fhextis = publishmentResult.indexOf("￥");
                int yzextis = publishmentResult.indexOf("元整)");
                int yzextis_ = publishmentResult.indexOf("元整）");
                if(rmbextis!=-1&&yextis!=-1){
                    if(fhextis==-1){
                        publishmony = publishmentResult.substring((rmbextis+3),yextis);
//                      System.out.println(" 处罚人民币 "+publishmony);
                        lastMonerys += Integer.parseInt(publishmony);

                    }else {
                        if(fhextis<yextis){
                            if(fhextis!=-1&&yzextis!=-1){
                                publishmony = publishmentResult.substring((fhextis+1),yzextis);
                                lastMonerys += Integer.parseInt(publishmony);
                            }else{
                                if(yzextis_!=-1){
                                publishmony = publishmentResult.substring((fhextis+1),yzextis_);
                                    lastMonerys += Integer.parseInt(publishmony);
                                }
                            }

                        }else{
                            if(fhextis!=-1&&yextis!=-1){
                                if(fhextis<yextis){
                                    publishmony = publishmentResult.substring((fhextis+1),yextis);
                                    lastMonerys += Integer.parseInt(publishmony);
                                }
                            }
                            if(fhextis!=-1&&yzextis_!=-1){
                                if(fhextis<yzextis_){
                                    publishmony = publishmentResult.substring((fhextis+1),yzextis_);
                                    lastMonerys += Integer.parseInt(publishmony);
                                }
                            }

                        }

                    }
                }
            }


        }
        JSONArray jsonArr = new JSONArray();
//        List<AdministrativePenaltyInfoEntity> list ;
        String currentYearcount = "currentYearcount", //用于年度查询比较
                lastYearcount = "lastYearcount";

        if(type.equals("1")){
           // list = baseMapper.monthmoneryList(year) ;
            JSONObject jsonObjTemp = new JSONObject();

                jsonObjTemp.put(currentYearcount,change((double)monerys/10000));
                jsonObjTemp.put(lastYearcount,change((double)lastMonerys/10000));
                jsonArr.add(jsonObjTemp);


        }else{
           // list = baseMapper.monthmoneryList(year) ;
            JSONObject jsonObjTemp = new JSONObject();

            jsonObjTemp.put(currentYearcount,cases);
            jsonObjTemp.put(lastYearcount,lastCases);
            jsonArr.add(jsonObjTemp);

        }
        return  jsonArr ;
    }

    @Override
    public JSONArray typeStatic(String year,String type){
        JSONArray jsonArr = new JSONArray();
        int cases = 0;
        cases  = baseMapper.totalcases(year);
        int monerys = 0 ;
        int  undefinidIlltypeMoneys = 0 ;
        String DictType = "illegal_type_type";
        String illegalType = "name",
                typecount = "typecount",
                proportion = "y";
       // monerys =   baseMapper.totalmoney(year);
        NumberFormat numberFormat = NumberFormat.getInstance();
        List<AdministrativePenaltyInfoEntity> list = new ArrayList<AdministrativePenaltyInfoEntity>();
        if(("1").equals(type)){
            List<AdministrativePenaltyInfoEntity> list_=baseMapper.totalmoney(year);

            for(int j=0;j<list_.size();j++){
                String publishmentResult = "" ;
                AdministrativePenaltyInfoEntity administrativePenaltyInfoEntity = list_.get(j);


                if(administrativePenaltyInfoEntity.getPunishmentResult()!=null){
                    publishmentResult = administrativePenaltyInfoEntity.getPunishmentResult();
                }
                if(!("").equals(publishmentResult)){

                    int rmbextis =  publishmentResult.indexOf("人民币");
                    int yextis =  publishmentResult.indexOf("元整");
                    if(rmbextis!=-1&&yextis!=-1){
//                        System.out.println(rmbextis+" 人民币位置 "+yextis+"元位置");
                        String  publishmony =   publishmentResult.substring((rmbextis+3),yextis);
//                        System.out.println(" 处罚人民币 "+publishmony);
                        monerys += Integer.parseInt(publishmony);
                        if(administrativePenaltyInfoEntity.getIllegalType()==null){
                            undefinidIlltypeMoneys  += Integer.parseInt(publishmony); //未知类型数据总额
                        }

                    }
                }

                if(administrativePenaltyInfoEntity.getIllegalType()==null){
                    if(administrativePenaltyInfoEntity.getPunishmentResult()!=null){
                        publishmentResult = administrativePenaltyInfoEntity.getPunishmentResult();
                    }
                    if(!("").equals(publishmentResult)){

                        int rmbextis =  publishmentResult.indexOf("人民币");
                        int yextis =  publishmentResult.indexOf("元整");
                        if(rmbextis!=-1&&yextis!=-1){
//                        System.out.println(rmbextis+" 人民币位置 "+yextis+"元位置");
                            String  publishmony =   publishmentResult.substring((rmbextis+3),yextis);
//                        System.out.println(" 处罚人民币 "+publishmony);
                            monerys += Integer.parseInt(publishmony);

                        }
                    }

                }
            }
            JSONObject jsonObjundefinid = new JSONObject();
            String unpercents = "" ;
            if(undefinidIlltypeMoneys==0){
                unpercents="0";
            }else{
                unpercents = numberFormat.format((float)undefinidIlltypeMoneys/(float) monerys * 100);
            }
            jsonObjundefinid.put(illegalType,"未知类型"); //类型名称
            jsonObjundefinid.put(typecount,undefinidIlltypeMoneys);  //数量
            jsonObjundefinid.put(proportion,Double.parseDouble(unpercents)); //比例
            jsonArr.add(jsonObjundefinid);
            //已知类型
            List<SysDictEntity> dictList = sysDictService.selectByMap(new MapUtils().put("type",DictType));
                for (int m = 0;m<dictList.size();m++) {
                    SysDictEntity sysDictEntity = dictList.get(m);
                    JSONObject jsonObjTemp = new JSONObject();
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("year",year);
                    map.put("illtype",sysDictEntity.getKey());
                    List<AdministrativePenaltyInfoEntity> type_list=baseMapper.typemonerycountstatic(map);
                    int typecounts = 0;
                    String percents = "" ;
                    for(int j=0;j<type_list.size();j++){
                        String publishmentResult = "" ;
                        AdministrativePenaltyInfoEntity administrativePenaltyInfoEntity = type_list.get(j);
                        if(administrativePenaltyInfoEntity.getPunishmentResult()!=null){
                            publishmentResult = administrativePenaltyInfoEntity.getPunishmentResult();
                        }
                        if(!("").equals(publishmentResult)){
                            //publishmentResult.split("人民币")
                            int rmbextis =  publishmentResult.indexOf("人民币");
                            int yextis =  publishmentResult.indexOf("元整");
                            if(rmbextis!=-1&&yextis!=-1){
                                String  publishmony =   publishmentResult.substring((rmbextis+3),yextis);
                                System.out.println("类型  "+sysDictEntity.getValue()+"    typecounts "+typecounts);
                                typecounts += Integer.parseInt(publishmony);

                            }
                        }

                    }
                    if(typecounts==0){
                      percents="0";
                    }else{
                      percents = numberFormat.format((float)typecounts/(float) monerys * 100);
                    }
                    //百分比 名称 放入jsonobject中
                    jsonObjTemp.put(illegalType,sysDictEntity.getValue()); //类型名称
                    jsonObjTemp.put(typecount,change((double)typecounts/10000));  //金额
                    jsonObjTemp.put(proportion,Double.parseDouble(percents)); //比例
                    jsonArr.add(jsonObjTemp);
                }

        }else {
            list = baseMapper.typecasecountstatic(year);
            String percents = "" ;
            String illegeTypeName = "";
            for(int i=0;i<list.size();i++){
                JSONObject jsonObjTemp = new JSONObject();
                AdministrativePenaltyInfoEntity administrativePenaltyInfoEntity = list.get(i);
                if(type.equals("1")){
                    if(monerys==0){
                        percents="0";
                    }else{
                        if(administrativePenaltyInfoEntity.getTypecounts()!=null){
                            percents = numberFormat.format((float) Integer.parseInt(administrativePenaltyInfoEntity.getTypecounts()) / (float) cases * 100);
                        }
                    }
                    jsonObjTemp.put(proportion,Double.parseDouble(percents));
                    if(administrativePenaltyInfoEntity.getTypecounts()!=null){
                        jsonObjTemp.put(typecount,Integer.parseInt(administrativePenaltyInfoEntity.getTypecounts()) );
                    }

                }else {
                    if(cases==0){
                        percents="0";
                    }else {

                        if(administrativePenaltyInfoEntity.getTypecounts()!=null){
                            percents = numberFormat.format((float) Integer.parseInt(administrativePenaltyInfoEntity.getTypecounts()) / (float) cases * 100);
                        }

                    }

                    jsonObjTemp.put(proportion,Double.parseDouble(percents));

                    // jsonObjTemp.put(proportion,Double.parseDouble(percents));

                    if(administrativePenaltyInfoEntity.getTypecounts()!=null){
                        jsonObjTemp.put(typecount,Integer.parseInt(administrativePenaltyInfoEntity.getTypecounts()) );
                    }

                }
                List<SysDictEntity> dictList = sysDictService.selectByMap(new MapUtils().put("type",DictType));
                if (administrativePenaltyInfoEntity.getIllegalType() != null) {
                    for (SysDictEntity record : dictList) {
                        if (administrativePenaltyInfoEntity.getIllegalType() != null) {
                            if (Integer.parseInt(administrativePenaltyInfoEntity.getIllegalType()) == record.getKey()) {
                                illegeTypeName = record.getValue();
                            }
                        }

                    }
                }else{
                    illegeTypeName = "未知类型";
                }
                jsonObjTemp.put(illegalType,illegeTypeName);

                jsonArr.add(jsonObjTemp);

            }
        }

        JSONArray sortJsonarr=new JSONArray();
        List<JSONObject> jsonValue=new ArrayList<JSONObject>();
        for(int l=0;l<jsonArr.size();l++){
            jsonValue.add(jsonArr.getJSONObject(l));
        }
        Collections.sort(jsonValue,new Comparator<JSONObject>() {
            // private static final String key="city";
            private static final String key="typecount";
            public int compare(JSONObject a, JSONObject b) {
                // String valA=a.getString(key);
                // String valB=b.getString(key);
                Integer valA=a.getInt(key);
                Integer valB=b.getInt(key);
                return valB.compareTo(valA);
            }
        });
        for(int x=0;x<jsonValue.size();x++){
            sortJsonarr.add(jsonValue.get(x));
        }
        return sortJsonarr ;
    };

    @Override
    public JSONArray companyRankStatic(String year,String type){
        JSONArray jsonArr = new JSONArray();
        List<AdministrativePenaltyInfoEntity> list ;
        List<AdministrativePenaltyInfoEntity> list_ ;
        if(type.equals("1")){
            list_ = baseMapper.caseranking(year);//获取企业cid集合
            for(int j =0 ; j<list_.size();j++){
                String cid = "" ;
                int companymoney = 0 ;
                JSONObject jsonObj = new JSONObject();
                String punishedCompanyName = "punishedCompanyName",
                        companyrankcount = "companyrankcount";
                Map<String, Object> map = new HashMap<String, Object>();
                AdministrativePenaltyInfoEntity administrativePenaltyInfoEntity_ = list_.get(j);
                cid =  administrativePenaltyInfoEntity_.getCid() ;
                map.put("year",year);
                map.put("cid",cid);
                list =  baseMapper.moneryranking(map);
                for(int m=0;m<list.size();m++){
                    String publishmentResult = "" ;
                    AdministrativePenaltyInfoEntity administrativePenaltyInfoEntity= list.get(m);
                    if(administrativePenaltyInfoEntity.getPunishmentResult()!=null){
                        publishmentResult = administrativePenaltyInfoEntity.getPunishmentResult();
                    }
                    if(!("").equals(publishmentResult)){
                        int rmbextis =  publishmentResult.indexOf("人民币");
                        int yextis =  publishmentResult.indexOf("元整");
                        if(rmbextis!=-1&&yextis!=-1){
                            String  publishmony =   publishmentResult.substring((rmbextis+3),yextis);
                            companymoney += Integer.parseInt(publishmony);

                        }
                    }

                }
                jsonObj.put(punishedCompanyName,administrativePenaltyInfoEntity_.getPunishedCompanyName());
                jsonObj.put(companyrankcount,change((double)companymoney/10000));

                jsonArr.add(jsonObj);
            }
        }else{
            list_ = baseMapper.caseranking(year);
            for(int i=0;i<list_.size();i++){
                AdministrativePenaltyInfoEntity administrativePenaltyInfoEntity = list_.get(i);
                JSONObject jsonObj = new JSONObject();
                String punishedCompanyName = "punishedCompanyName",
                        companyrankcount = "companyrankcount";
                if(administrativePenaltyInfoEntity.getPunishedCompanyName()!=null){
                    jsonObj.put(punishedCompanyName,administrativePenaltyInfoEntity.getPunishedCompanyName());
                }else{
                    jsonObj.put(punishedCompanyName,"未知企业");
                }
                if(administrativePenaltyInfoEntity.getCompanyrankcount()!=null){
                    jsonObj.put(companyrankcount,Integer.parseInt(administrativePenaltyInfoEntity.getCompanyrankcount()));
                }
                jsonArr.add(jsonObj);
            }
        }
        JSONArray sortJsonarr=new JSONArray();
        List<JSONObject> jsonValue=new ArrayList<JSONObject>();
        for(int l=0;l<jsonArr.size();l++){
            jsonValue.add(jsonArr.getJSONObject(l));
        }
        Collections.sort(jsonValue,new Comparator<JSONObject>() {
            // private static final String key="city";
            private static final String key="companyrankcount";
            public int compare(JSONObject a, JSONObject b) {
                // String valA=a.getString(key);
                // String valB=b.getString(key);
                Integer valA=a.getInt(key);
                Integer valB=b.getInt(key);
                return valB.compareTo(valA);
            }
        });
        for(int x=0;x<jsonValue.size();x++){
            sortJsonarr.add(jsonValue.get(x));
        }
        return  sortJsonarr ;
    }


    public double change(double num) {
        BigDecimal bg = new BigDecimal(num);
        double changedNum = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(changedNum);
        return changedNum ;
    }
}



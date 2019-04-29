package com.tengdi.environmentalprotectionint.modules.mobile.service.impl;

import com.tengdi.environmentalprotectionint.modules.building.dao.BuildingProjectApprovalDao;
import com.tengdi.environmentalprotectionint.modules.building.service.BuildingProjectApprovalService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.SysHangyedaimaEntity;
import com.tengdi.environmentalprotectionint.modules.common.service.ExportExcelService;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorDaydataService;
import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.MapUtils;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysDictService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;
import com.tengdi.environmentalprotectionint.modules.mobile.dao.MobileEnforcementSceneDao;
import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementSceneEntity;
import com.tengdi.environmentalprotectionint.modules.mobile.service.MobileEnforcementSceneService;


@Service("mobileEnforcementSceneService")
public class MobileEnforcementSceneServiceImpl extends ServiceImpl<MobileEnforcementSceneDao, MobileEnforcementSceneEntity> implements MobileEnforcementSceneService {
    @Autowired
    private SysDictService sysDictService;
    @Autowired
    private OnlineMonitorDaydataService onlineMonitorDaydataService;
    @Autowired
    private ExportExcelService exportExcelService;
    @Autowired(required = false)
    private BuildingProjectApprovalDao buildingProjectApprovalDao;
    @Autowired
    private BuildingProjectApprovalService buildingProjectApprovalService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String mobileEnforcementSceneName = (String)params.get("mobileEnforcementSceneName");
        Page<MobileEnforcementSceneEntity> page = this.selectPage(
                new Query<MobileEnforcementSceneEntity>(params).getPage(),
                new EntityWrapper<MobileEnforcementSceneEntity>()
                        .like(StringUtils.isNotBlank(mobileEnforcementSceneName),"mobileEnforcementSceneName", mobileEnforcementSceneName)
        );

        return new PageUtils(page);
    }
    @Override
    public List<MobileEnforcementSceneEntity> queryList(Map<String, Object> params) {
        List<MobileEnforcementSceneEntity> list=baseMapper.mobilelist(params);
        list=getList(list);
        return list;
    }

    @Override
    public List<MobileEnforcementSceneEntity> queryName(Map<String, Object> params) {
        List<MobileEnforcementSceneEntity> list =baseMapper.queryName(params);
        list=getList(list);
        return list;
    }

    @Override
    public List<MobileEnforcementSceneEntity> dataById(String cid) {
        List<MobileEnforcementSceneEntity> list =baseMapper.dataById(cid);
        list=getList(list);
        return list;
    }

    @Override
    public String insertData(MobileEnforcementSceneEntity entity) {
        int count=baseMapper.insertData(entity);
        return entity.getPid();
    }

    @Override
    public MobileEnforcementSceneEntity entityById(String pid) {
        return baseMapper.entityById(pid);
    }

    @Override
    public List<MobileEnforcementSceneEntity> getList(List<MobileEnforcementSceneEntity> list) {
        if(list.size()>0){
            for(MobileEnforcementSceneEntity enforcementSceneEntity:list){
                if(enforcementSceneEntity!=null){
                    if(enforcementSceneEntity.getLawEnforcementType()!=null){
                        String str=exportExcelService.getLawEnforcementType(enforcementSceneEntity.getLawEnforcementType());
                        enforcementSceneEntity.setLawEnforcementTypeName(str);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public PageUtils mobilelist(Map<String, Object> params) {
        int page =Integer.parseInt((String)params.get("page"));
        int limit =Integer.parseInt((String)params.get("limit"));
        Query query = new Query(params);
        List<MobileEnforcementSceneEntity> list =baseMapper.mobilelist(query);
        list=getList(list);
        int totalCount =baseMapper.mobilelistsum(params);
        return new PageUtils(list,totalCount,limit,page);

    }
    /**
     * 移动执法统计：该年累计值法人次、执法人员总数、发现问题总数、相比去年执法总数增加百分比
     */
    @Override
    public Map<String, Object> comprehensiveStatistical(Map<String, Object> map ) {
        List<Map<String,Object>>  list=baseMapper.comprehensiveStatistical(map);
        DecimalFormat df = new java.text.DecimalFormat("#0.00");
        for(Map<String,Object> map2:list){
            map.put("LawEnforcementNumber",map2.get("LawEnforcementNumber"));
            map.put("LawEnforcementPersonnel",map2.get("LawEnforcementPersonnel"));
            map.put("FoundTheProblem",map2.get("FoundTheProblem"));
            double yearSum=Double.parseDouble(map2.get("yearSum").toString()) ;
            double lastyearSum=Double.parseDouble(map2.get("lastyearSum").toString()) ;
            // 增长率=增量/原总量*100%
            double test=0;
            if(yearSum==0){
                map.put("growth",0);
            }else{
                if(yearSum < lastyearSum){
                    map.put("growth",0);
                }else{
                    test=((yearSum-lastyearSum)/lastyearSum)*100;
                    map.put("growth",df.format(test));
                }
            }
        }
        return map;
    }
    /**
     * 移动执法图表统计:月执法统计
     */
    @Override
    public int [] statistical(Map<String, Object> map) {
        int [] monthContainer=new int [12];
        List<Map<String,Object>> list=baseMapper.statistical(map);
        for(int i=0;i<list.size();i++){
            Map<String,Object>map2= list.get(i);
            int counts=Integer.parseInt(map2.get("counts").toString());
            int months=Integer.parseInt(map2.get("months").toString());
            int mount=months-1;
            monthContainer[mount]=counts;
        }
        return monthContainer;
    }
    /**
     * 移动执法统计：去年执法次数与今年对比
     */
    @Override
    public  int []   statisticalLastyearAndThisyear(Map<String, Object> map) {
        List<Map<String, Object>>  list =baseMapper.statisticalLastyearAndThisyear(map);
        int [] contrast=new int [2];
        for(int i=0;i<list.size();i++){
            Map<String, Object>map2= list.get(i);
            int counts=Integer.parseInt(map2.get("counts").toString());
            int years=Integer.parseInt(map2.get("years").toString());
            int x=Integer.parseInt((String)map.get("year"));
            if(years==Integer.parseInt((String)map.get("year"))){
                contrast[0]=counts;
            }else{
                contrast[1]=counts;
            }
        }
        return contrast;
    }
    /**
     * 移动执法统计：检查结果
     */
    @Override
    public JSONArray checkTheResultStatistical(Map<String, Object> map) {
        map.put("checkDictType","examination_results_type");
        List<Map<String, Object>>  list =baseMapper.checkTheResultStatistical(map);
        String key1 = "name", key2 = "y";
        JSONArray jsonArr = new JSONArray();
        for(int i=0;i<list.size();i++){
            Map<String, Object> entity=list.get(i);
            JSONObject jsonObjTemp = new JSONObject();
            jsonObjTemp.put(key1,entity.get("name"));
            jsonObjTemp.put(key2,entity.get("counts"));
            jsonArr.add(jsonObjTemp);
        }
        return jsonArr;
    }
    /**
     * 移动执法统计：问题类型
     */
    @Override
    public JSONArray  statisticalProblemType(Map<String, Object> map) {
        map.put("questionDictType","mobileEnforcement_problemType");
        List<Map<String, Object>>  list =baseMapper.statisticalProblemType(map);
        List<SysDictEntity> dictEntity=sysDictService.selectByMap(new MapUtils().put("type",map.get("questionDictType")));
        List<Map<String,Object>> list1=new ArrayList<>();
        double sum=0;
        double [] problemType=new double [5];
        String [] problemname=new String[5];

        for(int i=0;i<list.size();i++){
            Map<String,Object> map1=list.get(i);
            String type= map1.get("type").toString();
            Map<String,Object>map2 =new HashMap<>();
            if(type.contains(",")){
                String [] codes=type.split(",");
                for(String codests:codes){
                    for(int e=0;e<dictEntity.size();e++){
                        SysDictEntity sysDictEntity=dictEntity.get(e);
                        if(codests.equals(sysDictEntity.getKey().toString())){
                            map2.put("type",codests);
                            map2.put("name",sysDictEntity.getValue());
                            list1.add(map2);
                            sum+=1;
                        }
                    }
                }
            }else{
                sum+=1;
                list1.add(map1);
            }
        }
        if(sum==0){
            JSONArray jsonArr1 = new JSONArray();
            return jsonArr1;
        }
        for(int q=0;q<list1.size();q++){
            Map<String,Object> map3=list1.get(q);
            int key=Integer.parseInt((String)map3.get("type"));
            switch (key) {
                case 1:
                    problemType[0]+=1;
                    problemname[0]=(String)map3.get("name");
                    break;
                case 2:
                    problemType[1]+=1;
                    problemname[1]=(String)map3.get("name");
                    break;
                case 3:
                    problemType[2]+=1;
                    problemname[2]=(String)map3.get("name");
                    break;
                case 4:
                    problemType[3]+=1;
                    problemname[3]=(String)map3.get("name");
                    break;
                case 5:
                    problemType[4]+=1;
                    problemname[4]=(String)map3.get("name");
                    break;
            }
        }
        for(int r=0;r<problemType.length;r++){
            if(problemType[r]==0){
                for(int t=0;t<dictEntity.size();t++){
                    SysDictEntity dictEntity1= dictEntity.get(r);
                    if(dictEntity1.getKey()==(r+1)){
                        problemname[r]=dictEntity1.getValue();
                        break;
                    }
                }
            }
        }
        String key1 = "name", key2 = "y",key3="proportion";
        JSONArray jsonArr = new JSONArray();
        for(int w=0;w<problemType.length;w++){
            JSONObject jsonObjTemp = new JSONObject();
            jsonObjTemp.put(key1,problemname[w]);
            jsonObjTemp.put(key2,problemType[w]);
            double z=(problemType[w]/sum)*100;
            DecimalFormat df = new java.text.DecimalFormat("#0.0");
            String  proportion=df.format(z);
            double count =Double.parseDouble(proportion);
            jsonObjTemp.put(key3,count);
            jsonArr.add(jsonObjTemp);
        }
        JSONArray sortJsonarr=storByJSONArrayToJSONObject(jsonArr);
        return sortJsonarr;
    }
    /**
     * 移动执法统计：本年度执法类型统计
     */
    @Override
        public JSONArray lawEnforcementTypeStatistical(Map<String, Object> map) {
        map.put("lawDictType","law_enforcement_type_type");
        List<Map<String, Object>>  list =baseMapper.lawEnforcementTypeStatistical(map);
        String key1 = "name", key2 = "y",key3="proportion";
        JSONArray jsonArr = new JSONArray();
        for(int i=0;i<list.size();i++){
            Map<String, Object> entity=list.get(i);
            JSONObject jsonObjTemp = new JSONObject();
            jsonObjTemp.put(key1,entity.get("name"));
            jsonObjTemp.put(key2,entity.get("counts"));
            double no=Double.parseDouble(entity.get("counts").toString());
            double sumno=Double.parseDouble(entity.get("sumNumber").toString());
            double z=(no/sumno)*100;
            DecimalFormat df = new DecimalFormat("#0.0");
            String  proportion=df.format(z);
            jsonObjTemp.put(key3,proportion);
            jsonArr.add(jsonObjTemp);
        }
        return jsonArr;
    }

    /**
     * 企业统计-企业所属行业类型统计
     * @return
     */
    @Override
    public  Map<String,Object>  industryidStatic1() {
        //获取所有企业
        List<CominfoBaseinfoEntity> list= baseMapper.selAllCominfoBaseinfo();
        List<Map<String,Object>> list1=new ArrayList<>();
        String strName="企业数量";
        int qita=0;
        //整合数据
        for(int i=0;i<list.size();i++){
            CominfoBaseinfoEntity entrty=list.get(i);
            String code=entrty.getIndustryids();
            Map<String,Object>map =new HashMap<>();
            if(code!=null){
                if(code.contains(",")){
                    String [] codes=code.split(",");
                    for(String codests:codes){
                        map.put("industryids",codests);
                        map.put("companyName",entrty.getCompanyName());
                        list1.add(map);
                    }
                }else{
                    map.put("industryids",code);
                    map.put("companyName",entrty.getCompanyName());
                    list1.add(map);
                }
            }else{
                qita+=1;
            }
        }
        JSONArray jsonArr = new JSONArray();
        JSONArray jsonArr2= new JSONArray();
        List<SysHangyedaimaEntity> countlist=buildingProjectApprovalDao.selAllHangYe();
        JSONArray hangYeAll= buildingProjectApprovalService.getJsonArray(countlist,1);
//        int []onesum=new int [4];
        //查出所有父级行业
//        List<SysHangyedaimaEntity> parentIndustryList= buildingProjectApprovalDao.selParentIndustry();
        for(int k=0;k<hangYeAll.size();k++) {
            JSONObject entity1=hangYeAll.getJSONObject(k);
            int  fulei=0;
            String fuleiname=(String) entity1.get("name");
            for(int g=0;g<list1.size();g++){
                Map<String, Object> map=list1.get(g);
                String industryids1=(String)map.get("industryids");
                if(industryids1.equals(entity1.get("daimazhi"))){
                    fulei+=1;
                }
            }
            JSONArray erJiHangYe=(JSONArray)entity1.get("children");
//            int key=entity1.getHangbiaoshi();
            //第二层data数据
            JSONArray jsonArr11 = new JSONArray();
            //获取当父级目录的二级目录列表
//            List<SysHangyedaimaEntity> sublevelIndustriesList=buildingProjectApprovalDao.selSublevelIndustries(key);
            int [] zilei1=new int[erJiHangYe.size()];
            String [] zileiname1=new String [erJiHangYe.size()];
            int count2=0;
            for(int q=0;q<erJiHangYe.size();q++){
                JSONObject sysHangyedaimaEntitysdf=erJiHangYe.getJSONObject(q);
                for(int w=0;w<list1.size();w++){
                    Map<String, Object> map1=list1.get(w);
                    String industryids1=(String)map1.get("industryids");
                    if(industryids1.equals(sysHangyedaimaEntitysdf.get("daimazhi"))){
                        zilei1[q]+=1;
                    }
                }
                zileiname1[q]=(String)sysHangyedaimaEntitysdf.get("name");
                JSONArray sanJiHangYe=(JSONArray)sysHangyedaimaEntitysdf.get("children");
//                int key2=sysHangyedaimaEntitysdf.getHangbiaoshi();
                //第三层data数据
                JSONArray jsonArr21 = new JSONArray();
                //获取三级目录
//                List<SysHangyedaimaEntity> sublevelIndustriesList2=buildingProjectApprovalDao.selSublevelIndustries(key2);
                int [] zilei2=new int[sanJiHangYe.size()];
                String [] zileiname2=new String [sanJiHangYe.size()];
                int count3=0;
                //第四曾数据总数
               for(int s=0;s<sanJiHangYe.size();s++){
                   JSONObject sysHangyedaimaEntitysdf2=sanJiHangYe.getJSONObject(s);
                   for(int a=0;a<list1.size();a++){
                       Map<String, Object> map2=list1.get(a);
                       String industryids2=(String)map2.get("industryids");
                       if(industryids2.equals(sysHangyedaimaEntitysdf2.get("daimazhi"))){
                           zilei2[s]+=1;
                       }
                   }
                   zileiname2[s]=(String)sysHangyedaimaEntitysdf2.get("name");
                   JSONArray siJiHangYe=(JSONArray)sysHangyedaimaEntitysdf2.get("children");
//                   int key3=sysHangyedaimaEntitysdf2.getHangbiaoshi();
                   int count4 =0;
                   //获取四级目录
//                   List<SysHangyedaimaEntity> sublevelIndustriesList3=buildingProjectApprovalDao.selSublevelIndustries(key3);
                   int [] zilei3=new int[siJiHangYe.size()];
                   String [] zileiname3=new String [siJiHangYe.size()];
                   for(int d=0;d<siJiHangYe.size();d++){
                       JSONObject sysHangyedaimaEntitysdf3=siJiHangYe.getJSONObject(d);
                       for(int f=0;f<list1.size();f++){
                           Map<String, Object> map3=list1.get(f);
                           String industryids3=(String)map3.get("industryids");
                           if(industryids3.equals(sysHangyedaimaEntitysdf3.get("daimazhi"))){
                               zilei3[d]+=1;
                           }
                       }
                       zileiname3[d]=(String)sysHangyedaimaEntitysdf3.get("name");
                   }
                   List listi5=new ArrayList();
                   List lists5=new ArrayList();
                   if(zilei3.length>0){
                       for(int y=0;y<zilei3.length;y++){
                           if(zilei3[y]>0){
                               listi5.add(zilei3[y]);
                               lists5.add(zileiname3[y]);
                           }
                       }
                   }
                   if(zilei2[s]>0){
                       listi5.add(zilei2[s]);
                       lists5.add(zileiname2[s]);
                   }
                   Integer [] zileis3=(Integer[])listi5.toArray(new Integer[0]);
                   String [] zileinames3=(String[])lists5.toArray(new String[0]);

                   for(int e=0;e<zileis3.length;e++){
                       count4+=zileis3[e];
                   }
                   JSONArray jsonArr31 = new JSONArray();
                   if(count4>0){
                       //循环拼四级数据（分）
                       for(int g=0;g<zileis3.length;g++){
                           JSONObject jsonObjTemp1 = new JSONObject();
                           String key31 = "name", key32 = "y";
                           jsonObjTemp1.put(key31,zileinames3[g]);
                           jsonObjTemp1.put(key32,zileis3[g]);
                           jsonArr31.add(jsonObjTemp1);
                       }
                   }else{
                       continue;
                   }
                   //循环拼四级数据（总）
                   String key33 = "id", key34 = "data",key35="name";
                   JSONObject jsonObjTemp1 = new JSONObject();
                   jsonObjTemp1.put(key33,zileiname2[s]);
                   jsonObjTemp1.put(key35,zileiname2[s]+strName);
                   jsonObjTemp1.put(key34,jsonArr31);
                   jsonArr.add(jsonObjTemp1);
                   //循环拼第三层数据data
                   String key221 = "name", key222 = "y", key223 = "drilldown";
                   JSONObject jsonObjTemp21 = new JSONObject();
                   jsonObjTemp21.put(key221,zileiname2[s]);
                   jsonObjTemp21.put(key222,count4);
                   count3+=count4;
                   jsonObjTemp21.put(key223,zileiname2[s]);
                   jsonArr21.add(jsonObjTemp21);
               }
                if(zilei1[q]>0){
                    String key21 = "name", key22 = "y";
                    JSONObject jsonObjTemp22 = new JSONObject();
                    jsonObjTemp22.put(key21,zileiname1[q]);
                    jsonObjTemp22.put(key22,zilei1[q]);
                    jsonArr21.add(jsonObjTemp22);
                }
                int dasfs=count3+zilei1[q];
                if(dasfs>0){
                    //循环拼第三层数据
                    JSONObject jsonObjTemp1 = new JSONObject();
                    if(jsonArr21.size()>0){
                        String key24 = "id", key25 = "data",key29="name";
                        jsonObjTemp1.put(key24,zileiname1[q]);
                        jsonObjTemp1.put(key29,zileiname1[q]+strName);
                        jsonObjTemp1.put(key25,jsonArr21);
                        jsonArr.add(jsonObjTemp1);
                    }
                    //拼第二层data
                    String key26 = "name", key27 = "y", key28 = "drilldown";
                    JSONObject jsonObjTemp22 = new JSONObject();
                    jsonObjTemp22.put(key26,zileiname1[q]);
                    jsonObjTemp22.put(key27,zilei1[q]+count3);
                    int x=zilei1[q]+count3;
                    count2+=x;
                    jsonObjTemp22.put(key28,zileiname1[q]);
                    jsonArr11.add(jsonObjTemp22);
                }
            }
            if(fulei>0){
                String key21 = "name", key22 = "y";
                JSONObject jsonObjTemp11 = new JSONObject();
                jsonObjTemp11.put(key21,fuleiname);
                jsonObjTemp11.put(key22,fulei);
                jsonArr11.add(jsonObjTemp11);
            }
            //循环拼第二层数据
            String key1 = "id", key2 = "data",key3="name";
            JSONObject jsonObjTemp1 = new JSONObject();
            jsonObjTemp1.put(key1,fuleiname);
            jsonObjTemp1.put(key3,fuleiname+strName);
            jsonObjTemp1.put(key2,jsonArr11);
            jsonArr.add(jsonObjTemp1);
             //拼父级数据
            String key6 = "name", key7 = "y", key8 = "drilldown";
            JSONObject jsonObjTemp2 = new JSONObject();
            jsonObjTemp2.put(key6,fuleiname);
            jsonObjTemp2.put(key7,fulei+count2);
            jsonObjTemp2.put(key8,fuleiname);
            jsonArr2.add(jsonObjTemp2);

        }
        JSONObject jsonObjTemp3 = new JSONObject();
        jsonObjTemp3.put("name","其他");
        jsonObjTemp3.put("y",qita);
        jsonArr2.add(jsonObjTemp3);

        Map<String,Object> map2=new HashMap<>();
        map2.put("jsonArr",jsonArr);
        map2.put("jsonArr2",jsonArr2);

        return map2;
    }
    /**
     * 按照JSONArray中JSONObject的某一属性进行排序
     */
    @Override
    public JSONArray storByJSONArrayToJSONObject(JSONArray arr) {
        JSONArray sortJsonarr3=new JSONArray();
        List<JSONObject> jsonValue3=new ArrayList<JSONObject>();
        for(int i=0;i<arr.size();i++){
            jsonValue3.add(arr.getJSONObject(i));
        }
        Collections.sort(jsonValue3,new Comparator<JSONObject>() {
            private static final String key="y";
            public int compare(JSONObject a, JSONObject b) {
                // String valA=a.getString(key);
                // String valB=b.getString(key);
                //Integer valA=a.getIntValue(key);
                //Integer valB=b.getIntValue(key);
                Integer valA=a.getInt(key);
                Integer valB=b.getInt(key);
                return valA.compareTo(valB);
            }
        });
        for(int i=0;i<arr.size();i++){
            sortJsonarr3.add(jsonValue3.get(i));
        }
        return sortJsonarr3;
    }
    /**
     * 按照List中的某一属性进行排序
     */
    @Override
    public List<SysDictEntity> storByList(List dicts) {
        Collections.sort(dicts,new Comparator<SysDictEntity>() {
            private static final String key="y";
            public int compare(SysDictEntity a, SysDictEntity b) {
                return a.getValue().compareTo(b.getValue());
            }
        });
        Collections.reverse(dicts);
        return dicts;
    }

    /**
     *  环保执法监察
     * 根据类型（全部、本年、本月）查询移动执法-现场执法和调查问卷的次数
     * 执法次数、执法人数、发现违法行为数、立案数
     * @param type
     * @return
     */
    @Override
    public Map<String,Object> environmentalLawEnforcementMonitoring(String type) {
        Map<String,Object> map=new HashMap<>();
        if(type.equals("1")){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            String year=sdf.format(DateUtils.getDate());
            map.put("year",year);
        }else if(type.equals("2")){
            SimpleDateFormat sdf = new SimpleDateFormat("MM");
            String month=sdf.format(DateUtils.getDate());
            map.put("month",month);
        }
        //根据类型（全部、本年、本月）查询移动执法-现场执法和调查问卷的次数\执法次数、执法人数、发现违法行为数、立案数
        //获取现场执法次数
        Map<String,Object> map2=baseMapper.environmentalLawEnforcementMonitoring(map);
        long  interrogationRecord= Long.parseLong(map2.get("interrogationRecord").toString());
        long  onSiteInspection= Long.parseLong(map2.get("onSiteInspection").toString());
        long  LawEnforcementPersonnel= Long.parseLong(map2.get("LawEnforcementPersonnel").toString());
        long  FoundTheProblem= Long.parseLong(map2.get("FoundTheProblem").toString());
        long  putOnRecord= Long.parseLong(map2.get("putOnRecord").toString());
        //图表需要用现场执法和调查问卷的次数
        Map<String,Object> map3=new HashMap<>();
        JSONArray jsonArr1 = new JSONArray();
        jsonArr1.add("询问笔录");
        jsonArr1.add(interrogationRecord);
        JSONArray jsonArr2 = new JSONArray();
        jsonArr2.add("现场检查");
        jsonArr2.add(onSiteInspection);
        JSONArray jsonArr = new JSONArray();
        jsonArr.add(jsonArr1);
        jsonArr.add(jsonArr2);
        map3.put("data",jsonArr);
        //现场执法、调查问卷的次数、执法次数、执法人数、发现违法行为数、立案数
        long sum=interrogationRecord+onSiteInspection;
        map3.put("interrogationRecord",interrogationRecord);//现场执法
        map3.put("onSiteInspection",onSiteInspection);//调查问卷的次数
        map3.put("numberOfLawEnforcement",sum);//执法次数
        map3.put("LawEnforcementPersonnel",LawEnforcementPersonnel);//执法人数
        map3.put("FoundTheProblem",FoundTheProblem);//执法人数
        map3.put("putOnRecord",putOnRecord);//立案数
        return map3;
    }

    /**
     * 移动执法页头弹框列表查询接口
     */
    @Override
    public PageUtils playListBox(Map<String, Object> params) {
        int page =Integer.parseInt((String)params.get("page"));
        int limit =Integer.parseInt((String)params.get("limit"));
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
        List<MobileEnforcementSceneEntity> list=baseMapper.playListBox(query);
        list=getList(list);
        int totalCount =baseMapper.playListBoxsum(params);
        return new PageUtils(list,totalCount,limit,page);
    }
}

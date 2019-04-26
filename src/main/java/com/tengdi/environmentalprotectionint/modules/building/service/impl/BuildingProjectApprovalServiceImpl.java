package com.tengdi.environmentalprotectionint.modules.building.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.SysHangyedaimaEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorDaydataService;
import com.tengdi.userauthenuuid.modules.sys.service.SysDictService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;
import com.tengdi.environmentalprotectionint.modules.building.dao.BuildingProjectApprovalDao;
import com.tengdi.environmentalprotectionint.modules.building.entity.BuildingProjectApprovalEntity;
import com.tengdi.environmentalprotectionint.modules.building.service.BuildingProjectApprovalService;


@Service("buildingProjectApprovalService")
public class BuildingProjectApprovalServiceImpl extends ServiceImpl<BuildingProjectApprovalDao, BuildingProjectApprovalEntity> implements BuildingProjectApprovalService {
    @Autowired(required = false)
    private BuildingProjectApprovalDao buildingProjectApprovalDao;
    @Autowired
    private SysDictService sysDictService;
    @Autowired
    private OnlineMonitorDaydataService onlineMonitorDaydataService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<BuildingProjectApprovalEntity> list=baseMapper.queryData(query);
        int total=baseMapper.queryCount(query);
        PageUtils page = new PageUtils(list, total, query.getLimit(), query.getCurrPage());
        return page;
    }

    @Override
    public List<BuildingProjectApprovalEntity> queryList(Map<String, Object> params) {
        Query query=new Query(params);
        List<BuildingProjectApprovalEntity> list=baseMapper.queryData(query);
        return list;
    }

    @Override
    public List<BuildingProjectApprovalEntity> queryName(Map<String, Object> params) {
        List<BuildingProjectApprovalEntity> list=baseMapper.queryName(params);
        return list;
    }

    @Override
    public List<BuildingProjectApprovalEntity> dataById(String cid) {
        return baseMapper.dataById(cid);
    }

    @Override
    public BuildingProjectApprovalEntity getBuildingInfo(String pid) {
        return baseMapper.getBuildingInfo(pid);
    }

    @Override
    public String insertData(BuildingProjectApprovalEntity entity) {
        int count=buildingProjectApprovalDao.insertData(entity);
        return entity.getPid();
    }
    /**
     * 建设项目-各月投资统计
     */
    @Override
    public   Map<String,Object>  monthlyInvestmentStatistics(String year) {
        int year1=Integer.parseInt(year);
        int lastYear=year1-1;
        Map<String, Object> map =new HashMap<>();
        map.put("year",year);
        map.put("lastYear",lastYear);
        //获取各月投资数据
        List<int []> list2=new ArrayList<>();
        int [] monthContainerByYear=new int [12];
        int [] monthContainerByLastyear=new int [12];
        List<Map<String, Number>> list= baseMapper.monthlyInvestmentStatistics(map);
            for(int i=0;i<list.size();i++){
                Map<String, Number>map2= list.get(i);
                int counts=map2.get("counts").intValue();
                int months=map2.get("months").intValue();
                int years=map2.get("years").intValue();
                if(years==year1){
                    int mount=months-1;
                    monthContainerByYear[mount]+=counts;
                }else{
                    int mount=months-1;
                    monthContainerByLastyear[mount]+=counts;
                }
            }
        map.put("monthContainerByYear",monthContainerByYear);
        map.put("monthContainerByLastyear",monthContainerByLastyear);
        return map;
    }
    /**
     *建设项目-本年投资总额与去年对比
     */
    @Override
    public int[] yearAndLastyearContrastByInvestment(String year) {
        int year1=Integer.parseInt(year);
        int lastYear=year1-1;
        Map<String, Object> map =new HashMap<>();
        map.put("year",year);
        map.put("lastYear",lastYear);
        int [] contrast=new int [2];
        List<Map<String, Number>> list= baseMapper.yearAndLastyearContrastByInvestment(map);
        for(int i=0;i<list.size();i++){
            Map<String, Number>map2= list.get(i);
            int counts=map2.get("counts").intValue();
            int years=map2.get("years").intValue();
            if(years==year1){
                contrast[0]=counts;
            }else{
                contrast[1]=counts;
            }
        }
        return contrast;
    }
    /**
     * 建设项目-本年度各行业投资总额统计
     */
    @Override
    public Map<String,Object>  totalIndustryInvestment(String year) {
        Map<String, Object> map1 =new HashMap<>();
        List<Map<String, Object>> list= baseMapper.totalIndustryInvestment(year);
        String [] industryName = new String[list.size()];
        Double [] industryTotal= new Double [list.size()];
        for(int i=0;i<list.size();i++){
            Map<String, Object> map=list.get(i);
           Double total=Double.parseDouble(map.get("totalInvestment").toString());
           String name=(String)map.get("mingCheng");
            industryName[i]=name;
            industryTotal[i]=total;
        }
        map1.put("industryName",industryName);
        map1.put("industryTotal",industryTotal);
        return map1;
    }
    /**
     * 建设项目-本年度行业投资占比
     */
    @Override
    public JSONArray industryInvestmentProportion(String year) {
        Map<String,Object> map1=new HashMap<>();
        map1.put("year",year);
//        获取所以项目建设数据
        List<Map<String, Object>> list= baseMapper.industry(map1);
        if(list.size()==0){
            return  new JSONArray();
        }
        List<Map<String, Object>> list1=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Map<String, Object> map=list.get(i);
            String code= (String)map.get("industryids");
            if(code.contains(",")){
                String [] codes=code.split(",");
                for(String codests:codes){
                    map.put("industryids",codests);
                    list1.add(map);
                }
            }else{
                list1.add(map);
            }
        }
        List<SysHangyedaimaEntity> countlist=baseMapper.selAllHangYe();
        JSONArray hangYeAll= getJsonArray(countlist,1);
        JSONArray jsonArr = new JSONArray();
        //求行业总和
        Double sum=0.0;
        //查出所有父级行业
//        List<SysHangyedaimaEntity> parentIndustryList= baseMapper.selParentIndustry();
        for(int k=0;k<hangYeAll.size();k++) {
            JSONObject entity=hangYeAll.getJSONObject(k);
            Double  fulei=0.0;
            String fuleiname=(String)entity.get("name");
            for(int g=0;g<list1.size();g++){
                Map<String, Object> map=list1.get(g);
                String industryids1=(String)map.get("industryids");
                if(industryids1.equals(entity.get("daimazhi"))){
                    Double fuleitotalInvestmentsum=Double.parseDouble((String)map.get("totalInvestment"));
                    fulei+=fuleitotalInvestmentsum;
                }
            }
            JSONArray erJiHangYe=(JSONArray)entity.get("children");
//            int key=entity.getHangbiaoshi();
            //获取当父级目录的二级目录列表
//            List<SysHangyedaimaEntity> sublevelIndustriesList=baseMapper.selSublevelIndustries(key);
            double [] zilei1=new double[erJiHangYe.size()];
            String [] zileiname1=new String [erJiHangYe.size()];
            for(int q=0;q<erJiHangYe.size();q++){
                JSONObject sysHangyedaimaEntitysdf=erJiHangYe.getJSONObject(q);
                for(int w=0;w<list1.size();w++){
                    Map<String, Object> map2=list1.get(w);
                    String industryids1=(String)map2.get("industryids");
                    if(industryids1.equals(sysHangyedaimaEntitysdf.get("daimazhi"))){
                        Double zileitotalInvestmentsum=Double.parseDouble((String)map2.get("totalInvestment"));
                        zilei1[q]+=zileitotalInvestmentsum;
                    }
                }
                int test= industryInvestmentProportion2(sysHangyedaimaEntitysdf,list1);
                zilei1[q]+=test;
                zileiname1[q]=(String)sysHangyedaimaEntitysdf.get("name");
            }
            List list3=new ArrayList();
            List list4=new ArrayList();
            if(zilei1.length>0){
                for(int y=0;y<zilei1.length;y++){
                    if(zilei1[y]>0){
                        list3.add(zilei1[y]);
                        list4.add(zileiname1[y]);
                    }
                }
            }
            if(fulei>0){
                list3.add(fulei);
                list4.add(fuleiname);
            }
            Double [] zilei=(Double[])list3.toArray(new Double[0]);
            String [] zileiname=(String[])list4.toArray(new String[0]);

            Double onesum=0.0;
            for(int e=0;e<zilei.length;e++){
                onesum+=zilei[e];
            }
            JSONObject jsonObjTemp = new JSONObject();
            if(onesum>0){
                String key1 = "categories", key2 = "data";
                jsonObjTemp.put(key1,zileiname);
//                for(int t=0;t<zilei.length;t++){
//                    zilei[t]=(double)Math.round((zilei[t]/onesum)*100);
//                }
                jsonObjTemp.put(key2,zilei);
            }else{
                continue;
            }
            sum+=onesum;
            String key3 = "name", key4 = "y", key5 = "drilldown";
            JSONObject jsonObjTemp1 = new JSONObject();
            jsonObjTemp1.put(key3,fuleiname);
            jsonObjTemp1.put(key4,onesum);
            jsonObjTemp1.put(key5,jsonObjTemp);
            jsonArr.add(jsonObjTemp1);
        }
        for(int r=0;r<jsonArr.size();r++){
            if(r==0){
                JSONObject job = jsonArr.getJSONObject(r); // 遍历 jsonarray 数组，把每一个对象转成 json 对象
//                double y=Double.parseDouble(job.get("y").toString());
//                double x=y/sum;
//                job.put("y",(double)Math.round(x * 100));
                job.put("sum",sum);
            }else{
                break;
            }
        }
        return jsonArr;
    }
    /**
     * 本年度审批项目、本年度项目建设投资、环保投资、与去年同期相比，项目建设投资总额增加
     */
    @Override
    public Map<String, Object> ProjectConstructionStatistics(String year) {
        int year1=Integer.parseInt(year);
        int lastYear=year1-1;
        Map<String, Object> map =new HashMap<>();
        map.put("year",year);
        map.put("lastYear",lastYear);
        Map<String, Object> map2=baseMapper.ProjectConstructionStatistics(map);
        if(map2.get("test")==null){
            map2.put("test","0");
        }
        if(map2.get("counts")==null){
            map2.put("counts","0");
        }
        if(map2.get("investment")==null){
            map2.put("investment","0");
        }
        if(map2.get("protectionInvestment")==null){
            map2.put("protectionInvestment","0");
        }
        Double test=Double.parseDouble(map2.get("test").toString());
        Double investment=Double.parseDouble(map2.get("investment").toString());
        Double test2=0.0;
        if(investment==0 ||test==0){
            if(test==0 && investment!=0){
                map2.put("growth",100);
            }else if(test!=0 && investment==0){
                map2.put("growth",0);
            }else{
                map2.put("growth",0);
            }

        }else{
            if(investment < test){
                map2.put("growth",0);
            }else{
                // 增长率=增量/原总量*100%
                test2=((investment-test)/test)*100;
                map2.put("growth",Math.round(test2*100)/100);
            }
        }

        return map2;
    }

    /**
     * 递归循环下级目录
     */
    @Override
    public int industryInvestmentProportion2(JSONObject sysHangyedaimaEntitysdf ,List<Map<String, Object>> list1) {
        JSONArray erJiHangYe=(JSONArray)sysHangyedaimaEntitysdf.get("children");
//        Integer key=entity.getHangbiaoshi();
//        List<SysHangyedaimaEntity> sublevelIndustriesList=baseMapper.selSublevelIndustries(key);
        if(erJiHangYe.size()<=0){
            return 0;
        }
        int count1=0;
        int count2=0;
        for(int q=0;q<erJiHangYe.size();q++){
            JSONObject entity=erJiHangYe.getJSONObject(q);
            for(int w=0;w<list1.size();w++){
                Map<String, Object> map=list1.get(w);
                String industryids1=(String)map.get("industryids");
                if(industryids1.equals(entity.get("daimazhi"))){
                    Double fuleitotalInvestmentsum=Double.parseDouble((String)map.get("totalInvestment"));
                    count1+=fuleitotalInvestmentsum;
                }
            }
             count2+=industryInvestmentProportion2(entity,list1);
            }
        int count =count1+count2;
        return count;
    }
    /**
     * 获取行业类型列表
     */
    @Override
    public JSONArray getJsonArray(List<SysHangyedaimaEntity> codeList, int hangBiaoShi) {
        String key1 = "name", key2 = "daimazhi", key3 = "hangbiaoshi", key4 = "fujidaimabiaoshi",key5 = "children";
        JSONArray jsonArr = new JSONArray();
        for (SysHangyedaimaEntity entity : codeList) {
            JSONObject jsonObjTemp = new JSONObject();
            if (entity.getFujidaimabiaoshi().equals(hangBiaoShi)) {
                jsonObjTemp.put(key1,entity.getMingcheng() );
                jsonObjTemp.put(key2, entity.getDaimazhi());
                jsonObjTemp.put(key3, entity.getHangbiaoshi());
                jsonObjTemp.put(key4, entity.getFujidaimabiaoshi());
                jsonObjTemp.put(key5, getJsonArray(codeList,entity.getHangbiaoshi()));
                jsonArr.add(jsonObjTemp);
            }
        }
        return jsonArr;
    }
}

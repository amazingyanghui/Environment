package com.tengdi.environmentalprotectionint.modules.online.service.impl;

import com.tengdi.environmentalprotectionint.modules.online.dao.OnlineMonitorPointFactorDao;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPointFactorEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorPointFactorService;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineTableRetrieveService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;


@Service("onlineMonitorPointFactorService")
public class OnlineMonitorPointFactorServiceImpl extends ServiceImpl<OnlineMonitorPointFactorDao, OnlineMonitorPointFactorEntity> implements OnlineMonitorPointFactorService {

    @Autowired
    private OnlineTableRetrieveService onlineTableRetrieveService ;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Query query=new Query(params);
        List<OnlineMonitorPointFactorEntity> list=baseMapper.queryData(query);
        int total=baseMapper.queryCount(query);
        PageUtils page = new PageUtils(list, total, query.getLimit(), query.getCurrPage());
        return page;
    }

    @Override
    public OnlineMonitorPointFactorEntity dataByFid(Map map) {
        return baseMapper.dataByFid(map);
    }

    @Override
    public List<OnlineMonitorPointFactorEntity> dataByMid(String mid) {
        return baseMapper.dataByMid(mid);
    }
    @Override
    public List<OnlineMonitorPointFactorEntity> queryDrains(Map map){
        return baseMapper.queryDrains(map);
    };

    @Override
    public JSONArray drainsBaseInfo(String pid) {
        JSONArray jsonArr = new JSONArray();
        List<OnlineMonitorPointFactorEntity> list ;
        list = baseMapper.drainsBaseInfo(pid);
        String drainsName = "name",
                drainsCount = "value",
                waterCount = "count",
                airCount = "count",
                vocsCount = "count";
        JSONObject water = new JSONObject();
        JSONObject air = new JSONObject();
        JSONObject vocs = new JSONObject();

        water.put(drainsName,"water");
        water.put(waterCount,0);

        air.put(drainsName,"air");
        air.put(airCount,0);

        vocs.put(drainsName,"vocs");
        vocs.put(vocsCount,0);

        for(int i=0;i<list.size();i++){
            OnlineMonitorPointFactorEntity onlineMonitorPointFactorEntity = list.get(i);

            int count=Integer.parseInt(onlineMonitorPointFactorEntity.getDrainsCount());
            if("0".equals(onlineMonitorPointFactorEntity.getMonitorType())){
                water.put(waterCount,count);

            }else if("1".equals(onlineMonitorPointFactorEntity.getMonitorType())){
                air.put(airCount,count);
            }else{
                vocs.put(vocsCount,count);
            }

        }

        jsonArr.add(water);
        jsonArr.add(air);
        jsonArr.add(vocs);
        return jsonArr;

    }


    /**
     * 因子单个排口每月排放数据统计
     * @param map
     * @return
     */
    @Override
    public JSONArray monthDrainsFactor(Map map){

        JSONArray jsonArr = new JSONArray();
        List<OnlineMonitorPointFactorEntity>list ;
        //通过参数判断是查单个排口还是多个排口

        int monthSum = 0 ;
        double January = 0 ;
        double February = 0 ;
        double March = 0 ;
        double April = 0 ;
        double May = 0 ;
        double June = 0 ;
        double July = 0 ;
        double August = 0 ;
        double December = 0 ;
        double September = 0 ;
        double November = 0 ;
        double October = 0 ;
        DecimalFormat    df   = new DecimalFormat("######0.00");

        if(map.get("type")==null){ //单个排口
            list = baseMapper.monthDrainsFactor(map);
            for(int i=0;i<list.size();i++){
                OnlineMonitorPointFactorEntity cominfoEnvironmentalManageEntity = list.get(i);
                JSONObject jsonObj = new JSONObject();
                String month ="month",
                        monthVauleCount ="monthVauleCount";
                if(cominfoEnvironmentalManageEntity.getMonth()!=null&&cominfoEnvironmentalManageEntity.getMonth().length()>0){
                    jsonObj.put(month,Integer.parseInt((String)cominfoEnvironmentalManageEntity.getMonth()));
                }
                if(cominfoEnvironmentalManageEntity.getMonthVauleCount()!=null){

                    String  changedValue =df.format(Double.parseDouble((String)cominfoEnvironmentalManageEntity.getMonthVauleCount()));
                    double count =Double.parseDouble(changedValue);
                    //doubles = Double.parseDouble(cominfoEnvironmentalManageEntity.getMonthVauleCount());
                    jsonObj.put(monthVauleCount,count);
                }else {

                    jsonObj.put(monthVauleCount,0);
                }

                jsonArr.add(jsonObj);
            }

        }else{//所有排口
            JSONArray array=new JSONArray();
            //根据参数type查询对应因子的所有排口
            List<Map<String, Object>> allPortList = onlineTableRetrieveService.queryPortTable(map);

                //遍历查询出的每个排口表
                for(int k=0;k<allPortList.size();k++){
                    Map<String, Object> entity =allPortList.get(k);
                    //names[k]=entity.get("portname").toString();
                    map.put("tableName",entity.get("ddtablename"));
                    List<OnlineMonitorPointFactorEntity > portList= baseMapper.monthDrainsFactor(map);
                    if(portList.size()>0){
                        for(int i=0;i<portList.size();i++){ //遍历某个月数据
                            OnlineMonitorPointFactorEntity  entity1 = portList.get(i);
                            if(entity1.getMonth()!=null){
                                if(Integer.parseInt(entity1.getMonth())==1){
                                    if(entity1.getMonthVauleCount()!=null){
                                        January += NumberChange((String)entity1.getMonthVauleCount());
                                    };
                                } else if(Integer.parseInt(entity1.getMonth())==2){
                                    if(entity1.getMonthVauleCount()!=null){
                                        February += NumberChange((String)entity1.getMonthVauleCount());
                                    }
                                }else if(Integer.parseInt(entity1.getMonth())==3){
                                    if(entity1.getMonthVauleCount()!=null){
                                        March += NumberChange((String)entity1.getMonthVauleCount());
                                    }
                                }else if(Integer.parseInt(entity1.getMonth())==4){
                                    if(entity1.getMonthVauleCount()!=null){
                                        April += NumberChange((String)entity1.getMonthVauleCount());
                                    }
                                }else if(Integer.parseInt(entity1.getMonth())==5){
                                    if(entity1.getMonthVauleCount()!=null){
                                        May += NumberChange((String)entity1.getMonthVauleCount());
                                    }

                                }else if(Integer.parseInt(entity1.getMonth())==6){
                                    if(entity1.getMonthVauleCount()!=null){
                                        June += NumberChange((String)entity1.getMonthVauleCount());
                                    }
                                }else if(Integer.parseInt(entity1.getMonth())==7){
                                    if(entity1.getMonthVauleCount()!=null){
                                        July += NumberChange((String)entity1.getMonthVauleCount());
                                    }
                                }else if(Integer.parseInt(entity1.getMonth())==8){
                                    if(entity1.getMonthVauleCount()!=null){
                                        August += NumberChange((String)entity1.getMonthVauleCount());
                                    }
                                }else if(Integer.parseInt(entity1.getMonth())==9){
                                    if(entity1.getMonthVauleCount()!=null){
                                        September += NumberChange((String)entity1.getMonthVauleCount());
                                    }
                                }else if(Integer.parseInt(entity1.getMonth())==10){
                                    if(entity1.getMonthVauleCount()!=null){
                                        October += NumberChange((String)entity1.getMonthVauleCount());
                                    }
                                }else if(Integer.parseInt(entity1.getMonth())==11){
                                    if(entity1.getMonthVauleCount()!=null){
                                        November +=NumberChange((String)entity1.getMonthVauleCount());
                                    }

                                }else if(Integer.parseInt(entity1.getMonth())==12){
                                    if(entity1.getMonthVauleCount()!=null){
                                        December +=NumberChange((String)entity1.getMonthVauleCount());
                                    }

                                }
                            }


                        }

                    }

                }
            for(int m=1;m<13;m++){
                JSONObject obj=new JSONObject();
                obj.put("month",m);
                // obj.put("count",value);
                    if(m==1){
                        obj.put("monthVauleCount",Double.parseDouble(String.format("%.2f", January)));
                    }else if(m==2){
                        obj.put("monthVauleCount",Double.parseDouble(String.format("%.2f", February)));
                    }else if(m==3){
                        obj.put("monthVauleCount",Double.parseDouble(String.format("%.2f", March)));
                    }else if(m==4){
                        obj.put("monthVauleCount",Double.parseDouble(String.format("%.2f", April)));
                    }else if(m==5){
                        obj.put("monthVauleCount",Double.parseDouble(String.format("%.2f", May)));
                    }else if(m==6){
                        obj.put("monthVauleCount",Double.parseDouble(String.format("%.2f", June)));
                    }else if(m==7){
                        obj.put("monthVauleCount",Double.parseDouble(String.format("%.2f", July)));
                    }else if(m==8){
                        obj.put("monthVauleCount",Double.parseDouble(String.format("%.2f", August)));
                    }else if(m==9){
                        obj.put("monthVauleCount",Double.parseDouble(String.format("%.2f", September)));
                    }else if(m==10){
                        obj.put("monthVauleCount",Double.parseDouble(String.format("%.2f", October)));
                    }else if(m==11){
                        obj.put("monthVauleCount",Double.parseDouble(String.format("%.2f", November)));
                    }else if(m==12){
                        obj.put("monthVauleCount",Double.parseDouble(String.format("%.2f", December)));
                    }
                jsonArr.add(obj);

            }

        }

        return  jsonArr ;
    }


    @Override
    public JSONArray yearDrainsFactor(Map map){
        int lastYear = 0 ;
        int curyear = 0 ;
        double curYearCount = 0 ;
        double lastYearCount = 0 ;
        String year ="year", yearVauleCount ="yearVauleCount",
        lastyear ="lastyear", lastyearVauleCount ="lastyearVauleCount";

        JSONArray jsonArr = new JSONArray();
        List<OnlineMonitorPointFactorEntity>list ;
        List<OnlineMonitorPointFactorEntity>lastlist ;
        Map<String,Object> map2=new HashMap<>();
        map2.put("tableName",map.get("tableName"));
        map2.put("fid",map.get("fid"));
        map2.put("cid",map.get("cid"));
        curyear = Integer.parseInt((String )map.get("year")) ;
        lastYear = Integer.parseInt((String )map.get("year"))-1 ;
        map2.put("year",lastYear);

        if(map.get("type")==null){//单排口
            list = baseMapper.yearDrainsFactor(map);

            lastlist = baseMapper.yearDrainsFactor(map2);

            if(list.size()>0){
                for(int i=0;i<list.size();i++){
                    OnlineMonitorPointFactorEntity onlineMonitorPointFactorEntity = list.get(i);
                    JSONObject jsonObj = new JSONObject();
                    if(onlineMonitorPointFactorEntity.getYear()!=null){
                        jsonObj.put(year,Integer.parseInt(onlineMonitorPointFactorEntity.getYear()));
                    }

                    if(onlineMonitorPointFactorEntity.getYearVauleCount()!=null){
                        double yearcout_ =  NumberChange((String)onlineMonitorPointFactorEntity.getYearVauleCount());
                        jsonObj.put(yearVauleCount,Double.parseDouble(String.format("%.2f", yearcout_)));
                    }

                    jsonArr.add(jsonObj);
                }
            }else {
                JSONObject jsonObj_ = new JSONObject();

                jsonObj_.put(year,curyear);
                jsonObj_.put(yearVauleCount,0);
                jsonArr.add(jsonObj_);
            }

            if(lastlist.size()>0){

                for(int i=0;i<lastlist.size();i++){
                    OnlineMonitorPointFactorEntity cominfoEnvironmentalManageEntity = list.get(i);
                    JSONObject jsonObj_ = new JSONObject();
                    if(cominfoEnvironmentalManageEntity.getYear()!=null){
                        jsonObj_.put(lastyear,cominfoEnvironmentalManageEntity.getYear());
                    }
                    if(cominfoEnvironmentalManageEntity.getYearVauleCount()!=null){
                        double yearcout_ =  NumberChange((String)cominfoEnvironmentalManageEntity.getYearVauleCount());
                        jsonObj_.put(lastyearVauleCount,Double.parseDouble(String.format("%.2f", yearcout_)));
                    }

                    jsonArr.add(jsonObj_);
                }
            }else{
                JSONObject jsonObj_ = new JSONObject();
                jsonObj_.put(lastyear,lastYear);
                jsonObj_.put(lastyearVauleCount,0);
                jsonArr.add(jsonObj_);
            }


        }else {//所有排口

            List<Map<String, Object>> allPortList = onlineTableRetrieveService.queryPortTable(map);

            //遍历查询出的每个排口表
            for(int k=0;k<allPortList.size();k++){
                Map<String, Object> entity =allPortList.get(k);
                map.put("tableName",entity.get("ddtablename"));
                List<OnlineMonitorPointFactorEntity > portList= baseMapper.yearDrainsFactor(map);
                // System.out.println("  查询参数  ======== > "+map);

                if(portList.size()>0){
                    for(int i=0;i<portList.size();i++){ //遍历某个月数据
                        OnlineMonitorPointFactorEntity  entity1 = portList.get(i);
                        //System.out.println(" 年份 "+(entity1.getYear()));
                        //System.out.println(" 年统计数据 "+(entity1.getYearVauleCount()));
                        // sums[k]=Integer.parseInt(entity1.get("rankCount").toString());
                        if(entity1.getYearVauleCount()!=null){
                            curYearCount+=NumberChange((String) entity1.getYearVauleCount());


                        }


                    }

                }

            }
            //查询去年的
            List<Map<String, Object>> allPortList2 = onlineTableRetrieveService.queryPortTable(map2);

            //遍历查询出的每个排口表
            for(int k=0;k<allPortList2.size();k++){
                Map<String, Object> entity =allPortList2.get(k);
                //names[k]=entity.get("portname").toString();
                map.put("tableName",entity.get("ddtablename"));

                List<OnlineMonitorPointFactorEntity > portList2= baseMapper.yearDrainsFactor(map2);
                // System.out.println("  查询参数  ======== > "+map);

                if(portList2.size()>0){
                    for(int i=0;i<portList2.size();i++){ //遍历某个月数据
                        OnlineMonitorPointFactorEntity  entity2 = portList2.get(i);
                        // sums[k]=Integer.parseInt(entity1.get("rankCount").toString());
                        if(entity2.getYearVauleCount()!=null){
                            lastYearCount+= NumberChange((String) entity2.getYearVauleCount());
                        }


                    }

                }

            }
            JSONObject jsonObj_cur = new JSONObject();
            jsonObj_cur.put(year,curyear);
            jsonObj_cur.put(yearVauleCount,Double.parseDouble(String.format("%.2f", curYearCount)));
            jsonArr.add(jsonObj_cur);
            JSONObject jsonObj_last = new JSONObject();
            jsonObj_last.put(lastyear,lastYear);
            jsonObj_last.put(lastyearVauleCount,Double.parseDouble(String.format("%.2f", lastYearCount)));
            jsonArr.add(jsonObj_last);
            //System.out.println(" 今年排放总量 "+curYearCount);
            //System.out.println(" 去年排放总量 "+lastYearCount);

        }

        return  jsonArr ;
    }

    @Override
    public JSONArray monthDrainsFactorPotency(Map map){
        double January = 0.00 ;
        double February = 0.00 ;
        double March = 0.00 ;
        double April = 0.00 ;
        double May = 0.00 ;
        double June = 0.00 ;
        double July = 0.00 ;
        double August = 0.00 ;
        double December = 0.00 ;
        double September = 0.00 ;
        double November = 0.00 ;
        double October = 0.00 ;
        JSONArray jsonArr = new JSONArray();
        List<OnlineMonitorPointFactorEntity>list ;
        if(map.get("type")==null){ //单排口
            list = baseMapper.monthDrainsFactorPotency(map);
            for(int i=0;i<list.size();i++){
                OnlineMonitorPointFactorEntity onlineMonitorPointFactorEntity = list.get(i);
                JSONObject jsonObj = new JSONObject();
                String month ="month",
                        potencyCount ="potencyCount";
                if(onlineMonitorPointFactorEntity.getMonth()!=null&&onlineMonitorPointFactorEntity.getMonth().length()>0){
                    jsonObj.put(month,Integer.parseInt((String)onlineMonitorPointFactorEntity.getMonth()));
                }
                if(onlineMonitorPointFactorEntity.getPotencyCount()!=null&&onlineMonitorPointFactorEntity.getPotencyCount().length()>0){
                    double count_ = NumberChange((String)onlineMonitorPointFactorEntity.getPotencyCount()) ;
                    jsonObj.put(potencyCount,count_);

                }

                jsonArr.add(jsonObj);
            }

        }else{//该类型排口

            //根据参数type查询对应因子的所有排口
            List<Map<String, Object>> allPortList = onlineTableRetrieveService.queryPortTable(map);

            //遍历查询出的每个排口表
            for(int k=0;k<allPortList.size();k++){
                Map<String, Object> entity =allPortList.get(k);
                //names[k]=entity.get("portname").toString();
                //  System.out.println("  排口名称 "+entity.get("portname").toString() +" 表名----- "+entity.get("ddtablename"));
                map.put("tableName",entity.get("ddtablename"));

                List<OnlineMonitorPointFactorEntity > portList= baseMapper.monthDrainsFactorPotency(map);
                // System.out.println("  查询参数  ======== > "+map);

                if(portList.size()>0){
                    for(int i=0;i<portList.size();i++){ //遍历某个月数据
                        OnlineMonitorPointFactorEntity  entity1 = portList.get(i);
                        if(entity1.getMonth()!=null){
                            if(Integer.parseInt(entity1.getMonth())==1){
                                if(entity1.getPotencyCount()!=null){
                                    January +=NumberChange((String) entity1.getPotencyCount());
                                }
                            } else if(Integer.parseInt(entity1.getMonth())==2){
                                if(entity1.getPotencyCount()!=null){
                                    February += NumberChange((String) entity1.getPotencyCount());
                                }
                            }else if(Integer.parseInt(entity1.getMonth())==3){
                                if(entity1.getPotencyCount()!=null){
                                    March += NumberChange((String) entity1.getPotencyCount());
                                }
                            }else if(Integer.parseInt(entity1.getMonth())==4){
                                if(entity1.getPotencyCount()!=null){
                                    April += NumberChange((String) entity1.getPotencyCount());
                                }
                            }else if(Integer.parseInt(entity1.getMonth())==5){
                                if(entity1.getPotencyCount()!=null){
                                    May += NumberChange((String) entity1.getPotencyCount());
                                }

                            }else if(Integer.parseInt(entity1.getMonth())==6){
                                if(entity1.getPotencyCount()!=null){
                                    June += NumberChange((String) entity1.getPotencyCount());
                                }
                            }else if(Integer.parseInt(entity1.getMonth())==7){
                                if(entity1.getPotencyCount()!=null){
                                    July += NumberChange((String) entity1.getPotencyCount());
                                }
                            }else if(Integer.parseInt(entity1.getMonth())==8){
                                if(entity1.getPotencyCount()!=null){
                                    August += NumberChange((String) entity1.getPotencyCount());
                                }
                            }else if(Integer.parseInt(entity1.getMonth())==9){
                                if(entity1.getPotencyCount()!=null){
                                    September +=NumberChange((String) entity1.getPotencyCount());
                                }
                            }else if(Integer.parseInt(entity1.getMonth())==10){
                                if(entity1.getPotencyCount()!=null){
                                    October +=NumberChange((String) entity1.getPotencyCount());
                                }
                            }else if(Integer.parseInt(entity1.getMonth())==11){
                                if(entity1.getPotencyCount()!=null){
                                    November += NumberChange((String) entity1.getPotencyCount());
                                }

                            }else if(Integer.parseInt(entity1.getMonth())==12){
                                if(entity1.getPotencyCount()!=null){
                                    December += NumberChange((String) entity1.getPotencyCount());
                                }

                            }
                        }


                    }

                }

            }
            for(int m=1;m<13;m++){
                JSONObject obj=new JSONObject();
                obj.put("month",m);
                // obj.put("count",value);
                if(m==1){
                    obj.put("potencyCount",Double.parseDouble(String.format("%.2f", January)));
                }else if(m==2){
                    obj.put("potencyCount",Double.parseDouble(String.format("%.2f", February)));
                }else if(m==3){
                    obj.put("potencyCount",Double.parseDouble(String.format("%.2f", March)));
                }else if(m==4){
                    obj.put("potencyCount",Double.parseDouble(String.format("%.2f", April)));
                }else if(m==5){
                    obj.put("potencyCount",Double.parseDouble(String.format("%.2f", May)));
                }else if(m==6){
                    obj.put("potencyCount",Double.parseDouble(String.format("%.2f", June)));
                }else if(m==7){
                    obj.put("potencyCount",Double.parseDouble(String.format("%.2f", July)));
                }else if(m==8){
                    obj.put("potencyCount",Double.parseDouble(String.format("%.2f", August)));
                }else if(m==9){
                    obj.put("potencyCount",Double.parseDouble(String.format("%.2f", September)));
                }else if(m==10){
                    obj.put("potencyCount",Double.parseDouble(String.format("%.2f", October)));
                }else if(m==11){
                    obj.put("potencyCount",Double.parseDouble(String.format("%.2f", November)));
                }else if(m==12){
                    obj.put("potencyCount",Double.parseDouble(String.format("%.2f", December)));
                }
                jsonArr.add(obj);
            }
            //System.out.println(" 一月浓度统计数据 "+January);
        }
        return  jsonArr ;
    }

    @Override
    public JSONArray selFactorByRanking(Map map){
        Map<String, Integer> maps = new TreeMap<String, Integer>();
        JSONObject jsonObj = new JSONObject();
        JSONArray jsonArr = new JSONArray();
        List<Map<String, Object>>list = onlineTableRetrieveService.queryPortTable(map);
        String [] names=new String[list.size()];
        int [] sums=new int[list.size()];
        for(int k=0;k<list.size();k++){
            Map<String, Object> entity =list.get(k);
            names[k]=entity.get("portname").toString();
            map.put("tableName",entity.get("ddtablename"));
            List<Map<String, Object> > list2= baseMapper.drainsFactorRanking(map);
            for(int i=0;i<list2.size();i++){
                Map<String, Object>  entity1 = list2.get(i);
                if(entity1.get("rankCount")!=null){
                    sums[k]=Double.valueOf(entity1.get("rankCount").toString()).intValue();
                }

            }
            maps.put(names[k],sums[k]);
        }
        //LinkedHashMap<String, Integer> mapx = new LinkedHashMap<>();
        //先转成ArrayList集合
        ArrayList<Map.Entry<String, Integer>> list_ =
                new ArrayList<Map.Entry<String, Integer>>(maps.entrySet());
        //从小到大排序（从大到小将o1与o2交换即可）
        Collections.sort(list_, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                /** 升序
                return ((o1.getValue() - o2.getValue() == 0) ?
                        0: (o1.getValue() - o2.getValue() < 0) ? -1: 1);*/
                return o2.getValue().compareTo(o1.getValue()); //降序
            }
        });
        //新建一个LinkedHashMap，把排序后的List放入
        LinkedHashMap<String, Integer> newmap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list_) {
            newmap.put(entry.getKey(), entry.getValue());
            jsonObj.put("key",entry.getKey());
            jsonObj.put("value",entry.getValue());
            jsonArr.add(jsonObj) ;
        }
        //遍历输出
        for (Map.Entry<String, Integer> entry : newmap.entrySet()) {
        }
        return jsonArr ;
    }

    /**
     * 数字保留两位小数
     * @param str
     * @return
     */
    public static double NumberChange(String str){
        DecimalFormat    df   = new DecimalFormat("######0.00");
        String  changedValue =df.format(Double.parseDouble(str));
        double count =Double.parseDouble(changedValue);
        System.out.println(" 转化后的数值 "+count);
        return count ;
    }

}

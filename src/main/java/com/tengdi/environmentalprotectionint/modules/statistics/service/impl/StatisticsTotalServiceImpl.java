package com.tengdi.environmentalprotectionint.modules.statistics.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.environmentalprotectionint.modules.common.utils.HttpClientUtils;
import com.tengdi.environmentalprotectionint.modules.statistics.dao.StatisticsTotalDao;
import com.tengdi.environmentalprotectionint.modules.statistics.entity.StatisticsTotalEntity;
import com.tengdi.environmentalprotectionint.modules.statistics.service.StatisticsTotalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("statisticsTotalService")
public class StatisticsTotalServiceImpl extends ServiceImpl<StatisticsTotalDao, StatisticsTotalEntity> implements StatisticsTotalService {


    @Override
    public List<StatisticsTotalEntity> queryList(Map<String, Object> params) {
        return baseMapper.queryList(params);
    }

    @Override
    public List<StatisticsTotalEntity> getCompanyType(Map<String, Object> map) {
        return baseMapper.getCompanyType(map);
    }

    @Override
    public JSONArray getMonitorPoint(String url) {
        JSONObject text= (JSONObject) HttpClientUtils.doGet(url);
        if(text.get("Message") instanceof JSONArray){
            System.out.println(".net接口,类型为：JSONArray"+text.get("Message"));
            return (JSONArray) text.get("Message");
        }else{
            String tip=".net接口,数据没法转为JSONArray类型";
            System.out.println(tip);
            return new JSONArray();
        }
    }

    @Override
    public JSONArray getJavaMonitorPoint(String url) {
        JSONObject text= (JSONObject) HttpClientUtils.doGet(url);
        if(text.get("data") instanceof JSONArray){
            System.out.println("java接口,类型为：JSONArray"+text.get("data"));
            return (JSONArray) text.get("data");
        }else{
            System.out.println("java接口,没法转为JSONArray类型");
            return new JSONArray();
        }
    }

}

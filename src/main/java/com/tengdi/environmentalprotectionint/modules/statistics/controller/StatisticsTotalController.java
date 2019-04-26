package com.tengdi.environmentalprotectionint.modules.statistics.controller;

import com.tengdi.environmentalprotectionint.modules.statistics.entity.StatisticsTotalEntity;
import com.tengdi.environmentalprotectionint.modules.statistics.service.StatisticsTotalService;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * 大屏图
 *
 * @author tengdi
 * @email 
 * @date 2018-10-26 10:10:19
 */
@RestController
@RequestMapping("statistics/total")
@Api(tags="大屏图")
public class StatisticsTotalController extends BaseController{
    @Autowired
    private StatisticsTotalService statisticsTotalService;

    /**
     * 企业信息概况
     */
    @GetMapping("/baseInfo")
    @ApiOperation("企业信息概况")
    public String list(@RequestParam Map<String, Object> params){
        List<StatisticsTotalEntity> list= statisticsTotalService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 企业行业类型分布
     */
    @GetMapping("/getCompanyType")
    @ApiOperation("企业行业类型分布")
    public String getCompanyType(@RequestParam Map<String, Object> params){
        List<StatisticsTotalEntity> list= statisticsTotalService.getCompanyType(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 获取空气或水监控点
     */
    @GetMapping("/getMonitorPoint")
    @ApiOperation("获取空气或水监控点")
    public String getMonitorPoint(@RequestParam Map<String, Object> params){
        String url= String.valueOf(params.get("url"));
        JSONArray list= JSONArray.fromObject(statisticsTotalService.getMonitorPoint(url));
        return LayUiDataUtils.converJsonObjForLayUi(list).toString();
    }

    /**
     * 根据空气或水监控点获取因子
     */
    @GetMapping("/getMonitorFactor")
    @ApiOperation("根据空气或水监控点获取因子")
    public String getMonitorFactor(@RequestParam Map<String, Object> params){
        String url= String.valueOf(params.get("url"));
        JSONArray list= JSONArray.fromObject(statisticsTotalService.getMonitorPoint(url));
        return LayUiDataUtils.converJsonObjForLayUi(list).toString();
    }

    /**
     *空气或水监测站联网统计
     */
    @GetMapping("/onlinePointData")
    @ApiOperation("空气或水监测站联网统计 ")
    public String onlinePointData(@RequestParam Map<String, Object> params){
        String url= String.valueOf(params.get("url"));
        JSONArray list= JSONArray.fromObject(statisticsTotalService.getMonitorPoint(url));
        return LayUiDataUtils.converJsonObjForLayUi(list).toString();
    }
    /**
     *获取检测站基本数据
     */
    @GetMapping("/getOnlineBaseInfo")
    @ApiOperation("获取检测站基本数据 ")
    public String getOnlineBaseInfo(@RequestParam Map<String, Object> params){
        String url= String.valueOf(params.get("url"));
        JSONArray list= JSONArray.fromObject(statisticsTotalService.getMonitorPoint(url));
        return LayUiDataUtils.converJsonObjForLayUi(list).toString();
    }

    /**
     *获取排放去向
     */
    @GetMapping("/getDischargeTo")
    @ApiOperation("获取排放去向")
    public String getDischargeTo(@RequestParam Map<String, Object> params){
        String url= String.valueOf(params.get("url"));
        JSONArray list= JSONArray.fromObject(statisticsTotalService.getMonitorPoint(url));
        return LayUiDataUtils.converJsonObjForLayUi(list).toString();
    }

    /**
     *获取水或气监测污染物统计
     */
    @GetMapping("/getWaterWasteTotal")
    @ApiOperation("获取水或气监测污染物统计")
    public String getWaterWasteTotal(@RequestParam Map<String, Object> params){
        String url= String.valueOf(params.get("url"));
        JSONArray list= JSONArray.fromObject(statisticsTotalService.getMonitorPoint(url));
        return LayUiDataUtils.converJsonObjForLayUi(list).toString();
    }

    /**
     *获取LDAR统计数据
     */
    @GetMapping("/getLDARInfoTotal")
    @ApiOperation("获取LDAR统计数据")
    public String getLDARInfoTotal(@RequestParam Map<String, Object> params){
        String url= String.valueOf(params.get("url"));
        JSONArray list= JSONArray.fromObject(statisticsTotalService.getJavaMonitorPoint(url));
        return LayUiDataUtils.converJsonObjForLayUi(list).toString();
    }
}

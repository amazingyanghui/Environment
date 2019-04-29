package com.tengdi.environmentalprotectionint.modules.online.controller;

import com.tengdi.environmentalprotectionint.modules.common.entity.OnlineCommonEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.*;
import com.tengdi.environmentalprotectionint.modules.online.service.*;
import com.tengdi.core.utils.*;

import java.util.*;

import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 日数据存放表
 *
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:51:57
 */
@RestController
@RequestMapping("online/onlinemonitordaydata")
@Api(tags="日数据存放表")
public class OnlineMonitorDaydataController extends BaseController{
    @Autowired
    private OnlineMonitorDaydataService onlineMonitorDaydataService;
    @Autowired
    private OnlineMonitorPortinfoService onlineMonitorPortinfoService;
    @Autowired
    private OnlineTableRetrieveService onlineTableRetrieveService;
    @Autowired
    private OnlineMonitorPointFactorService onlineMonitorPointFactorService;
    @Autowired
    private OnlineMonitorFactorService onlineMonitorFactorService;
    //获取废气废水因子
    @Value("${tengdi.commonConfig.FactorStr}")
    private String[] FactorStr;
//    /**
//     * 列表
//     */
//    @GetMapping
//    @ApiOperation("列表")
//    public String list(@RequestParam Map<String, Object> params){
//        PageUtils page = onlineMonitorDaydataService.queryPage(params);
//
//        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
//    }

    /**
     * 字典list
     */
    @GetMapping("/dictList/{type}")
    @ApiOperation("字典list")
    public R dictList(@PathVariable("type")String type){
        List<SysDictEntity> list=onlineMonitorDaydataService.dictList(type);

        return R.ok().put("dicts",list);
    }

//    /**
//     * 信息
//     */
//    @GetMapping("/{pid}")
//    @ApiOperation("信息")
//    public R info(@PathVariable("pid") String pid){
//        OnlineMonitorDaydataEntity onlineMonitorDaydata = onlineMonitorDaydataService.selectById(pid);
//
//        return R.ok().put("onlineMonitorDaydata", onlineMonitorDaydata);
//    }

    /**
     * 在线监控日数据(cid:公司id；mid:排口id；startDate:开始时间；endDate:结束时间；factorList:因子list；)||（testData：返回数据list；names：返回因子名称list；isEnvironmentFactorList：(0：废水废气的排放量；1：不是废水废气的浓度)）
     */
    @PostMapping("/testData")
    @ApiOperation("在线监控日数据(cid:公司id；mid:排口id；startDate:开始时间；endDate:结束时间；factorList:因子list；)||（testData：返回数据list；names：返回因子名称list；isEnvironmentFactorList：(0：废水废气的排放量；1：不是废水废气的浓度);minimumValueList:最小值list；maximumValueList：最大值list）")
    public R testData(OnlineCommonEntity onlineCommonEntity) {
        OnlineCommonEntity entity=onlineMonitorDaydataService.onlineDayData(onlineCommonEntity);
        List<double[]> testDataList = entity.getTestDataList();
        List<String> nameList=entity.getNameList();
        List<Integer> isEnvironmentFactorList=entity.getIsEnvironmentFactorList();
        List<Double> maximumValueList=entity.getMaximumValueList();
        List<Double> minimumValueList=entity.getMinimumValueList();
        return R.ok().put("testData", testDataList)
                .put("names",nameList)
                .put("isEnvironmentFactorList",isEnvironmentFactorList)
                .put("maximumValueList",maximumValueList)
                .put("minimumValueList",minimumValueList);
    }

//    /**
//     * 保存
//     */
//    @PostMapping
//    @ApiOperation("保存")
//    @Transactional(rollbackFor = {Exception.class})
//    public R save(@RequestBody OnlineMonitorDaydataEntity onlineMonitorDaydata){
//        ValidatorUtils.validateEntity(onlineMonitorDaydata, AddGroup.class);
//        onlineMonitorDaydata.setCreatedate(DateUtils.getDate());
//        onlineMonitorDaydataService.insert(onlineMonitorDaydata);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @PutMapping
//    @ApiOperation("修改")
//    @Transactional(rollbackFor = {Exception.class})
//    public R update(@RequestBody OnlineMonitorDaydataEntity onlineMonitorDaydata){
//        ValidatorUtils.validateEntity(onlineMonitorDaydata, UpdateGroup.class);
//        onlineMonitorDaydataService.updateById(onlineMonitorDaydata);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @DeleteMapping
//    @ApiOperation("删除")
//    @Transactional(rollbackFor = {Exception.class})
//    public R delete(@RequestBody String[] pids){
//        onlineMonitorDaydataService.deleteBatchIds(Arrays.asList(pids));
//
//        return R.ok();
//    }
    /**
     * 在线监控统计-图表统计
     */
    @GetMapping("/onlineMonitoring/{year}/{currentYear}/{type}/{fid}/{currentmonth}/{currentlastmonth}")
    @ApiOperation("在线监控统计-图表统计")
    public R onlineMonitoring(@PathVariable("year") String year,
                              @PathVariable("currentYear") String currentYear,
                              @PathVariable("type") String type,
                              @PathVariable("fid") String fid,
                              @PathVariable("currentmonth") String currentmonth,
                              @PathVariable("currentlastmonth") String currentlastmonth){

        //在线监控统计-监控企业、重点监控、水监控、气监控、voc监控
        List<Map<String,Object>> list= onlineMonitorDaydataService.onlineMonitoring();
        //在线监控统计-月排放量统计
        Object [] monthContainer = onlineMonitorDaydataService.monthlyEmissionStatistics(year,type,fid);
        //在线监控统计-本年排放量与去年对比
        Double [] yearContainer = onlineMonitorDaydataService.yearAndLastyearContrastByEmissions(year,type,fid);
        //在线监控统计-排放量排行榜
        Map<String, Object> map2 = onlineMonitorDaydataService.emissionRanking(year,type,fid);
        //在线监控统计-废水实时排放情况
        Map<String, Object> map1 = onlineMonitorDaydataService.RealtimeEmissions(currentYear,currentmonth,currentlastmonth);
        return  R.ok().put("data", list)
                .put("monthContainer",monthContainer)
                .put("yearContainer",yearContainer)
                .put("wasteWater",map1.get("B01"))
                .put("COD",map1.get("011"))
                .put("ammoniaNitrogen",map1.get("060"))
                .put("monthTheEmissions",map1.get("monthsum"))
                .put("lastmonthTheEmissions",map1.get("lastmonthsum"))
                .put("names",map2.get("name"))
                .put("values",map2.get("value"));
    }
    /**
     *  在线监控统计-根据统计类型联动获取该类型的污染因子
     */
    @GetMapping("/selFactorByStatisticalType/{type}")
    @ApiOperation("在线监控统计-根据统计类型联动获取该类型的污染因子")
    public R selFactorByStatisticalType(@PathVariable("type") String type){
        List<OnlineMonitorFactorEntity> list= onlineMonitorDaydataService.selFactorByStatisticalType(type);
        return  R.ok().put("data", list);
    }
    /**
     * 在线监控企业列表查询
     */
    @GetMapping("/onlineMonitoringEnterpriseList")
    @ApiOperation("列表")
    public String onlineMonitoringEnterpriseList(@RequestParam Map<String, Object> params){
        PageUtils page = onlineMonitorDaydataService.onlineMonitoringEnterpriseList(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }
}

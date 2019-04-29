package com.tengdi.environmentalprotectionint.modules.online.controller;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.common.utils.Utils;
import com.tengdi.environmentalprotectionint.modules.online.entity.*;
import com.tengdi.environmentalprotectionint.modules.online.service.*;
import com.tengdi.core.utils.*;

import java.util.*;

import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 小时数据表
 *
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:51:50
 */
@RestController
@RequestMapping("online/onlinemonitorhourdata")
@Api(tags="小时数据表")
public class OnlineMonitorHourdataController extends BaseController{
    @Autowired
    private OnlineMonitorHourdataService onlineMonitorHourdataService;
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
//        PageUtils page = onlineMonitorHourdataService.queryPage(params);
//
//        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
//    }
//
//    /**
//     * list
//     */
//    @GetMapping("/queryList")
//    @ApiOperation("list")
//    public String queryList(@RequestParam Map<String, Object> params){
//        List<OnlineMonitorHourdataEntity> list=onlineMonitorHourdataService.queryList(params);
//
//        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
//    }

    /**
     * 在线监控小时数据
     */
    @PostMapping("/testData")
    @ApiOperation("在线监控小时数据")
    public R testData(QueryCriterias criterias){
        Map<String,Object> map=new HashMap<>();
        if(criterias.getLikeColumns()!=null){
            for(int i=0;i<criterias.getLikeColumns().size();i++){
                map.putAll(criterias.getLikeColumns().get(i));
            }
        }
        List<double[]> testDataList=new ArrayList<>();
        List<String> nameList=new ArrayList<>();
        List<Integer> isEnvironmentFactorList=new ArrayList<>();
        String mid=(String)map.get("mid");
        String cid=(String) map.get("cid");
//        String startDate=(String)map.get("startDate");
//        String endDate=(String)map.get("endDate");
//        map.put("startDate",Utils.dateFormat(startDate));
//        map.put("endDate",Utils.dateFormat(endDate));
        List<String> factorList=criterias.getFactorList();//因子id的list
        if(mid!=null){
            //从表名检索表得出日数据表名和小时数据表名
            OnlineTableRetrieveEntity retrieveEntity=onlineTableRetrieveService.dataByCid(map);
            if(retrieveEntity!=null) {
                map.put("tableName", retrieveEntity.getHdTabName());
                boolean flag=true;
                if (factorList == null || factorList.get(0).equals("[]")) {
                    flag=false;
                    factorList=new ArrayList<>();
                    List<OnlineMonitorPointFactorEntity> factorEntityList = onlineMonitorPointFactorService.dataByMid(mid);
                    for(int i=0;i<factorEntityList.size();i++){
                        factorList.add(factorEntityList.get(i).getFid());
                    }
                }

                for (int i = 0; i < factorList.size(); i++) {//根据每个因子id查出因子表数据
                    String factor = factorList.get(i);
                    if(flag){
                        factor = factor.substring(factor.indexOf('"') + 1, factor.lastIndexOf('"'));
                    }
                    OnlineMonitorFactorEntity monitorFactorEntity = onlineMonitorFactorService.selectByMap(new MapUtils().put("factor_code",factor)).get(0);
                    nameList.add(monitorFactorEntity.getFactorName());
                    map.put("fid", factor);
                    //因子id和排口id查出所属小时数据
                    List<OnlineMonitorHourdataEntity> list = onlineMonitorHourdataService.queryList(map);
                    StringBuffer str = new StringBuffer();
                    if(Arrays.asList(FactorStr).contains(factor)){
                        isEnvironmentFactorList.add(0);
                        for (OnlineMonitorHourdataEntity entity : list) {
                            str.append(entity.getCouValue() + ",");
                        }
                    }else{
                        isEnvironmentFactorList.add(1);
                        for (OnlineMonitorHourdataEntity entity : list) {
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

        return R.ok().put("testData",testDataList).put("names",nameList).put("isEnvironmentFactorList",isEnvironmentFactorList);
    }

//    /**
//     * 信息
//     */
//    @GetMapping("/{pid}")
//    @ApiOperation("信息")
//    public R info(@PathVariable("pid") String pid){
//        OnlineMonitorHourdataEntity onlineMonitorHourdata = onlineMonitorHourdataService.selectById(pid);
//
//        return R.ok().put("onlineMonitorHourdata", onlineMonitorHourdata);
//    }
//
//    /**
//     * 保存
//     */
//    @PostMapping
//    @ApiOperation("保存")
//    @Transactional(rollbackFor = {Exception.class})
//    public R save(@RequestBody OnlineMonitorHourdataEntity onlineMonitorHourdata){
//        ValidatorUtils.validateEntity(onlineMonitorHourdata, AddGroup.class);
//        onlineMonitorHourdata.setCreatedate(DateUtils.getDate());
//        onlineMonitorHourdataService.insert(onlineMonitorHourdata);
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
//    public R update(@RequestBody OnlineMonitorHourdataEntity onlineMonitorHourdata){
//        ValidatorUtils.validateEntity(onlineMonitorHourdata, UpdateGroup.class);
//        onlineMonitorHourdataService.updateById(onlineMonitorHourdata);
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
//        onlineMonitorHourdataService.deleteBatchIds(Arrays.asList(pids));
//
//        return R.ok();
//    }

}

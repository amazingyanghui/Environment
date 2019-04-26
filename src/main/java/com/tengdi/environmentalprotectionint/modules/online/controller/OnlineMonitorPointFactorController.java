package com.tengdi.environmentalprotectionint.modules.online.controller;

import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorFactorEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPointFactorEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorPointFactorService;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorFactorService;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tengdi.userauthenuuid.common.annotation.SysLog;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 监控点监控因子信息表
 *
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:52:16
 */
@RestController
@RequestMapping("online/onlinemonitorpointfactor")
@Api(tags="监控点监控因子信息表")
public class OnlineMonitorPointFactorController extends BaseController{
    @Autowired
    private OnlineMonitorPointFactorService onlineMonitorPointFactorService;

    @Autowired
    private OnlineMonitorFactorService  onlineMonitorFactorService ;


    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = onlineMonitorPointFactorService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        OnlineMonitorPointFactorEntity onlineMonitorPointFactor = onlineMonitorPointFactorService.selectById(pid);

        return R.ok().put("onlineMonitorPointFactor", onlineMonitorPointFactor);
    }

    /**
     * 信息
     */
    @GetMapping("/dataByFid/{fid}/{mid}")
    @ApiOperation("信息")
    public R dataByFid(@PathVariable("fid") String fid,@PathVariable("mid") String mid){
        Map<String,Object> map=new HashMap<>();
        map.put("fid",fid);
        map.put("mid",mid);
        OnlineMonitorPointFactorEntity onlineMonitorPointFactor = onlineMonitorPointFactorService.dataByFid(map);

        return R.ok().put("onlineMonitorPointFactor", onlineMonitorPointFactor);
    }

    /**
     * 信息
     */
    @GetMapping("/dataByMid/{mid}")
    @ApiOperation("信息")
    public R dataByMid(@PathVariable("mid") String mid){

        List<OnlineMonitorPointFactorEntity> factorList = onlineMonitorPointFactorService.dataByMid(mid);

        return R.ok().put("factorList", factorList);
    }

    /**
     * 保存监控点监控因子信息表
     */
    @PostMapping
    @ApiOperation("保存监控点监控因子信息表")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "保存监控点监控因子信息表")
    public R save(@RequestBody OnlineMonitorPointFactorEntity onlineMonitorPointFactor){
        ValidatorUtils.validateEntity(onlineMonitorPointFactor, AddGroup.class);
        onlineMonitorPointFactorService.insert(onlineMonitorPointFactor);

        return R.ok();
    }

    /**
     * 修改监控点监控因子信息表
     */
    @PutMapping
    @ApiOperation("修改监控点监控因子信息表")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改监控点监控因子信息表")
    public R update(@RequestBody OnlineMonitorPointFactorEntity onlineMonitorPointFactor){
        ValidatorUtils.validateEntity(onlineMonitorPointFactor, UpdateGroup.class);
        onlineMonitorPointFactorService.updateById(onlineMonitorPointFactor);

        return R.ok();
    }

    /**
     * 删除监控点监控因子信息表
     */
    @DeleteMapping
    @ApiOperation("删除监控点监控因子信息表")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "删除监控点监控因子信息表")
    public R delete(@RequestBody String[] pids){
        onlineMonitorPointFactorService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

    /**
     * 企业排口监测统计数据
     */
    @GetMapping("/baseInfoStatic/{pid}")
    @ApiOperation("排口数量查询查询")
    public R baseStaticinfo(@PathVariable("pid") String pid){
        R r = new R();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArr = new JSONArray();
        jsonArr = onlineMonitorPointFactorService.drainsBaseInfo(pid);
        return r.put("data",jsonArr);
    }

    /**
     *  查询某类型对应所有排口
     */
    @GetMapping("/drainsByType/{pid}/{type}")
    @ApiOperation("本年度执法类型统计")
    public R selFactorByStatisticalType(@PathVariable("pid") String pid, @PathVariable("type") String type){
        Map<String,Object> map=new HashMap<>();
        map.put("pid",pid);
        map.put("type",type);
       List<OnlineMonitorPointFactorEntity> list= onlineMonitorPointFactorService.queryDrains(map);
        return  R.ok().put("data", list);
    }

    /**
     *因子每月排放统计数据（单个排口）
     */
    @GetMapping("/monthDrainsFactor/{tableName}/{year}/{fid}")
    @ApiOperation("某因子每月的排放统计")
    public R monthDrainsFactor(@PathVariable("tableName") String tableName, @PathVariable("year") String year, @PathVariable("fid") String fid){
        Map<String,Object> map=new HashMap<>();
        map.put("tableName",tableName);
        map.put("year",year);
        map.put("fid",fid);
        List<OnlineMonitorPointFactorEntity> list= onlineMonitorPointFactorService.monthDrainsFactor(map);
        return  R.ok().put("data", list);
    }
    /**
     *因子每月排放统计数据（所有排口）
     */
    @GetMapping("/monthAllDrainsFactor/{type}/{year}/{fid}/{cid}")
    @ApiOperation("某因子每月的排放统计")
    public R monthAllDrainsFactor(@PathVariable("type") String type, @PathVariable("year") String year, @PathVariable("fid") String fid, @PathVariable("cid") String cid){
        Map<String,Object> map=new HashMap<>();
        map.put("type",type);
        map.put("year",year);
        map.put("fid",fid);
        map.put("cid",cid);
       List<OnlineMonitorPointFactorEntity> list= onlineMonitorPointFactorService.monthDrainsFactor(map);
        return  R.ok().put("data", list);
    }
    /**
     * 因子年度统计sql（某个排口）
     */
    @GetMapping("/yearDrainsFactor/{tableName}/{year}/{fid}")
    @ApiOperation("某因子每月的排放统计")
    public R yearDrainsFactor(@PathVariable("tableName") String tableName, @PathVariable("year") String year, @PathVariable("fid") String fid){
        Map<String,Object> map=new HashMap<>();
        map.put("tableName",tableName);
        map.put("year",year);
        map.put("fid",fid);
        List<OnlineMonitorPointFactorEntity> list= onlineMonitorPointFactorService.yearDrainsFactor(map);
        return  R.ok().put("data", list);
    }
    /**
     * 因子年度统计（所有排口）
     */
    @GetMapping("/yearAllDrainsFactor/{type}/{year}/{fid}/{cid}")
    @ApiOperation("某因子每月的排放统计")
    public R yearAllDrainsFactor(@PathVariable("type") String type, @PathVariable("year") String year, @PathVariable("fid") String fid, @PathVariable("cid") String cid){
        Map<String,Object> map=new HashMap<>();
        map.put("type",type);
        map.put("year",year);
        map.put("fid",fid);
        map.put("cid",cid);
        List<OnlineMonitorPointFactorEntity> list= onlineMonitorPointFactorService.yearDrainsFactor(map);
        return  R.ok().put("data", list);
    }

    /**
     * 因子浓度每月排放（某个排口）
     */
    @GetMapping("/monthDrainsFactorPotency/{tableName}/{year}/{fid}")
    @ApiOperation("某因子每月的排放统计")
    public R monthDrainsFactorPotency(@PathVariable("tableName") String tableName, @PathVariable("year") String year, @PathVariable("fid") String fid){
        Map<String,Object> map=new HashMap<>();
        map.put("tableName",tableName);
        map.put("year",year);
        map.put("fid",fid);
        List<OnlineMonitorPointFactorEntity> list= onlineMonitorPointFactorService.monthDrainsFactorPotency(map);
        return  R.ok().put("data", list);
    }

    /**
     * 因子浓度每月排放（所有排口）
     */
    @GetMapping("/monthAllDrainsFactorPotency/{type}/{year}/{fid}/{cid}")
    @ApiOperation("某因子每月的排放统计")
    public R monthAllDrainsFactorPotency(@PathVariable("type") String type, @PathVariable("year") String year, @PathVariable("fid") String fid, @PathVariable("cid") String cid){
        Map<String,Object> map=new HashMap<>();
        map.put("type",type);
        map.put("year",year);
        map.put("fid",fid);
        map.put("cid",cid);
        List<OnlineMonitorPointFactorEntity> list= onlineMonitorPointFactorService.monthDrainsFactorPotency(map);
        return  R.ok().put("data", list);
    }

    /**
     *  在线监控统计-根据统计类型联动获取该类型的污染因子
     */
    @GetMapping("/selFactorByStatisticalType/{type}")
    @ApiOperation("本年度执法类型统计")
    public R selFactorByStatisticalType(@PathVariable("type") String type){
        List<OnlineMonitorFactorEntity> list= onlineMonitorFactorService.selFactorByStatisticalType(type);
        return  R.ok().put("data", list);
    }

    /**
     *根据选择排口查询对应下面的因子
     */
    @GetMapping("/selFactorByPort/{tableName}/{type}")
    @ApiOperation("本年度执法类型统计")
    public R queryFactorByPort(@PathVariable("tableName") String tableName,@PathVariable("type") String type){
        Map<String,Object> map=new HashMap<>();
        map.put("tableName",tableName);
        map.put("type",type);
       List<OnlineMonitorFactorEntity> list= onlineMonitorFactorService.queryFactorByPort(map);
        return  R.ok().put("data", list);
    }

    /**
     * 排放量排行榜
     */
    @GetMapping("/selFactorByStatisticalFactoRanking/{cid}/{year}/{type}/{fid}")
    @ApiOperation("本年度执法类型统计")
    public R rankingStatistical(@PathVariable("cid") String cid,@PathVariable("year") String year,@PathVariable("type") String type,@PathVariable("fid") String fid){
        Map<String,Object> map=new HashMap<>();
        JSONArray json = new JSONArray();
        map.put("cid",cid);
        map.put("year",year);
        map.put("type",type);
        map.put("fid",fid);
         json = onlineMonitorPointFactorService.selFactorByRanking(map);

        return  R.ok().put("data",json);
    }


}

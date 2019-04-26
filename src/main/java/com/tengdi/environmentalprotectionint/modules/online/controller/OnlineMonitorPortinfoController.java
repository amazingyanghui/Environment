package com.tengdi.environmentalprotectionint.modules.online.controller;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoEnvironmentalManageEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoEnvironmentalManageService;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPortinfoEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineTableRetrieveEntity;
import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorPointFactorService;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorPortinfoService;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineTableRetrieveService;
import com.tengdi.core.utils.*;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.tengdi.environmentalprotectionint.modules.permit.entity.PollutantDischargePermitEntity;
import com.tengdi.environmentalprotectionint.modules.permit.service.PollutantDischargePermitService;
import com.tengdi.userauthenuuid.common.annotation.SysLog;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysDictService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 监控点信息表
 *
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:52:11
 */
@RestController
@RequestMapping("online/onlinemonitorportinfo")
@Api(tags="监控点信息表")
public class OnlineMonitorPortinfoController extends BaseController{
    @Autowired
    private OnlineMonitorPortinfoService onlineMonitorPortinfoService;
    @Autowired
    private OnlineTableRetrieveService onlineTableRetrieveService;
    @Autowired
    private CominfoEnvironmentalManageService cominfoEnvironmentalManageService;
    @Autowired
    private OnlineMonitorPointFactorService onlineMonitorPointFactorService;
    @Autowired
    private SysDictService sysDictService;
    @Autowired
    private PollutantDischargePermitService pollutantDischargePermitService;
    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = onlineMonitorPortinfoService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 监控点下拉框
     */
    @GetMapping("/selectList/{cid}")
    @ApiOperation("监控点下拉框")
    public String selectList(@PathVariable("cid") String cid){
        List<SelectEntity> list = onlineMonitorPortinfoService.list(cid);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 根据公司id获取监控点信息表(monitorType:监控点类型(0：废水排放情况；1：废气排放情况；2：VOCs排放情况))
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取监控点信息表(monitorType:监控点类型(0：废水排放情况；1：废气排放情况；2：VOCs排放情况))")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<OnlineMonitorPortinfoEntity> list = onlineMonitorPortinfoService.dataById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 监控点下拉框
     */
    @GetMapping("/selectList/{cid}/{type}")
    @ApiOperation("监控点下拉框")
    public String selectList(@PathVariable("cid") String cid,@PathVariable("type")Integer type){
        List<SelectEntity> list = onlineMonitorPortinfoService.list(cid,type);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        OnlineMonitorPortinfoEntity onlineMonitorPortinfo = onlineMonitorPortinfoService.selectById(pid);
        if(onlineMonitorPortinfo!=null){
            if(onlineMonitorPortinfo.getMonitorUseflag()!=null){
                List<SysDictEntity> monitorUseflagList=sysDictService.selectByMap(new MapUtils().put("`key`", onlineMonitorPortinfo.getMonitorUseflag()).put("type","boolean_type"));
                if(monitorUseflagList.size()>0){
                    onlineMonitorPortinfo.setMonitorUseFlagName(monitorUseflagList.get(0).getValue());
                }
            }
            if(onlineMonitorPortinfo.getEmissionMode()!=null){
                List<SysDictEntity> emissionModeList=sysDictService.selectByMap(new MapUtils().put("`key`", onlineMonitorPortinfo.getEmissionMode()).put("type","emission_mode_type"));
                if(emissionModeList.size()>0){
                    onlineMonitorPortinfo.setEmissionModeName(emissionModeList.get(0).getValue());
                }
            }
            if(onlineMonitorPortinfo.getEmissionType()!=null){
                List<SysDictEntity> emissionTypeList=sysDictService.selectByMap(new MapUtils().put("`key`", onlineMonitorPortinfo.getEmissionType()).put("type","emission_type_type"));
                if(emissionTypeList.size()>0){
                    onlineMonitorPortinfo.setEmissionTypeName(emissionTypeList.get(0).getValue());
                }
            }
        }
        return R.ok().put("onlineMonitorPortinfo", onlineMonitorPortinfo);
    }

    /**
     * 保存排放情况
     */
    @PostMapping
    @ApiOperation("保存排放情况")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "保存排放情况")
    public R save(@RequestBody OnlineMonitorPortinfoEntity onlineMonitorPortinfo){
        ValidatorUtils.validateEntity(onlineMonitorPortinfo, AddGroup.class);
        onlineMonitorPortinfo.setCreatedate(DateUtils.getDate());
        onlineMonitorPortinfo.setUpdatedate(DateUtils.getDate());
        Integer monitorType=onlineMonitorPortinfo.getMonitorType();
        CominfoEnvironmentalManageEntity manageEntity=cominfoEnvironmentalManageService.dataById(onlineMonitorPortinfo.getCid());
        if(monitorType==0){
            if(manageEntity!=null){
                manageEntity.setWasteWater(1);
                manageEntity.setOnlineMonitoring(1);
                cominfoEnvironmentalManageService.updateById(manageEntity);
            }else{
                manageEntity=new CominfoEnvironmentalManageEntity();
                manageEntity.setWasteWater(1);
                manageEntity.setOnlineMonitoring(1);
                manageEntity.setCid(onlineMonitorPortinfo.getCid());
                cominfoEnvironmentalManageService.insert(manageEntity);
            }
        }
        if(monitorType==1){
            if(manageEntity!=null){
                manageEntity.setEmissionEnterprises(1);
                manageEntity.setOnlineMonitoring(1);
                cominfoEnvironmentalManageService.updateById(manageEntity);
            }else{
                manageEntity=new CominfoEnvironmentalManageEntity();
                manageEntity.setEmissionEnterprises(1);
                manageEntity.setOnlineMonitoring(1);
                manageEntity.setCid(onlineMonitorPortinfo.getCid());
                cominfoEnvironmentalManageService.insert(manageEntity);
            }
        }
        if(monitorType==2){
            if(manageEntity!=null){
                manageEntity.setVocEnterprises(1);
                manageEntity.setOnlineMonitoring(1);
                cominfoEnvironmentalManageService.updateById(manageEntity);
            }else{
                manageEntity=new CominfoEnvironmentalManageEntity();
                manageEntity.setVocEnterprises(1);
                manageEntity.setOnlineMonitoring(1);
                manageEntity.setCid(onlineMonitorPortinfo.getCid());
                cominfoEnvironmentalManageService.insert(manageEntity);
            }
        }

        //噪声污染
        if(monitorType==5){
            if(manageEntity!=null){
                manageEntity.setVocEnterprises(1);
                manageEntity.setOnlineMonitoring(1);
                cominfoEnvironmentalManageService.updateById(manageEntity);
            }else{
                manageEntity=new CominfoEnvironmentalManageEntity();
                manageEntity.setVocEnterprises(1);
                manageEntity.setOnlineMonitoring(1);
                manageEntity.setCid(onlineMonitorPortinfo.getCid());
                cominfoEnvironmentalManageService.insert(manageEntity);
            }

        }
        String pid=onlineMonitorPortinfoService.idByInsert(onlineMonitorPortinfo);
        String tableDateName="dd_"+pid;
//        String tableHourName="hd_"+pid;
        onlineMonitorPortinfoService.createDateTable(tableDateName);
//        onlineMonitorPortinfoService.createHourTable(tableHourName);
        OnlineTableRetrieveEntity entity=new OnlineTableRetrieveEntity();
        entity.setDdTabName(tableDateName);
//        entity.setHdTabName(tableHourName);
        entity.setMid(pid);
        entity.setCid(onlineMonitorPortinfo.getCid());
        onlineTableRetrieveService.insert(entity);
        return R.ok();
    }

    /**
     * 修改排放情况
     */
    @PutMapping
    @ApiOperation("修改排放情况")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改排放情况")
    public R update(@RequestBody OnlineMonitorPortinfoEntity onlineMonitorPortinfo){
        ValidatorUtils.validateEntity(onlineMonitorPortinfo, UpdateGroup.class);
        onlineMonitorPortinfo.setUpdatedate(DateUtils.getDate());
        onlineMonitorPortinfoService.updateById(onlineMonitorPortinfo);

        return R.ok();
    }

    /**
     * 批量修改排放情况
     */
    @PutMapping("/updateList")
    @ApiOperation("批量修改排放情况")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "批量修改排放情况")
    public R updateList(@RequestBody List<OnlineMonitorPortinfoEntity> list){
        for(OnlineMonitorPortinfoEntity onlineMonitorPortinfo:list){
            ValidatorUtils.validateEntity(onlineMonitorPortinfo, UpdateGroup.class);
            onlineMonitorPortinfo.setUpdatedate(DateUtils.getDate());
            onlineMonitorPortinfoService.updateById(onlineMonitorPortinfo);
        }
        return R.ok();
    }

    /**
     * 删除排放情况
     */
    @DeleteMapping
    @ApiOperation("删除排放情况")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "删除排放情况")
    public R delete(@RequestBody String[] pids){
        onlineMonitorPortinfoService.deleteBatchIds(Arrays.asList(pids));
        List<String> list=Arrays.asList(pids);
        for(String pid:list){
            OnlineTableRetrieveEntity entity=onlineTableRetrieveService.dataById(pid);
            if(entity!=null){
                onlineMonitorPortinfoService.dropDateTable(entity.getDdTabName());
//                onlineMonitorPortinfoService.dropHourTable(entity.getHdTabName());
                onlineTableRetrieveService.deleteById(entity.getPid());
                onlineMonitorPointFactorService.deleteByMap(new MapUtils().put("mid",pid));
            }
        }
        return R.ok();
    }

    /**
     * 查询排污许可证编号
     */
    @GetMapping("/permCodeList/{cid}")
    @ApiOperation("监控点下拉框")
    public String permCodeList(@PathVariable("cid") String cid){
        List<SelectEntity> list = pollutantDischargePermitService.list(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

//
//    /**
//     * 根据公司id获取排污许可证
//     */
//    @GetMapping("/dataById/{cid}")
//    @ApiOperation("根据公司id获取排污许可证")
//    public String selectByCid(@PathVariable("cid") String cid){
//        List<PollutantDischargePermitEntity> list = pollutantDischargePermitService.list(cid);
//        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
//    }

    /**
     * 根据公司id获取监控点信息表(monitorType:监控点类型(0：废水排放情况；1：废气排放情况；2：VOCs排放情况;5噪声情况))
     */
    @GetMapping("/noiseBaseInfoById/{cid}")
    @ApiOperation("根据公司id获取监控点信息表(monitorType:监控点类型(0：废水排放情况；1：废气排放情况；2：VOCs排放情况;5:噪声排放情况))")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String noiseBaseInfoById(@PathVariable("cid") String cid){
        List<OnlineMonitorPortinfoEntity> list = onlineMonitorPortinfoService.noiseBaseInfoById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 批量修改排放情况
     */
    @PutMapping("/updateNoiseList")
    @ApiOperation("批量修改噪声基础信息")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "批量修改噪声基础信息")
    public R updateNoiseList(@RequestBody List<OnlineMonitorPortinfoEntity> list){
        for(OnlineMonitorPortinfoEntity onlineMonitorPortinfo:list){
            ValidatorUtils.validateEntity(onlineMonitorPortinfo, UpdateGroup.class);
            onlineMonitorPortinfo.setUpdatedate(DateUtils.getDate());
            onlineMonitorPortinfoService.updateById(onlineMonitorPortinfo);
        }
        return R.ok();
    }


}

package com.tengdi.environmentalprotectionint.modules.map.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoEnvironmentalManageEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoBaseinfoService;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoEnvironmentalManageService;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPortinfoEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorPortinfoService;
import com.tengdi.core.utils.*;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 地图相关接口
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:40
 */
@RestController
@RequestMapping("map")
@Api(tags="地图相关接口")
public class MapController extends BaseController{
    @Autowired
    private CominfoBaseinfoService cominfoBaseinfoService;
    @Autowired
    private CominfoEnvironmentalManageService cominfoEnvironmentalManageService;
    @Autowired
    private OnlineMonitorPortinfoService onlineMonitorPortinfoService;
    @Autowired
    private SysDictService sysDictService;
    /**
     * 按条件查询企业坐标
     */
    @GetMapping("/queryCominfoList")
    @ApiOperation("按条件查询企业坐标")
    public String queryCominfoList(@RequestParam Map<String, Object> params){
        List<CominfoBaseinfoEntity> list = cominfoBaseinfoService.queryList(params);

        return  LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 按条件查询监控口信息（坐标）
     */
    @GetMapping("/getMonitorInfo")
    @ApiOperation("按条件查询监控口信息（坐标）")
    public String getMonitorInfo(@RequestParam Map<String, Object> params){
        List<OnlineMonitorPortinfoEntity> list = onlineMonitorPortinfoService.queryList(params);

        return  LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 根据监控点ID获取企业信息
     */
    @GetMapping("/getCompanyInfoByMonitorId/{pid}")
    @ApiOperation("根据监控点ID获取企业信息")
    public R info(@PathVariable("pid") String pid){
        OnlineMonitorPortinfoEntity onlineMonitorPortinfo = onlineMonitorPortinfoService.selectById(pid);
        CominfoBaseinfoEntity cominfoBaseinfo = cominfoBaseinfoService.selectById(onlineMonitorPortinfo.getCid());
        CominfoEnvironmentalManageEntity cominfoEnvironmentalManage = cominfoEnvironmentalManageService.selectOne(new EntityWrapper<CominfoEnvironmentalManageEntity>()
                .like(true,"cid", onlineMonitorPortinfo.getCid()));
        onlineMonitorPortinfo.setCompanyName(cominfoBaseinfo.getCompanyName());
        onlineMonitorPortinfo.setCompanyAddress(cominfoBaseinfo.getCompanyAddress());
        onlineMonitorPortinfo.setEnvironmentalProtectionName(cominfoBaseinfo.getEnvironmentalProtectionName());
        onlineMonitorPortinfo.setEnvironmentalProtectionPhone(cominfoBaseinfo.getEnvironmentalProtectionPhone());
        onlineMonitorPortinfo.setLocalCity("南京市");//临时
        SysDictEntity entity = new SysDictEntity();
        entity.setKey(cominfoEnvironmentalManage.getRegulatoryLevel());
        entity.setType("regulatory_level_type");
        String regulatoryLevel = sysDictService.getDictValue(entity);
        onlineMonitorPortinfo.setRegulatoryLevel(regulatoryLevel);
        return R.ok().put("onlineMonitorPortinfo", onlineMonitorPortinfo);
    }

    /**
     * 查询风险源坐标
     */
    @GetMapping("/getRiskSourceList")
    @ApiOperation("查询风险源坐标")
    public String getRiskSourceList(@RequestParam Map<String, Object> params){
        List<CominfoBaseinfoEntity> list = cominfoBaseinfoService.getRiskSourceList(params);

        return  LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 企业监管级别统计
     */
    @GetMapping("/totalCompanyLevel")
    @ApiOperation("企业监管级别统计")
    public String totalCompanyLevel(@RequestParam Map<String, Object> params){
        List<Map<String,Object>> list = cominfoBaseinfoService.totalCompanyLevel(params);

        return  LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 查询涉危企业坐标
     */
    @GetMapping("/getDangerSourceList")
    @ApiOperation("查询涉危企业坐标")
    public String getDangerSourceList(@RequestParam Map<String, Object> params){
        List<CominfoBaseinfoEntity> list = cominfoBaseinfoService.getDangerSourceList(params);

        return  LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 查询涉放射性企业坐标
     */
    @GetMapping("/getIsotopeSourceList")
    @ApiOperation("查询涉放射性企业坐标")
    public String getIsotopeSourceList(@RequestParam Map<String, Object> params){
        List<CominfoBaseinfoEntity> list = cominfoBaseinfoService.getIsotopeSourceList(params);

        return  LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }


}

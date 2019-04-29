package com.tengdi.environmentalprotectionint.modules.permit.controller;

import com.tengdi.environmentalprotectionint.modules.permit.entity.PollutantDischargePermitAndBaseInfoEntity;
import com.tengdi.environmentalprotectionint.modules.permit.entity.PollutantDischargePermitEntity;
import com.tengdi.environmentalprotectionint.modules.permit.service.PollutantDischargePermitService;
import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.tengdi.userauthenuuid.common.annotation.SysLog;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
 * 排污许可证
 *
 * @author tengdi
 * @email 
 * @date 2018-09-10 15:38:35
 */
@RestController
@RequestMapping("permit/pollutantdischargepermit")
@Api(tags="排污许可证")
public class PollutantDischargePermitController extends BaseController{
    @Autowired
    private PollutantDischargePermitService pollutantDischargePermitService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = pollutantDischargePermitService.queryPageSql(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<PollutantDischargePermitEntity> list= pollutantDischargePermitService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/queryName")
    @ApiOperation("列表")
    public String queryName(@RequestParam Map<String, Object> params){
        List<PollutantDischargePermitEntity> list= pollutantDischargePermitService.queryName(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        PollutantDischargePermitEntity pollutantDischargePermit = pollutantDischargePermitService.selectById(pid);

        return R.ok().put("pollutantDischargePermit", pollutantDischargePermit);
    }

    /**
     * 根据公司id获取排污许可证
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取排污许可证")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<PollutantDischargePermitEntity> list = pollutantDischargePermitService.dataById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 根据公司id获取环保税信息采集表
     */
    @GetMapping("/baseInfoById/{cid}")
    @ApiOperation("根据公司id获取环保税信息采集表")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public R baseInfoById(@PathVariable("cid") String cid){
        PollutantDischargePermitAndBaseInfoEntity entity = pollutantDischargePermitService.getBaseInfoForEnvironment(cid);
        return R.ok().put("entity",entity);
    }

    /**
     * 修改环保税信息采集表
     */
    @PutMapping("/updateEnvironment")
    @ApiOperation("修改环保税信息采集表")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改环保税信息采集表")
    public R updateEnvironment(@RequestBody PollutantDischargePermitAndBaseInfoEntity entity){
        pollutantDischargePermitService.updateEnvironmentInfo(entity);
        return R.ok();
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody PollutantDischargePermitEntity pollutantDischargePermit){
        ValidatorUtils.validateEntity(pollutantDischargePermit, AddGroup.class);
        pollutantDischargePermit.setCreatedate(DateUtils.getDate());
        pollutantDischargePermitService.insert(pollutantDischargePermit);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody PollutantDischargePermitEntity pollutantDischargePermit){
        ValidatorUtils.validateEntity(pollutantDischargePermit, UpdateGroup.class);
        pollutantDischargePermit.setUpdatedate(DateUtils.getDate());
        pollutantDischargePermitService.updateById(pollutantDischargePermit);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        pollutantDischargePermitService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }


    /**
     * 统计接口:
     * 1)本年度发放排污许可证，2)累计发放排污许可证 ,3)本年度发放正式排污许可证 ,4)本年度发放临时排污许可证
     */
    @GetMapping("basespermitstatic/{year}")
    @ApiOperation("排污许可证基本信息查询")
    public R baseStaticinfo(@PathVariable("year") String year){
        R r = new R();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArr = pollutantDischargePermitService.basestaticcount(year);
        return r.put("data",jsonArr);
    }

    /**
     * 统计接口:
     * 1) 各月排污许可证发放数量统计
     */
    @GetMapping("monthpermittatic/{year}")
    @ApiOperation("排污许可证每月数量统计")
    public R monthStaticinfo(@PathVariable("year") String year){
        R r = new R();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArr = pollutantDischargePermitService.monthstaticcount(year);
        return r.put("data",jsonArr);
    }

    /**
     * 统计接口：
     * 本年度各行业的排污许可证统计
     */
    @GetMapping("industrypermittatic/{year}")
    @ApiOperation("本年度各行业排污许可证数量及所在比例查询")
    public R industryStaticinfo(@PathVariable("year") String year){
        R r = new R();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArr = pollutantDischargePermitService.industrystaticcount(year);
        return r.put("data",jsonArr);
    }
}

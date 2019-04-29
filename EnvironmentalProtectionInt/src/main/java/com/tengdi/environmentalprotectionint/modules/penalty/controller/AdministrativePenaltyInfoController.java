package com.tengdi.environmentalprotectionint.modules.penalty.controller;

import com.tengdi.core.utils.DateUtils;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.penalty.entity.AdministrativePenaltyInfoEntity;
import com.tengdi.environmentalprotectionint.modules.penalty.service.AdministrativePenaltyInfoService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 处罚情况
 *
 * @author tengdi
 * @email 
 * @date 2018-08-23 09:24:41
 */
@RestController
@RequestMapping("penalty/administrativepenaltyinfo")
@Api(tags="处罚情况")
public class AdministrativePenaltyInfoController extends BaseController{
    @Autowired
    private AdministrativePenaltyInfoService administrativePenaltyInfoService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = administrativePenaltyInfoService.queryPageSql(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<AdministrativePenaltyInfoEntity> list= administrativePenaltyInfoService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/queryName")
    @ApiOperation("列表")
    public String queryName(@RequestParam Map<String, Object> params){
        List<AdministrativePenaltyInfoEntity> list= administrativePenaltyInfoService.queryName(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        AdministrativePenaltyInfoEntity administrativePenaltyInfo = administrativePenaltyInfoService.entityById(pid);

        return R.ok().put("administrativePenaltyInfo", administrativePenaltyInfo);
    }

    /**
     * 根据公司id获取行政处罚情况
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取行政处罚情况")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<AdministrativePenaltyInfoEntity> list = administrativePenaltyInfoService.dataById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody AdministrativePenaltyInfoEntity administrativePenaltyInfo){
        ValidatorUtils.validateEntity(administrativePenaltyInfo, AddGroup.class);
        administrativePenaltyInfo.setCreatedate(DateUtils.getDate());
        String pid=administrativePenaltyInfoService.insertData(administrativePenaltyInfo);

        return R.ok().put("pid",pid);
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody AdministrativePenaltyInfoEntity administrativePenaltyInfo){
        ValidatorUtils.validateEntity(administrativePenaltyInfo, UpdateGroup.class);
        administrativePenaltyInfoService.updateById(administrativePenaltyInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        administrativePenaltyInfoService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }
    /**
     * 统计返回接口:本年度截止今日，处罚案件总数 ,处罚总金额 ,今年罚金增长率,今年罚金增长金额
     */
    @GetMapping("basestatic/{year}")
    @ApiOperation("基本信息统计查询")
    public R baseStaticinfo(@PathVariable("year") String year){
        R r = new R();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArr = administrativePenaltyInfoService.staticcount(year);
        return r.put("data",jsonArr);
    }

    /**
     * 统计返回接口:本年度每个月处罚金额统计与每个月处罚数量统计 type:1 代表金额统计 2 代表数量统计
     */
    @GetMapping("monthsstatic/{year}/{type}")
    @ApiOperation("年度每个月统计查询")
    public R monthStaticinfo(@PathVariable("year") String year,@PathVariable("type") String type){
        R r = new R();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArr = administrativePenaltyInfoService.monthStatic(year,type);
        return r.put("data",jsonArr);
    }

    /**
     *统计返回接口今年与去年的比较
     */
    @GetMapping("yearstatic/{year}/{type}")
    @ApiOperation("今年与去年的年度比较查询")
    public R yearStaticinfo(@PathVariable("year") String year,@PathVariable("type") String type){
        R r = new R();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArr = administrativePenaltyInfoService.yearStatic(year,type);
        return r.put("data",jsonArr);
    }

    /**
     *统计类型所占数量
     */
    @GetMapping("typestatic/{year}/{type}")
    @ApiOperation("违法类型数量统计查询")
    public R typeStaticinfo(@PathVariable("year") String year,@PathVariable("type") String type){
        R r = new R();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArr = administrativePenaltyInfoService.typeStatic(year,type);
        return r.put("data",jsonArr);
    }

    /**
     *处罚排行榜统计
     */
    @GetMapping("rankingstatic/{year}/{type}")
    @ApiOperation("处罚排行榜统计查询")
    public R rankStaticinfo(@PathVariable("year") String year,@PathVariable("type") String type){
        R r = new R();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArr = administrativePenaltyInfoService.companyRankStatic(year,type);
        return r.put("data",jsonArr);
    }
}

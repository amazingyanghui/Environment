package com.tengdi.environmentalprotectionint.modules.building.controller;


import com.tengdi.core.utils.*;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.environmentalprotectionint.modules.building.entity.BuildingProjectApprovalEntity;
import com.tengdi.environmentalprotectionint.modules.building.service.BuildingProjectApprovalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 项目建设审批情况
 *
 * @author tengdi
 * @email 
 * @date 2018-08-22 10:03:40
 */
@RestController
@RequestMapping("building/buildingprojectapproval")
@Api(tags="项目建设审批情况")
public class BuildingProjectApprovalController extends BaseController{
    @Autowired
    private BuildingProjectApprovalService buildingProjectApprovalService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = buildingProjectApprovalService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<BuildingProjectApprovalEntity> list= buildingProjectApprovalService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/queryName")
    @ApiOperation("列表")
    public String queryName(@RequestParam Map<String, Object> params){
        List<BuildingProjectApprovalEntity> list= buildingProjectApprovalService.queryName(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        BuildingProjectApprovalEntity buildingProjectApproval = buildingProjectApprovalService.getBuildingInfo(pid);

        return R.ok().put("buildingProjectApproval", buildingProjectApproval);
    }

    /**
     * 根据公司id获取项目建设审批情况
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取项目建设审批情况")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<BuildingProjectApprovalEntity> list = buildingProjectApprovalService.dataById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody BuildingProjectApprovalEntity buildingProjectApproval){
        ValidatorUtils.validateEntity(buildingProjectApproval, AddGroup.class);
        buildingProjectApproval.setCreatedate(DateUtils.getDate());
        String pid=buildingProjectApprovalService.insertData(buildingProjectApproval);

        return R.ok().put("pid",pid);
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody BuildingProjectApprovalEntity buildingProjectApproval){
        ValidatorUtils.validateEntity(buildingProjectApproval, UpdateGroup.class);
        buildingProjectApprovalService.updateById(buildingProjectApproval);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        buildingProjectApprovalService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }
    /**
     * 项目建设-图标统计
     */
    @GetMapping("/iconStatistics/{year}")
    @ApiOperation("项目建设-图标统计")
    public R iconStatistics(@PathVariable("year") String year){
        //各月投资统计
        Map<String,Object> map1  = buildingProjectApprovalService.monthlyInvestmentStatistics(year);
        //本年投资总额与去年对比
        int []  contrast =buildingProjectApprovalService.yearAndLastyearContrastByInvestment(year);
        //本年度各行业投资总额统计
        Map<String,Object> map2=buildingProjectApprovalService.totalIndustryInvestment(year);
        //本年度审批项目、本年度项目建设投资、环保投资、与去年同期相比，项目建设投资总额增加
        Map<String,Object> map =buildingProjectApprovalService.ProjectConstructionStatistics(year);
        return  R.ok().put("monthContainerByYear",map1.get("monthContainerByYear"))
                .put("monthContainerByLastyear",map1.get("monthContainerByLastyear"))
                .put("contrast",contrast)
                .put("industryName",map2.get("industryName"))
                .put("industryTotal",map2.get("industryTotal"))
                .put("construction1",map.get("counts"))
                .put("construction2",map.get("investment"))
                .put("construction3",map.get("protectionInvestment"))
                .put("construction4",map.get("growth"));
    }
    /**
     * 本年度行业投资占比
     */
    @GetMapping("/industryInvestmentProportion/{year}")
    @ApiOperation("项目建设-图标统计")
    public R industryInvestmentProportion(@PathVariable("year") String year){
        //本年度行业投资占比
        JSONArray industryInvestmentProportion =buildingProjectApprovalService.industryInvestmentProportion(year);
        return  R.ok() .put("industryInvestmentProportion",industryInvestmentProportion);
    }
}

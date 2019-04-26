package com.tengdi.environmentalprotectionint.modules.sys.controller;

import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import com.tengdi.core.utils.*;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.environmentalprotectionint.modules.sys.entity.SysApprovalUnitEntity;
import com.tengdi.environmentalprotectionint.modules.sys.service.SysApprovalUnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 审批单位字典表
 *
 * @author tengdi
 * @email 
 * @date 2018-10-18 12:00:20
 */
@RestController
@RequestMapping("sys/sysapprovalunit")
@Api(tags="审批单位字典表")
public class SysApprovalUnitController extends BaseController {
    @Autowired
    private SysApprovalUnitService sysApprovalUnitService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = sysApprovalUnitService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(){
        List<SelectEntity> list=sysApprovalUnitService.selectList();

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
			SysApprovalUnitEntity sysApprovalUnit = sysApprovalUnitService.selectById(pid);

        return R.ok().put("sysApprovalUnit", sysApprovalUnit);
    }

    /**
     * 信息
     */
    @GetMapping("/code/{code}")
    @ApiOperation("信息")
    public R code(@PathVariable("code") String code){
        SysApprovalUnitEntity sysApprovalUnit = sysApprovalUnitService.selectByMap(new MapUtils().put("company_code",code)).get(0);

        return R.ok().put("sysApprovalUnit", sysApprovalUnit);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody SysApprovalUnitEntity sysApprovalUnit){
        ValidatorUtils.validateEntity(sysApprovalUnit, AddGroup.class);
            sysApprovalUnit.setCreateDate(DateUtils.getDate());
            sysApprovalUnit.setUpdateDate(DateUtils.getDate());
			sysApprovalUnitService.insert(sysApprovalUnit);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody SysApprovalUnitEntity sysApprovalUnit){
        ValidatorUtils.validateEntity(sysApprovalUnit, UpdateGroup.class);
            sysApprovalUnit.setUpdateDate(DateUtils.getDate());
			sysApprovalUnitService.updateById(sysApprovalUnit);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
			sysApprovalUnitService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}

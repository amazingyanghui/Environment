package com.tengdi.environmentalprotectionint.modules.penalty.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.penalty.entity.AdministrativePenaltyFileEntity;
import com.tengdi.environmentalprotectionint.modules.penalty.service.AdministrativePenaltyFileService;
import com.tengdi.core.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 处罚资料文件
 *
 * @author tengdi
 * @email 
 * @date 2018-10-29 14:27:40
 */
@RestController
@RequestMapping("penalty/administrativepenaltyfile")
@Api(tags="处罚资料文件")
public class AdministrativePenaltyFileController extends BaseController{
    @Autowired
    private AdministrativePenaltyFileService administrativePenaltyFileService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = administrativePenaltyFileService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
			AdministrativePenaltyFileEntity administrativePenaltyFile = administrativePenaltyFileService.selectById(pid);

        return R.ok().put("administrativePenaltyFile", administrativePenaltyFile);
    }

    /**
     * 根据项目id查附件
     */
    @GetMapping("/dataByFile/{aid}")
    @ApiOperation("根据项目id查附件")
    public R dataByFile(@PathVariable("aid") String aid){
        List<AdministrativePenaltyFileEntity> buildingProjectAttachment = administrativePenaltyFileService.dataByFile(aid);

        return R.ok().put("fileAttachment", buildingProjectAttachment);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody AdministrativePenaltyFileEntity administrativePenaltyFile){
        ValidatorUtils.validateEntity(administrativePenaltyFile, AddGroup.class);
            administrativePenaltyFile.setCreatedate(DateUtils.getDate());
			administrativePenaltyFileService.insert(administrativePenaltyFile);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody AdministrativePenaltyFileEntity administrativePenaltyFile){
        ValidatorUtils.validateEntity(administrativePenaltyFile, UpdateGroup.class);
			administrativePenaltyFileService.updateById(administrativePenaltyFile);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
			administrativePenaltyFileService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}

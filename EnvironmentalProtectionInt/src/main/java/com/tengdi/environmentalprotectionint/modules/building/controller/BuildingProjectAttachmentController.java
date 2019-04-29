package com.tengdi.environmentalprotectionint.modules.building.controller;

import com.tengdi.environmentalprotectionint.modules.building.entity.BuildingProjectAttachmentEntity;
import com.tengdi.environmentalprotectionint.modules.building.service.BuildingProjectAttachmentService;
import com.tengdi.core.utils.DateUtils;

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

import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 审批/批复文件
 *
 * @author tengdi
 * @email 
 * @date 2018-09-10 13:58:11
 */
@RestController
@RequestMapping("market/buildingprojectattachment")
@Api(tags="审批/批复文件")
public class BuildingProjectAttachmentController extends BaseController{
    @Autowired
    private BuildingProjectAttachmentService buildingProjectAttachmentService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = buildingProjectAttachmentService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        BuildingProjectAttachmentEntity buildingProjectAttachment = buildingProjectAttachmentService.selectById(pid);

        return R.ok().put("buildingProjectAttachment", buildingProjectAttachment);
    }

    /**
     * 根据项目id查附件
     */
    @GetMapping("/dataByFile/{bid}")
    @ApiOperation("根据项目id查附件")
    public R dataByFile(@PathVariable("bid") String bid){
        List<BuildingProjectAttachmentEntity> buildingProjectAttachment = buildingProjectAttachmentService.dataByFile(bid);

        return R.ok().put("fileAttachment", buildingProjectAttachment);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody BuildingProjectAttachmentEntity buildingProjectAttachment){
        ValidatorUtils.validateEntity(buildingProjectAttachment, AddGroup.class);
        buildingProjectAttachment.setCreatedate(DateUtils.getDate());
        buildingProjectAttachmentService.insert(buildingProjectAttachment);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody BuildingProjectAttachmentEntity buildingProjectAttachment){
        ValidatorUtils.validateEntity(buildingProjectAttachment, UpdateGroup.class);
        buildingProjectAttachment.setCreatedate(DateUtils.getDate());
        buildingProjectAttachmentService.updateById(buildingProjectAttachment);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        buildingProjectAttachmentService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}

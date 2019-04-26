package com.tengdi.environmentalprotectionint.modules.mobile.controller;

import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementAttachmentEntity;
import com.tengdi.environmentalprotectionint.modules.mobile.service.MobileEnforcementAttachmentService;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.HashMap;
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
 * 现场检查附件信息
 *
 * @author tengdi
 * @email
 * @date 2018-09-10 11:08:54
 */
@RestController
@RequestMapping("mobile/mobileenforcementattachment")
@Api(tags="现场检查附件信息")
public class MobileEnforcementAttachmentController extends BaseController{
    @Autowired
    private MobileEnforcementAttachmentService mobileEnforcementAttachmentService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = mobileEnforcementAttachmentService.queryPage(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        MobileEnforcementAttachmentEntity mobileEnforcementAttachment = mobileEnforcementAttachmentService.selectById(pid);
        return R.ok().put("mobileEnforcementAttachment", mobileEnforcementAttachment);
    }

    /**
     * 根据项目id查附件
     */
    @GetMapping("/dataByFile/{mid}")
    @ApiOperation("根据项目mid查附件")
    public R dataByFile(@PathVariable("mid") String mid){
        Map<String,Object> map=new HashMap<>();
        map.put("mid",mid);
        map.put("type",0);
        List<MobileEnforcementAttachmentEntity> mobileEnforcementAttachmentEntities = mobileEnforcementAttachmentService.dataByFile(map);

        return R.ok().put("fileAttachment", mobileEnforcementAttachmentEntities);
    }

    /**
     * 根据项目id查附件
     */
    @GetMapping("/dataByFile")
    @ApiOperation("根据项目id查附件")
    public R dataByFile(@RequestParam Map<String, Object> params){
        List<MobileEnforcementAttachmentEntity> mobileEnforcementAttachmentEntities = mobileEnforcementAttachmentService.dataByFile(params);

        return R.ok().put("fileAttachment", mobileEnforcementAttachmentEntities);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody MobileEnforcementAttachmentEntity mobileEnforcementAttachment){
        ValidatorUtils.validateEntity(mobileEnforcementAttachment, AddGroup.class);
//        mobileEnforcementAttachment.setCreatedate(DateUtils.getDate());
        mobileEnforcementAttachmentService.insert(mobileEnforcementAttachment);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody MobileEnforcementAttachmentEntity mobileEnforcementAttachment){
        ValidatorUtils.validateEntity(mobileEnforcementAttachment, UpdateGroup.class);
//        mobileEnforcementAttachment.setUpdatedate(DateUtils.getDate());
        mobileEnforcementAttachmentService.updateById(mobileEnforcementAttachment);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        mobileEnforcementAttachmentService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}

package com.tengdi.environmentalprotectionint.modules.petition.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;
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
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.petition.entity.PetitionSystemComplainEntity;
import com.tengdi.environmentalprotectionint.modules.petition.service.PetitionSystemComplainService;
import com.tengdi.core.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 信访投诉
 *
 * @author tengdi
 * @email
 * @date 2018-11-20 09:53:05
 */
@RestController
@RequestMapping("petition/petitionsystemcomplain")
@Api(tags="信访投诉")
public class PetitionSystemComplainController extends BaseController{
    @Autowired
    private PetitionSystemComplainService petitionSystemComplainService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = petitionSystemComplainService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<PetitionSystemComplainEntity> list= petitionSystemComplainService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        PetitionSystemComplainEntity petitionSystemComplain = petitionSystemComplainService.entityById(pid);

        return R.ok().put("petitionSystemComplain", petitionSystemComplain);
    }

    /**
     * 根据公司id获取信访投诉
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取信访投诉")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<PetitionSystemComplainEntity> list = petitionSystemComplainService.dataById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }
    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody PetitionSystemComplainEntity petitionSystemComplain){
        ValidatorUtils.validateEntity(petitionSystemComplain, AddGroup.class);
        petitionSystemComplain.setCreateDate(DateUtils.getStringDate());
        petitionSystemComplain.setUpdateDate(DateUtils.getStringDate());
        petitionSystemComplainService.insert(petitionSystemComplain);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody PetitionSystemComplainEntity petitionSystemComplain){
        ValidatorUtils.validateEntity(petitionSystemComplain, UpdateGroup.class);
        petitionSystemComplain.setUpdateDate(DateUtils.getStringDate());
        petitionSystemComplainService.updateById(petitionSystemComplain);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        petitionSystemComplainService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}

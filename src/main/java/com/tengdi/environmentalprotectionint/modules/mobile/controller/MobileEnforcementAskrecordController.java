package com.tengdi.environmentalprotectionint.modules.mobile.controller;

import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementAskrecordEntity;
import com.tengdi.environmentalprotectionint.modules.mobile.service.MobileEnforcementAskrecordService;
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
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 案件调查询问笔录
 *
 * @author tengdi
 * @email 
 * @date 2003-07-25 23:56:39
 */
@RestController
@RequestMapping("mobile/mobileenforcementaskrecord")
@Api(tags="案件调查询问笔录")
public class MobileEnforcementAskrecordController extends BaseController{
    @Autowired
    private MobileEnforcementAskrecordService mobileEnforcementAskrecordService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        if(params.get("page")!=null){
            PageUtils page = mobileEnforcementAskrecordService.queryPage(params);
            return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
        }else{
            List<MobileEnforcementAskrecordEntity> list= mobileEnforcementAskrecordService.queryName(params);
            return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
        }
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<MobileEnforcementAskrecordEntity> list= mobileEnforcementAskrecordService.queryList(params);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        MobileEnforcementAskrecordEntity mobileEnforcementAskrecord = mobileEnforcementAskrecordService.entityById(pid);

        return R.ok().put("mobileEnforcementAskrecord", mobileEnforcementAskrecord);
    }

    /**
     * 根据公司id获得案件记录
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获得案件记录")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<MobileEnforcementAskrecordEntity> list = mobileEnforcementAskrecordService.dataById(cid);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody MobileEnforcementAskrecordEntity mobileEnforcementAskrecord){
        ValidatorUtils.validateEntity(mobileEnforcementAskrecord, AddGroup.class);
//        mobileEnforcementAskrecord.setCreatedate(DateUtils.getDate());
        mobileEnforcementAskrecordService.insert(mobileEnforcementAskrecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody MobileEnforcementAskrecordEntity mobileEnforcementAskrecord){
        ValidatorUtils.validateEntity(mobileEnforcementAskrecord, UpdateGroup.class);
//        mobileEnforcementAskrecord.setUpdatedate(DateUtils.getDate());
        mobileEnforcementAskrecordService.updateById(mobileEnforcementAskrecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        mobileEnforcementAskrecordService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}

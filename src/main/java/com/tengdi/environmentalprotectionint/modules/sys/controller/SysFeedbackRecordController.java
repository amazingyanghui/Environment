package com.tengdi.environmentalprotectionint.modules.sys.controller;

import com.tengdi.environmentalprotectionint.modules.sys.entity.SysFeedbackInfoEntity;
import com.tengdi.environmentalprotectionint.modules.sys.service.SysFeedbackInfoService;
import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.tengdi.userauthenuuid.common.annotation.SysLog;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.sys.entity.SysFeedbackRecordEntity;
import com.tengdi.environmentalprotectionint.modules.sys.service.SysFeedbackRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 反馈记录
 *
 * @author tengdi
 * @email
 * @date 2018-11-13 10:15:09
 */
@RestController
@RequestMapping("sys/sysfeedbackrecord")
@Api(tags="反馈记录")
public class SysFeedbackRecordController extends BaseController{
    @Autowired
    private SysFeedbackRecordService sysFeedbackRecordService;
    @Autowired
    private SysFeedbackInfoService sysFeedbackInfoService;

//    /**
//     * 列表
//     */
//    @GetMapping
//    @ApiOperation("列表")
//    public String list(@RequestParam Map<String, Object> params){
//        PageUtils page = sysFeedbackRecordService.queryPage(params);
//
//        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
//    }

    /**
     * 根据反馈主表id获得反馈记录数据,有分页
     */
    @GetMapping("/list/{oid}")
    @ApiOperation("根据反馈主表id获得反馈记录数据,有分页")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "oid", value = "反馈主表id", required = false), })
    public String list(@PathVariable("oid") String oid){
        Map<String,Object> map=new HashMap<>();
        map.put("oid",oid);
        PageUtils page = sysFeedbackRecordService.queryPage(map);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 根据反馈主表id获得反馈记录数据,无分页
     */
    @GetMapping("/info/{oid}")
    @ApiOperation("根据反馈主表id获得反馈记录数据,无分页")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "oid", value = "反馈主表id", required = false), })
    public String info(@PathVariable("oid") String oid){
        Map<String,Object> map=new HashMap<>();
        map.put("oid",oid);
        List<SysFeedbackRecordEntity> list = sysFeedbackRecordService.queryList(map);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 在旧反馈提交新反馈
     */
    @PostMapping
    @ApiOperation("在旧反馈中提交新反馈；需要oid:反馈主表（外键id）;feedbackContent：反馈内容；")
    @Transactional(rollbackFor = Exception.class)
    @SysLog(value = "在旧反馈中提交新反馈")
    public R save(@RequestBody SysFeedbackRecordEntity sysFeedbackRecord){
        sysFeedbackRecord.setReplyStatus(String.valueOf(0));
        sysFeedbackRecord.setFeedbackDate(DateUtils.getStringDate());
        sysFeedbackRecord.setCreateDate(DateUtils.getStringDate());
        sysFeedbackRecord.setUpdateDate(DateUtils.getStringDate());
        sysFeedbackRecordService.insert(sysFeedbackRecord);

        return R.ok();
    }

    /**
     * 反馈回复时先去反馈主表修改回复状态,在修改反馈记录表数据
     */
    @PutMapping
    @ApiOperation("反馈回复时;需要oid:反馈主表（外键id）;replyContent:回复内容")
    @Transactional(rollbackFor = Exception.class)
    @SysLog(value = "反馈回复时先去反馈主表修改回复状态,在修改反馈记录表数据")
    public R update(@RequestBody SysFeedbackRecordEntity sysFeedbackRecord){
        //反馈回复时先去反馈主表修改回复状态
        SysFeedbackInfoEntity sysFeedbackInfo=new SysFeedbackInfoEntity();
        sysFeedbackInfo.setPid(sysFeedbackRecord.getOid());
        sysFeedbackInfo.setReplyStatus(String.valueOf(1));
        sysFeedbackInfo.setUpdateDate(DateUtils.getStringDate());
        sysFeedbackInfoService.updateById(sysFeedbackInfo);
        //在修改反馈记录表数据
        sysFeedbackRecord.setReplyStatus(String.valueOf(1));
        sysFeedbackRecord.setReplyDate(DateUtils.getStringDate());
        sysFeedbackRecord.setUpdateDate(DateUtils.getStringDate());
        sysFeedbackRecordService.updateById(sysFeedbackRecord);

        return R.ok();
    }

//    /**
//     * 删除
//     */
//    @DeleteMapping
//    @ApiOperation("删除")
//    public R delete(@RequestBody String[] pids){
//        sysFeedbackRecordService.deleteBatchIds(Arrays.asList(pids));
//
//        return R.ok();
//    }

}

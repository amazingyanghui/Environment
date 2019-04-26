package com.tengdi.environmentalprotectionint.modules.sys.controller;

import com.tengdi.environmentalprotectionint.modules.sys.entity.SysFeedbackRecordEntity;
import com.tengdi.environmentalprotectionint.modules.sys.service.SysFeedbackRecordService;
import com.tengdi.core.utils.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.tengdi.userauthenuuid.common.annotation.SysLog;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.SysUserEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysUserService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.tengdi.environmentalprotectionint.modules.sys.entity.SysFeedbackInfoEntity;
import com.tengdi.environmentalprotectionint.modules.sys.service.SysFeedbackInfoService;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 反馈主表
 *
 * @author tengdi
 * @email
 * @date 2018-11-13 10:15:02
 */
@RestController
@RequestMapping("sys/sysfeedbackinfo")
@Api(tags="反馈主表")
public class SysFeedbackInfoController extends BaseController{
    @Autowired
    private SysFeedbackInfoService sysFeedbackInfoService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysFeedbackRecordService sysFeedbackRecordService;

    /**
     * 根据登录用户（即公司账号）获得反馈主表的基本信息,有分页
     */
    @GetMapping("/list")
    @ApiOperation("根据登录用户（即公司账号）获得反馈主表的基本信息,有分页")
    public String list(@RequestParam Map<String, Object> params){
        //取出登录用户（即公司账号）
        SysUserEntity userEntity=sysUserService.selectById(getUserId());
        if(userEntity!=null){
            if(!userEntity.getUsername().equals("admin")){
                params.put("loginUser",userEntity.getUsername());
            }
        }
        PageUtils page = sysFeedbackInfoService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


//    /**
//     * 信息
//     */
//    @GetMapping("/{pid}")
//    @ApiOperation("信息")
//    public R info(@PathVariable("pid") String pid){
//        SysFeedbackInfoEntity sysFeedbackInfo = sysFeedbackInfoService.selectById(pid);
//
//        return R.ok().put("sysFeedbackInfo", sysFeedbackInfo);
//    }

    /**
     * 根据登录用户（即公司账号）获得反馈主表的基本信息,没有分页
     */
    @GetMapping("/info")
    @ApiOperation("根据登录用户（即公司账号）获得反馈主表的基本信息,没有分页")
    public String info(@RequestParam Map<String, Object> params){
        //取出登录用户（即公司账号）
        SysUserEntity userEntity=sysUserService.selectById(getUserId());
        if(userEntity!=null){
            if(!userEntity.getUsername().equals("admin")){
                params.put("loginUser",userEntity.getUsername());
            }
        }
        List<SysFeedbackInfoEntity> list= sysFeedbackInfoService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 提交新反馈,插入反馈主表返回主表id，在把反馈内容插入反馈记录中
     */
    @PostMapping
    @ApiOperation("提交新反馈:需要userName:姓名;userPhone:电话;userMail:邮箱;questionType:问题类型:（0：问题咨询，1：意见建议，2：投诉）;feedbackType:反馈类型（0：用户反馈:1：系统反馈）;feedbackContent:反馈内容")
    @Transactional(rollbackFor = Exception.class)
    @SysLog(value = "提交新反馈,插入反馈主表返回主表id，在把反馈内容插入反馈记录中")
    public R save(@RequestBody SysFeedbackInfoEntity sysFeedbackInfo){
        //取出登录用户（即公司账号）
        SysUserEntity userEntity=sysUserService.selectById(getUserId());
        if(userEntity!=null){
            sysFeedbackInfo.setLoginUser(userEntity.getUsername());
        }
        //提交新反馈,插入反馈主表返回主表id
        sysFeedbackInfo.setReplyStatus(String.valueOf(0));
        sysFeedbackInfo.setCreateDate(DateUtils.getStringDate());
        sysFeedbackInfo.setUpdateDate(DateUtils.getStringDate());
        String pid=sysFeedbackInfoService.insertData(sysFeedbackInfo);

        //在把反馈内容插入反馈记录中
        SysFeedbackRecordEntity sysFeedbackRecord=new SysFeedbackRecordEntity();
        sysFeedbackRecord.setOid(pid);
        sysFeedbackRecord.setReplyStatus(String.valueOf(0));
        sysFeedbackRecord.setFeedbackContent(sysFeedbackInfo.getFeedbackContent());
        sysFeedbackRecord.setFeedbackDate(DateUtils.getStringDate());
        sysFeedbackRecord.setCreateDate(DateUtils.getStringDate());
        sysFeedbackRecord.setUpdateDate(DateUtils.getStringDate());
        sysFeedbackRecordService.insert(sysFeedbackRecord);
        return R.ok();
    }

    /**
     * 提交新反馈,插入反馈主表返回主表id，在把反馈内容插入反馈记录中
     */
    @PostMapping("/saveByPhone")
    @ApiOperation("提交新反馈:需要userName:姓名;userPhone:电话;userMail:邮箱;questionType:问题类型:（0：问题咨询，1：意见建议，2：投诉）;feedbackType:反馈类型（0：用户反馈:1：系统反馈）;feedbackContent:反馈内容")
    @Transactional(rollbackFor = Exception.class)
    @SysLog(value = "提交新反馈,插入反馈主表返回主表id，在把反馈内容插入反馈记录中")
    public R saveByPhone(@RequestParam String userName,
                         @RequestParam String userPhone,
                         @RequestParam String userMail,
                         @RequestParam String questionType,
                         @RequestParam String feedbackType,
                         @RequestParam String feedbackContent){
        SysFeedbackInfoEntity sysFeedbackInfo=new SysFeedbackInfoEntity();
        sysFeedbackInfo.setUserName(userName);
        sysFeedbackInfo.setUserPhone(userPhone);
        sysFeedbackInfo.setUserMail(userMail);
        sysFeedbackInfo.setQuestionType(questionType);
        sysFeedbackInfo.setFeedbackType(feedbackType);
        sysFeedbackInfo.setFeedbackContent(feedbackContent);
        //取出登录用户（即公司账号）
        SysUserEntity userEntity=sysUserService.selectById(getUserId());
        if(userEntity!=null){
            sysFeedbackInfo.setLoginUser(userEntity.getUsername());
        }
        //提交新反馈,插入反馈主表返回主表id
        sysFeedbackInfo.setReplyStatus(String.valueOf(0));
        sysFeedbackInfo.setCreateDate(DateUtils.getStringDate());
        sysFeedbackInfo.setUpdateDate(DateUtils.getStringDate());
        String pid=sysFeedbackInfoService.insertData(sysFeedbackInfo);

        //在把反馈内容插入反馈记录中
        SysFeedbackRecordEntity sysFeedbackRecord=new SysFeedbackRecordEntity();
        sysFeedbackRecord.setOid(pid);
        sysFeedbackRecord.setReplyStatus(String.valueOf(0));
        sysFeedbackRecord.setFeedbackContent(sysFeedbackInfo.getFeedbackContent());
        sysFeedbackRecord.setFeedbackDate(DateUtils.getStringDate());
        sysFeedbackRecord.setCreateDate(DateUtils.getStringDate());
        sysFeedbackRecord.setUpdateDate(DateUtils.getStringDate());
        sysFeedbackRecordService.insert(sysFeedbackRecord);
        return R.ok();
    }

//    /**
//     * 修改
//     */
//    @PutMapping
//    @ApiOperation("修改")
//    public R update(@RequestBody SysFeedbackInfoEntity sysFeedbackInfo){
////        sysFeedbackInfo.setReplyStatus(1);
//        sysFeedbackInfo.setUpdateDate(DateUtils.getStringDate());
//        sysFeedbackInfoService.updateById(sysFeedbackInfo);
//
//        return R.ok();
//    }

    /**
     * 先根据反馈主表id删除反馈记录数据，再删除反馈主表数据
     */
    @DeleteMapping
    @ApiOperation("先根据反馈主表id删除反馈记录数据，再删除反馈主表数据")
    @Transactional(rollbackFor = Exception.class)
    @SysLog(value = "先根据反馈主表id删除反馈记录数据，再删除反馈主表数据")
    public R delete(@RequestBody String[] pids){
        List<String> idList=Arrays.asList(pids);
        for(int i=0;i<idList.size();i++){
            sysFeedbackRecordService.deleteByMap(new MapUtils().put("oid",idList.get(0)));
        }
        sysFeedbackInfoService.deleteBatchIds(idList);

        return R.ok();
    }

}

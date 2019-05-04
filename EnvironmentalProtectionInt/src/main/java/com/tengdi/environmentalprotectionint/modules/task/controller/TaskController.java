package com.tengdi.environmentalprotectionint.modules.task.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementSceneEntity;
import com.tengdi.environmentalprotectionint.modules.task.entity.CheckRecord;
import com.tengdi.environmentalprotectionint.modules.task.entity.Task;
import com.tengdi.environmentalprotectionint.modules.task.service.TaskService;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.entity.SysUserEntity;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("task")
public class TaskController extends BaseController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/addTask")
    @ResponseBody
    @ApiOperation("新增常规任务")
    public Object addTask(Task task){
        ValidatorUtils.validateEntity(task, AddGroup.class);
        Boolean flag=taskService.addTask(task);
        return R.ok();
    }

    @GetMapping("/getOfficer")
    @ResponseBody
    @ApiOperation("执行人列表")
    public Object getOfficer(){
        List<SysUserEntity> officers= taskService.queryOfficer();
    return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(officers)).toString();
    }

    @GetMapping("/getTaskList")
    @ResponseBody
    @ApiOperation("常规任务列表")
    public Object getTaskList(){
        List<Task> tasks=taskService.queryTask();
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(tasks)).toString();
    }

    @GetMapping("/appointedTask")
    @ResponseBody
    @ApiOperation("指派任务")
    public Object appointedTask(HttpServletRequest request){
        String uid=request.getParameter("uid");
        Integer tid=Integer.parseInt(request.getParameter("tid"));
        Map<String,Object> map=new HashMap<>();
        map.put("uid",uid);
        map.put("tid",tid);
        Boolean flag=taskService.appointedTask(map);
        return  R.ok();
    }

    /**
     * 企业选择
     */
    @GetMapping("/selectCominfo")
    @ApiOperation("现场执法")
    @ResponseBody
    public Object selectCominfo(){
        List<CominfoBaseinfoEntity> lists=taskService.queryCominfo();
        return   LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(lists)).toString();
    }

    /**
     * 新增任务
     *
     */
    @GetMapping("/insertTask")
    @ResponseBody
    public Object insertTask(MobileEnforcementSceneEntity mobileEnforcementScene){
        ValidatorUtils.validateEntity(mobileEnforcementScene, AddGroup.class);
        mobileEnforcementScene.setCreatedate(DateUtils.getDate());
        Boolean flag=taskService.insertTask(mobileEnforcementScene);

        return R.ok();
    }

    @GetMapping("/queryTaskToDo")
    @ResponseBody
    @ApiOperation("待办任务列表")
    public Object queryTaskToDo(HttpServletRequest request){
       String userID= request.getParameter("userid");
       String taskmanager="";
       if(taskService.queryByUserID(userID).getDeptId().equals("2")){
           taskmanager=userID;
       }
        List<MobileEnforcementSceneEntity> scenes=taskService.queryTaskToDo(taskmanager);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(scenes)).toString();
    }

    @GetMapping("/queryAllTask")
    @ResponseBody
    @ApiOperation("全部任务列表")
    public Object queryAllTask(HttpServletRequest request){
        String userID= request.getParameter("userid");
        String taskmanager="";
        if(taskService.queryByUserID(userID).getDeptId().equals("2")){
            taskmanager=userID;
        }
        List<MobileEnforcementSceneEntity> allScenes=taskService.queryAllTask(taskmanager);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(allScenes)).toString();
    }

    @GetMapping("/OvertimeTask")
    @ResponseBody
    @ApiOperation("超时任务列表")
    public Object OvertimeTask(HttpServletRequest request){
        String userID= request.getParameter("userid");
        String taskmanager="";
        if(taskService.queryByUserID(userID).getDeptId().equals("2")){
            taskmanager=userID;
        }
        List<MobileEnforcementSceneEntity> tasks=taskService.OvertimeTask(taskmanager);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(tasks)).toString();
    }
    @GetMapping("/onTimeTask")
    @ResponseBody
    @ApiOperation("临期列表")
    public Object onTimeTask(HttpServletRequest request){
        String userID= request.getParameter("userid");
        String taskmanager="";
        if(taskService.queryByUserID(userID).getDeptId().equals("2")){
            taskmanager=userID;
        }
        List<MobileEnforcementSceneEntity> timeTasks=taskService.onTimeTask(taskmanager);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(timeTasks)).toString();
    }

    @GetMapping("/queryDicts")
    @ResponseBody
    @ApiOperation("生产状态")
    public Object queryDicts(){
        List<SysDictEntity> dicts=taskService.queryDicts();
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(dicts)).toString();
    }

    @GetMapping("/updateTask")
    @ResponseBody
    @ApiOperation("修改任务")
    public Object updateTask(MobileEnforcementSceneEntity mobileEnforcementScene){
        ValidatorUtils.validateEntity(mobileEnforcementScene, UpdateGroup.class);
        Boolean flag=taskService.updateTask(mobileEnforcementScene);
      return  R.ok();
    }

    @GetMapping("/addRecord")
    @ResponseBody
    @ApiOperation("检查记录表")
    public  Object addRecord(CheckRecord record){
        ValidatorUtils.validateEntity(record, AddGroup.class);
         Boolean flag= taskService.insertCheckRecord(record);
        return  R.ok();
    }

}

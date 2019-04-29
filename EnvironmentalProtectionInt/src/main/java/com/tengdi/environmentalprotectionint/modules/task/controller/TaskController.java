package com.tengdi.environmentalprotectionint.modules.task.controller;

import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.environmentalprotectionint.modules.task.entity.Task;
import com.tengdi.environmentalprotectionint.modules.task.service.TaskService;
import com.tengdi.userauthenuuid.modules.auth.shiro.jwt.UserUtils;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.SysUserEntity;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/getUserId")
    public Object getUser(){

        return 2;
    }

}

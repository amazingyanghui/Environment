package com.tengdi.environmentalprotectionint.modules.task.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.task.entity.Task;
import com.tengdi.userauthenuuid.modules.sys.entity.SysUserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface TaskService  {
    /**
     * 新增任务
     */
    Boolean addTask(Task task);

    /**
     *获取执法者
     */
    List<SysUserEntity> queryOfficer();

    /**
     * 常规任务列表
     */
    List<Task> queryTask();

    /**
     * 指派任务
     */
    Boolean appointedTask(Map<String,Object> map);
}

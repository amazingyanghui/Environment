package com.tengdi.environmentalprotectionint.modules.task.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementSceneEntity;
import com.tengdi.environmentalprotectionint.modules.task.entity.CheckRecord;
import com.tengdi.environmentalprotectionint.modules.task.entity.Task;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
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

    /**
     *企业列表
     */
    List<CominfoBaseinfoEntity> queryCominfo();

    /**
     * 新建任务
     */
    Boolean insertTask(MobileEnforcementSceneEntity sceneEntity);

    /**
     *  待办任务
     */
    List<MobileEnforcementSceneEntity> queryTaskToDo(String taskmanager);

    /**
     *  全部任务
     */
    List<MobileEnforcementSceneEntity> queryAllTask(String taskmanager);

    /**
     * 超时任务
     */
    List<MobileEnforcementSceneEntity> OvertimeTask(String taskmanager);

    /**
     * 临期
     */
    List<MobileEnforcementSceneEntity> onTimeTask(String taskmanager);

    /**
     * 根据userid判断用户部门
     */
    SysUserEntity queryByUserID(String userID);

    /**
     * 生产状态
     */
    List<SysDictEntity> queryDicts();

    /**
     * 执行任务
     * @param sceneEntity
     * @return
     */
    Boolean updateTask(MobileEnforcementSceneEntity sceneEntity);

    /**
     * 添加检查记录表
     * @param record
     * @return
     */
    Boolean insertCheckRecord(CheckRecord record);
}

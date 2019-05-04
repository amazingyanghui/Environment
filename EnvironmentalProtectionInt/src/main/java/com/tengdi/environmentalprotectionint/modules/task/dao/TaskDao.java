package com.tengdi.environmentalprotectionint.modules.task.dao;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementSceneEntity;
import com.tengdi.environmentalprotectionint.modules.task.entity.CheckRecord;
import com.tengdi.environmentalprotectionint.modules.task.entity.Task;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface TaskDao {
 /**
  * 新增任务
  */
 Integer addTask(Task task);

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
Integer appointedTask(Map<String,Object> map);

/**
 *新增现场执法
 */
 Integer insertEnforcement();

 /**
  *企业列表
  */
 List<CominfoBaseinfoEntity> queryCominfo();

 /**
  * 新建任务
  */
 Integer insertTask(MobileEnforcementSceneEntity sceneEntity);

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
 Integer updateTask(MobileEnforcementSceneEntity sceneEntity);

 /**
  * 添加检查记录表
  * @param record
  * @return
  */
 Integer insertCheckRecord(CheckRecord record);

    /**
     *任务详情
     */
    List<MobileEnforcementSceneEntity> queryTaskByID(String pid);
}

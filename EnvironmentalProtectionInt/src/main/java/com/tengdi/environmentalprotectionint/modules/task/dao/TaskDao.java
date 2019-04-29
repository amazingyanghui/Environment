package com.tengdi.environmentalprotectionint.modules.task.dao;

import com.tengdi.environmentalprotectionint.modules.task.entity.Task;
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
 *
 */

}

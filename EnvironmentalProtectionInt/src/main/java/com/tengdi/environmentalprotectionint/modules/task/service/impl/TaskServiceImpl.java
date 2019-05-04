package com.tengdi.environmentalprotectionint.modules.task.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementSceneEntity;
import com.tengdi.environmentalprotectionint.modules.task.dao.TaskDao;
import com.tengdi.environmentalprotectionint.modules.task.entity.CheckRecord;
import com.tengdi.environmentalprotectionint.modules.task.entity.Task;
import com.tengdi.environmentalprotectionint.modules.task.service.TaskService;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("taskService")
public class TaskServiceImpl implements TaskService {


    @Autowired
    private TaskDao taskDao;
    @Override
    public Boolean addTask(Task task) {
        return taskDao.addTask(task)>0 ? true : false;
    }

    @Override
    public List<SysUserEntity> queryOfficer() {
        return taskDao.queryOfficer();
    }

    @Override
    public Boolean appointedTask(Map<String,Object> map) {
        return taskDao.appointedTask(map)>0 ? true : false ;
    }

    @Override
    public List<CominfoBaseinfoEntity> queryCominfo() {
        return taskDao.queryCominfo();
    }

    @Override
    public List<Task> queryTask() {
        return taskDao.queryTask();
    }

    @Override
    public Boolean insertTask(MobileEnforcementSceneEntity sceneEntity) {
        return taskDao.insertTask(sceneEntity)>0 ? true : false;
    }

    @Override
    public List<MobileEnforcementSceneEntity> queryAllTask(String taskmanager) {
        return taskDao.queryAllTask(taskmanager);
    }

    @Override
    public List<MobileEnforcementSceneEntity> queryTaskToDo(String taskmanager) {
        return taskDao.queryTaskToDo(taskmanager);
    }

    @Override
    public List<MobileEnforcementSceneEntity> OvertimeTask(String taskmanager) {
        return taskDao.OvertimeTask(taskmanager);
    }

    @Override
    public SysUserEntity queryByUserID(String userID) {
        return taskDao.queryByUserID(userID);
    }

    @Override
    public List<SysDictEntity> queryDicts() {
        return taskDao.queryDicts();
    }

    @Override
    public Boolean updateTask(MobileEnforcementSceneEntity sceneEntity) {
        return taskDao.updateTask(sceneEntity)>0 ? true : false;
    }

    @Override
    public List<MobileEnforcementSceneEntity> onTimeTask(String taskmanager) {
        return taskDao.onTimeTask(taskmanager);
    }

    @Override
    public Boolean insertCheckRecord(CheckRecord record) {
        return taskDao.insertCheckRecord(record)>0 ? true :false;
    }
}

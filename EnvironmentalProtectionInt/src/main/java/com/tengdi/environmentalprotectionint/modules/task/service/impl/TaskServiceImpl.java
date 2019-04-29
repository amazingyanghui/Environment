package com.tengdi.environmentalprotectionint.modules.task.service.impl;

import com.tengdi.environmentalprotectionint.modules.task.dao.TaskDao;
import com.tengdi.environmentalprotectionint.modules.task.entity.Task;
import com.tengdi.environmentalprotectionint.modules.task.service.TaskService;
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
    public List<Task> queryTask() {
        return taskDao.queryTask();
    }

}

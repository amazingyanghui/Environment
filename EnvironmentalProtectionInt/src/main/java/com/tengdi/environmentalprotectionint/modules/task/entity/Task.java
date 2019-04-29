package com.tengdi.environmentalprotectionint.modules.task.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("sys_approval_unit")
public class Task {
    @TableId
   private Integer id;
    private String taskName;
    private Integer taskType;
    private String taskClassification;
    private String taskSource;
    private String startTime;
    private String endTime;
    private String cancelTime;
    private String completetime;
    private String assignedUserId;
    private String responsibleUserId;
    private String companyId;
    private String taskAttachmentUrl;
    private String taskPlan;
    private String taskDescribe;
    private String taskResults;
    private String problemType;
    private String applicationSide;
    private String handlingopinions;

    public String getHandlingopinions() {
        return handlingopinions;
    }

    public void setHandlingopinions(String handlingopinions) {
        this.handlingopinions = handlingopinions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getTaskClassification() {
        return taskClassification;
    }

    public void setTaskClassification(String taskClassification) {
        this.taskClassification = taskClassification;
    }

    public String getTaskSource() {
        return taskSource;
    }

    public void setTaskSource(String taskSource) {
        this.taskSource = taskSource;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getCompletetime() {
        return completetime;
    }

    public void setCompletetime(String completetime) {
        this.completetime = completetime;
    }

    public String getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(String assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public String getResponsibleUserId() {
        return responsibleUserId;
    }

    public void setResponsibleUserId(String responsibleUserId) {
        this.responsibleUserId = responsibleUserId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getTaskAttachmentUrl() {
        return taskAttachmentUrl;
    }

    public void setTaskAttachmentUrl(String taskAttachmentUrl) {
        this.taskAttachmentUrl = taskAttachmentUrl;
    }

    public String getTaskPlan() {
        return taskPlan;
    }

    public void setTaskPlan(String taskPlan) {
        this.taskPlan = taskPlan;
    }

    public String getTaskDescribe() {
        return taskDescribe;
    }

    public void setTaskDescribe(String taskDescribe) {
        this.taskDescribe = taskDescribe;
    }

    public String getTaskResults() {
        return taskResults;
    }

    public void setTaskResults(String taskResults) {
        this.taskResults = taskResults;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public String getApplicationSide() {
        return applicationSide;
    }

    public void setApplicationSide(String applicationSide) {
        this.applicationSide = applicationSide;
    }

    public Task() {
    }

    public Task(Integer id, String taskName, Integer taskType, String taskClassification, String taskSource, String startTime, String endTime, String cancelTime, String completetime, String assignedUserId, String responsibleUserId, String companyId, String taskAttachmentUrl, String taskPlan, String taskDescribe, String taskResults, String problemType, String applicationSide, String handlingopinions) {
        this.id = id;
        this.taskName = taskName;
        this.taskType = taskType;
        this.taskClassification = taskClassification;
        this.taskSource = taskSource;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cancelTime = cancelTime;
        this.completetime = completetime;
        this.assignedUserId = assignedUserId;
        this.responsibleUserId = responsibleUserId;
        this.companyId = companyId;
        this.taskAttachmentUrl = taskAttachmentUrl;
        this.taskPlan = taskPlan;
        this.taskDescribe = taskDescribe;
        this.taskResults = taskResults;
        this.problemType = problemType;
        this.applicationSide = applicationSide;
        this.handlingopinions = handlingopinions;
    }
}

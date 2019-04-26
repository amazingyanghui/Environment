package com.tengdi.environmentalprotectionint.modules.emergency.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 应急预案
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:12:16
 */
@TableName("emergency_system_plan")
public class EmergencySystemPlanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键UUID
	 */
	@TableId
	private String pid;
	/**
	 * 对应的污染源（企业）ID
	 */
	private String cid;
	/**
	 * 单位名称
	 */
	@TableField(exist = false)
	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 预案标题
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String planTitle;
	/**
	 * 预案类型
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer planType;
	/**
	 * 预案类型name
	 */
	@TableField(exist = false)
	private String planTypeName;
	/**
	 * 备案日期
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String recordDate;
	/**
	 * 批复单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String batchCompany;
	/**
	 * 批复时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String batchDate;
	/**
	 * 预案文档地址
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String preplanDocumentAddress;
	/**
	 * 预案单位（企业）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String preplanCompany;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 实施时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String implementationTime;
	/**
	 * 备案部门
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String recordDepartment;
	/**
	 * 预案评估
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String planEvaluation;
	/**
	 * 状态
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String status ;
	/**
	 * 状态name
	 */
	@TableField(exist = false)
	private String statusName;

	/**
	 * 企业环境风险等级划定年份
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String year;
	/**
	 * 是否编制突发环境事件应急预案
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String isOrganization;
	/**
	 * 是否进行突发环境事件应急预案备案
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String isFiling;
	/**
	 * 企业环境风险等级
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String riskLevel;

	public String getPlanTypeName() {
		return planTypeName;
	}

	public void setPlanTypeName(String planTypeName) {
		this.planTypeName = planTypeName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * 设置：主键UUID
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：主键UUID
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：对应的污染源（企业）ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：对应的污染源（企业）ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：预案标题
	 */
	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}
	/**
	 * 获取：预案标题
	 */
	public String getPlanTitle() {
		return planTitle;
	}
	/**
	 * 设置：预案类型
	 */
	public void setPlanType(Integer planType) {
		this.planType = planType;
	}
	/**
	 * 获取：预案类型
	 */
	public Integer getPlanType() {
		return planType;
	}
	/**
	 * 设置：备案日期
	 */
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	/**
	 * 获取：备案日期
	 */
	public String getRecordDate() {
		return recordDate;
	}
	/**
	 * 设置：批复单位
	 */
	public void setBatchCompany(String batchCompany) {
		this.batchCompany = batchCompany;
	}
	/**
	 * 获取：批复单位
	 */
	public String getBatchCompany() {
		return batchCompany;
	}
	/**
	 * 设置：批复时间
	 */
	public void setBatchDate(String batchDate) {
		this.batchDate = batchDate;
	}
	/**
	 * 获取：批复时间
	 */
	public String getBatchDate() {
		return batchDate;
	}
	/**
	 * 设置：预案文档地址
	 */
	public void setPreplanDocumentAddress(String preplanDocumentAddress) {
		this.preplanDocumentAddress = preplanDocumentAddress;
	}
	/**
	 * 获取：预案文档地址
	 */
	public String getPreplanDocumentAddress() {
		return preplanDocumentAddress;
	}
	/**
	 * 设置：预案单位（企业）
	 */
	public void setPreplanCompany(String preplanCompany) {
		this.preplanCompany = preplanCompany;
	}
	/**
	 * 获取：预案单位（企业）
	 */
	public String getPreplanCompany() {
		return preplanCompany;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedate() {
		return createdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 设置：实施时间
	 */
	public void setImplementationTime(String implementationTime) {
		this.implementationTime = implementationTime;
	}
	/**
	 * 获取：实施时间
	 */
	public String getImplementationTime() {
		return implementationTime;
	}
	/**
	 * 设置：备案部门
	 */
	public void setRecordDepartment(String recordDepartment) {
		this.recordDepartment = recordDepartment;
	}
	/**
	 * 获取：备案部门
	 */
	public String getRecordDepartment() {
		return recordDepartment;
	}
	/**
	 * 设置：预案评估
	 */
	public void setPlanEvaluation(String planEvaluation) {
		this.planEvaluation = planEvaluation;
	}
	/**
	 * 获取：预案评估
	 */
	public String getPlanEvaluation() {
		return planEvaluation;
	}


	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getIsOrganization() {
		return isOrganization;
	}

	public void setIsOrganization(String isOrganization) {
		this.isOrganization = isOrganization;
	}

	public String getIsFiling() {
		return isFiling;
	}

	public void setIsFiling(String isFiling) {
		this.isFiling = isFiling;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}
}

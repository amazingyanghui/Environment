package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;

/**
 * 固废治理设施
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:15
 */
@TableName("cominfo_measure_solidwaste")
public class CominfoMeasureSolidwasteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键UUID
	 */
	@TableId
	private String pid;
	/**
	 * 映射基本信息表主键（UUID）
	 */
	private String cid;
	/**
	 * 设施名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String measureName;
	/**
	 * 设施数量（台）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer measureNumber;
	/**
	 * 治理方式（数据字典）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer governanceMode;
	/**
	 * 治理方式名称
	 */
	@TableField(exist = false)
	private String governanceModeName;
	/**
	 * 储存能力(吨) 
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double storageCapacity;
	/**
	 * 投运日期
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String deliveryDate;
	/**
	 * 运行状态
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String runningState;
	/**
	 * 年处理量（吨）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double yearThroughput;
	/**
	 * 年运行费用（万元）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double yearOperatingCost;
	/**
	 * 备注
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String remarks;
	/**
	 * 创建时间
	 */
	private String createdate;
	/**
	 * 修改时间
	 */
	private String updatedate;
	/**
	 * 删除时间
	 */
	private String deletedate;
	/**
	 *单台设计能力
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String singleDesignCapability;
	/**
	 *日平均运行时间（小时）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String dayRuntime;
	/**
	 *治理期限
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String governanceLimit;
	/**
	 *验收意见
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String acceptanceOpinion;

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
	 * 设置：映射基本信息表主键（UUID）
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：映射基本信息表主键（UUID）
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：设施名称
	 */
	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}
	/**
	 * 获取：设施名称
	 */
	public String getMeasureName() {
		return measureName;
	}
	/**
	 * 设置：设施数量（台）
	 */
	public void setMeasureNumber(Integer measureNumber) {
		this.measureNumber = measureNumber;
	}
	/**
	 * 获取：设施数量（台）
	 */
	public Integer getMeasureNumber() {
		return measureNumber;
	}
	/**
	 * 设置：治理方式（数据字典）
	 */
	public void setGovernanceMode(Integer governanceMode) {
		this.governanceMode = governanceMode;
	}
	/**
	 * 获取：治理方式（数据字典）
	 */
	public Integer getGovernanceMode() {
		return governanceMode;
	}

	public String getGovernanceModeName() {
		return governanceModeName;
	}

	public void setGovernanceModeName(String governanceModeName) {
		this.governanceModeName = governanceModeName;
	}

	/**
	 * 设置：储存能力(吨) 
	 */
	public void setStorageCapacity(Double storageCapacity) {
		this.storageCapacity = storageCapacity;
	}
	/**
	 * 获取：储存能力(吨) 
	 */
	public Double getStorageCapacity() {
		return storageCapacity;
	}
	/**
	 * 设置：投运日期
	 */
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	/**
	 * 获取：投运日期
	 */
	public String getDeliveryDate() {
		return deliveryDate;
	}
	/**
	 * 设置：运行状态
	 */
	public void setRunningState(String runningState) {
		this.runningState = runningState;
	}
	/**
	 * 获取：运行状态
	 */
	public String getRunningState() {
		return runningState;
	}
	/**
	 * 设置：年处理量（吨）
	 */
	public void setYearThroughput(Double yearThroughput) {
		this.yearThroughput = yearThroughput;
	}
	/**
	 * 获取：年处理量（吨）
	 */
	public Double getYearThroughput() {
		return yearThroughput;
	}
	/**
	 * 设置：年运行费用（万元）
	 */
	public void setYearOperatingCost(Double yearOperatingCost) {
		this.yearOperatingCost = yearOperatingCost;
	}
	/**
	 * 获取：年运行费用（万元）
	 */
	public Double getYearOperatingCost() {
		return yearOperatingCost;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreatedate() {
		return createdate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：修改时间
	 */
	public String getUpdatedate() {
		return updatedate;
	}
	/**
	 * 设置：删除时间
	 */
	public void setDeletedate(String deletedate) {
		this.deletedate = deletedate;
	}
	/**
	 * 获取：删除时间
	 */
	public String getDeletedate() {
		return deletedate;
	}

	public String getSingleDesignCapability() {
		return singleDesignCapability;
	}

	public void setSingleDesignCapability(String singleDesignCapability) {
		this.singleDesignCapability = singleDesignCapability;
	}

	public String getDayRuntime() {
		return dayRuntime;
	}

	public void setDayRuntime(String dayRuntime) {
		this.dayRuntime = dayRuntime;
	}

	public String getGovernanceLimit() {
		return governanceLimit;
	}

	public void setGovernanceLimit(String governanceLimit) {
		this.governanceLimit = governanceLimit;
	}

	public String getAcceptanceOpinion() {
		return acceptanceOpinion;
	}

	public void setAcceptanceOpinion(String acceptanceOpinion) {
		this.acceptanceOpinion = acceptanceOpinion;
	}
}

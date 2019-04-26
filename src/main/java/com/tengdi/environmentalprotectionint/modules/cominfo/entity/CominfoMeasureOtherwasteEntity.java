package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;

/**
 * 其他治理设施
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:20
 */
@TableName("cominfo_measure_otherwaste")
public class CominfoMeasureOtherwasteEntity implements Serializable {
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
	 * 设施功能
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String measureFunction;
	/**
	 * 处理工艺
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String process;
	/**
	 * 对应排污口
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String blowdownOutlet;
	/**
	 * 对应排污口name
	 */
	@TableField(exist = false)
	private String blowDownOutLetName;

	public String getBlowDownOutLetName() {
		return blowDownOutLetName;
	}

	public void setBlowDownOutLetName(String blowDownOutLetName) {
		this.blowDownOutLetName = blowDownOutLetName;
	}

	/**
	 * 投运日期
	 */
	private String deliveryDate;
	/**
	 * 运行状态
	 */
	private String runningState;
	/**
	 * 年处理量（吨）
	 */
	private Double yearThroughput;
	/**
	 * 年运行费用（万元）
	 */
	private Double yearOperatingCost;
	/**
	 * 备注
	 */
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
	private String singleDesignCapability;
	/**
	 *日平均运行时间（小时）
	 */
	private String dayRuntime;
	/**
	 *治理期限
	 */
	private String governanceLimit;
	/**
	 *验收意见
	 */
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
	 * 设置：设施功能
	 */
	public void setMeasureFunction(String measureFunction) {
		this.measureFunction = measureFunction;
	}
	/**
	 * 获取：设施功能
	 */
	public String getMeasureFunction() {
		return measureFunction;
	}
	/**
	 * 设置：处理工艺
	 */
	public void setProcess(String process) {
		this.process = process;
	}
	/**
	 * 获取：处理工艺
	 */
	public String getProcess() {
		return process;
	}
	/**
	 * 设置：对应排污口
	 */
	public void setBlowdownOutlet(String blowdownOutlet) {
		this.blowdownOutlet = blowdownOutlet;
	}
	/**
	 * 获取：对应排污口
	 */
	public String getBlowdownOutlet() {
		return blowdownOutlet;
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

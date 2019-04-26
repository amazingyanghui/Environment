package com.tengdi.environmentalprotectionint.modules.greentax.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 噪音环保税上报
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-06 09:51:49
 */
@TableName("ep_noise_tax")
public class EpNoiseTaxEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 噪音源ID
	 */
	private String dischargeId;
	/**
	 * 处置方式
	 */
	private String dispostionType;
	/**
	 * 分贝数
	 */
	private String decibelNumber;
	/**
	 * 超标分贝
	 */
	private String overDecibel;
	/**
	 * 超标天数
	 */
	private String overDays;
	/**
	 * 上报区间
	 */
	private String reportSection;
	/**
	 * 0 未提交 1 已提交，待审核 2 已审核  
	 */
	private String status;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 创建用户
	 */
	private String createUser;
	/**
	 *税源编号
	 * @return
	 */
    @TableField(exist = false)
	private String taxSourceCode;
	/**
	 * 监控点类型(0：废水；1：废气；2：VOCs)
	 */
    @TableField(exist = false)
	private Integer monitorType;
	/**
	 * 监控点名称
	 */
    @TableField(exist = false)
	private String monitorName;
	/**
	 *监控点位置
	 * @return
	 */
    @TableField(exist = false)
	private String monitorPosition;
	/**
	 *功能区分类
	 * @return
	 */
    @TableField(exist = false)
	private Integer domainType;

	/**
	 *是否昼夜产生(0：否；1：是)
	 * @return
	 */
    @TableField(exist = false)
	private Integer dayAndNight;
	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：噪音源ID
	 */
	public void setDischargeId(String dischargeId) {
		this.dischargeId = dischargeId;
	}
	/**
	 * 获取：噪音源ID
	 */
	public String getDischargeId() {
		return dischargeId;
	}
	/**
	 * 设置：处置方式
	 */
	public void setDispostionType(String dispostionType) {
		this.dispostionType = dispostionType;
	}
	/**
	 * 获取：处置方式
	 */
	public String getDispostionType() {
		return dispostionType;
	}
	/**
	 * 设置：分贝数
	 */
	public void setDecibelNumber(String decibelNumber) {
		this.decibelNumber = decibelNumber;
	}
	/**
	 * 获取：分贝数
	 */
	public String getDecibelNumber() {
		return decibelNumber;
	}
	/**
	 * 设置：超标分贝
	 */
	public void setOverDecibel(String overDecibel) {
		this.overDecibel = overDecibel;
	}
	/**
	 * 获取：超标分贝
	 */
	public String getOverDecibel() {
		return overDecibel;
	}
	/**
	 * 设置：超标天数
	 */
	public void setOverDays(String overDays) {
		this.overDays = overDays;
	}
	/**
	 * 获取：超标天数
	 */
	public String getOverDays() {
		return overDays;
	}
	/**
	 * 设置：0 未提交 1 已提交，待审核 2 已审核  
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：0 未提交 1 已提交，待审核 2 已审核  
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：创建用户
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建用户
	 */
	public String getCreateUser() {
		return createUser;
	}

	public String getReportSection() {
		return reportSection;
	}

	public void setReportSection(String reportSection) {
		this.reportSection = reportSection;
	}

	public String getTaxSourceCode() {
		return taxSourceCode;
	}

	public void setTaxSourceCode(String taxSourceCode) {
		this.taxSourceCode = taxSourceCode;
	}

	public Integer getMonitorType() {
		return monitorType;
	}

	public void setMonitorType(Integer monitorType) {
		this.monitorType = monitorType;
	}

	public String getMonitorName() {
		return monitorName;
	}

	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}

	public String getMonitorPosition() {
		return monitorPosition;
	}

	public void setMonitorPosition(String monitorPosition) {
		this.monitorPosition = monitorPosition;
	}

	public Integer getDomainType() {
		return domainType;
	}

	public void setDomainType(Integer domainType) {
		this.domainType = domainType;
	}

	public Integer getDayAndNight() {
		return dayAndNight;
	}

	public void setDayAndNight(Integer dayAndNight) {
		this.dayAndNight = dayAndNight;
	}
}
